package net.numa08.gitlab

import net.numa08.service.Service
import net.numa08.task.Task
import org.gitlab.api.GitlabAPI
import net.numa08.kagemai.Report
import com.typesafe.scalalogging.slf4j.Logging
import org.gitlab.api.models.GitlabIssue

class Gitlab(e: String, id: Int, t: String) extends Service with Logging {
  override val entryPoint: String = e
  override val token: String = t
  override val projectId: Int = id

  override def createTask(task: Task): Unit = {
    Option(task)
      .collect { case t: Issue => t }
      .map { issue =>
        val gitlabIssue = GitlabAPI.connect(entryPoint, token)
          .createIssue(projectId, 0, 0, "", issue.description, issue.title)
        logger.info(s"Create issue ${gitlabIssue.getId} : ${gitlabIssue.getTitle}")
        (issue, gitlabIssue)
      }
      .filter { issues =>
        Report.Status.inactive.contains(issues._1.report.status)
      }
      .map { issues =>
        GitlabAPI.connect(entryPoint, token)
          .editIssue(projectId, issues._2.getId, 0, 0, null, issues._2.getDescription, issues._2.getTitle, GitlabIssue.Action.CLOSE)

        logger.info(s"Edit issue ${issues._2.getId} : ${issues._2.getTitle} to CLOSE")
      }

  }

}