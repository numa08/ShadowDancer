package net.numa08.gitlab

import net.numa08.service.Service
import net.numa08.task.Task
import org.gitlab.api.GitlabAPI

class Gitlab(e: String, id: Int, t: String) extends Service {
  override val entryPoint: String = e
  override val token: String = t
  override val projectId: Int = id

  override def createTask(task: Task): Unit = {
    Option(task)
      .collect { case t: Issue => t }
      .map { issue =>
        GitlabAPI.connect(entryPoint, token)
          .createIssue(projectId, 0, 0, "", issue.description, issue.title)
      }
  }

}