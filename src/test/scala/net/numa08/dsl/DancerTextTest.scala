package net.numa08.dsl

import org.scalatest.FunSuite
import net.numa08.dsl.convention._
import net.numa08.dsl.BtsServices._

class DancerTextTest extends FunSuite {

  test("Create Project Service") {
    val projectService = "dir" as Gitlab at 1 on "http://kagemai.example.com/html/guest.cgi?project=Shadow_dancer"
    assert(projectService.dir.getPath == "dir")
    assert(projectService.service == Gitlab)
    assert(projectService.project == 1)
    assert(projectService.url == "http://kagemai.example.com/html/guest.cgi?project=Shadow_dancer")
  }

  test("create project with service") {

    val dancerText = DancerText { service =>
      service.redmine.entryPoint = "http://redmine.numa08.jp"
      service.redmine.token = "redminetoken"

      service.gitlab.entryPoint = "http://gitlab.numa08.jp"
      service.gitlab.token = "gitlabtoken"

      service.xmlPaths += "dir" as Gitlab at 1 on "http://kagemai.example.com/html/guest.cgi?project=Shadow_dancer"
    }

    assert(dancerText.services.redmine.entryPoint == "http://redmine.numa08.jp")
    assert(dancerText.services.redmine.token == "redminetoken")
    assert(dancerText.services.gitlab.entryPoint == "http://gitlab.numa08.jp")
    assert(dancerText.services.gitlab.token == "gitlabtoken")
  }
}
