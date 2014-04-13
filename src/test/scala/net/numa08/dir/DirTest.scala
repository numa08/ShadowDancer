package net.numa08.dir

import org.scalatest.FunSuite
import java.io.File

class DirTest extends FunSuite {

  test("Create valid directory") {
    val dir = Dir(new File(("/")))
    assert(dir.isInstanceOf[ValidDir])
  }

  test("Create invalid directoru") {
    val dir = Dir(new File("hohohoho"))
    assert(dir.isInstanceOf[InvalidDir])
  }
}
