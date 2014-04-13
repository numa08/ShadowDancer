package net.numa08.gitlab

import net.numa08.task.Task
import net.numa08.kagemai.Report
import java.net.URL

case class Issue(r: Report, kagemaiUrl: URL) extends Task {

  override val report = r

  override def title = report.title

  override def description = report.body + "\n\n" + kagemaiUrl
}
