package net.numa08.dsl

import java.io.File

object BtsServices extends Enumeration {
  type BtsService = Value
  val Gitlab, Redmine = Value
}

object convention {
  implicit class ProjectDir(val path: String) extends AnyVal {
    def as(bts: BtsServices.BtsService): (String, BtsServices.BtsService) = (path, bts)
  }

  implicit class ProjectDirWith(val projectDir: (String, BtsServices.BtsService)) extends AnyVal {
    def at(project: String): ProjectService = {
      ProjectService(projectDir._1, projectDir._2, project)
    }
  }
}

case class ProjectService(path: String, service: BtsServices.BtsService, project: String) {

  def dir: File = new File(path)

}