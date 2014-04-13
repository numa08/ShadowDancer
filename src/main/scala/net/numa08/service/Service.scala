package net.numa08.service

import net.numa08.task.Task

trait Service {
  val entryPoint: String
  val projectId: Int
  val token: String

  def createTask(task: Task)
}
