package net.numa08.dsl

import scala.collection.mutable.ArrayBuffer

object DancerText {
  def apply(block: Services => Unit): DancerText = {
    val xmlPaths = ArrayBuffer[ProjectService]()
    val services = new Services(xmlPaths)
    block(services)
    new DancerText(services, services.xmlPaths)
  }
}

protected case class DancerText(services: Services, xmlPats: ArrayBuffer[ProjectService])

trait service {
  var entryPoint: String
  var token: String
}

class Redmine extends service {
  override var entryPoint: String = _
  override var token: String = _
}

class Gitlab extends service {
  override var entryPoint: String = _
  override var token: String = _
}

class Services(val xmlPaths: ArrayBuffer[ProjectService]) {
  val gitlab = new Gitlab
  val redmine = new Redmine
}