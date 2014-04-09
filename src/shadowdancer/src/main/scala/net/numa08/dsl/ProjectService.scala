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
    def at(project: Int): (String, BtsServices.BtsService, Int) = {
      (projectDir._1, projectDir._2, project)
    }
  }

  implicit class ProjectServiceWith(val projectService: (String, BtsServices.BtsService, Int)) extends AnyVal {
    def on(url: String): ProjectService = {
      ProjectService(projectService._1, projectService._2, projectService._3, url)
    }
  }
}

case class ProjectService(path: String, service: BtsServices.BtsService, project: Int, url: String) {

  def dir: File = new File(path)

}