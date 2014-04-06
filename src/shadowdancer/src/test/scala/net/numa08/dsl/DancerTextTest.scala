package net.numa08.dsl

import org.scalatest.FunSuite
import net.numa08.dsl.convention._
import net.numa08.dsl.BtsServices._

class DancerTextTest extends FunSuite {

  test("Create Project Service") {
    val projectService = "dir" as Gitlab at "project"
    assert(projectService.dir.getPath == "dir")
    assert(projectService.service == Gitlab)
    assert(projectService.project == "project")
  }
}
