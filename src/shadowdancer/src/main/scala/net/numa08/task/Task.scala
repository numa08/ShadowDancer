package net.numa08.task

import net.numa08.kagemai.Report

trait Task {

  val report: Report

  def title: String
  def description: String
}
