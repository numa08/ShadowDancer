package net.numa08.kagemai

import org.scalatest.FunSuite
import scala.xml.XML

class ReportTest extends FunSuite {

  test("parse id") {
    val xml = XML.loadString("""<?kagemai version="1.0" encoding="EUC-JP"?> <report id="1"> <message id="1" date="2014-04-06 00:11:20" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">&quot;光を求めよ&quot;&#x000a;&#x000a;&#x000a;ある者がそう言った。それがキッカケだ。その日、全てが崩壊した。&#x000a;&#x000a;難民たちは、新天地を求めた。偽善者は彼らを導いた。そして、最後に残った者達を、生きることを放棄した者とみなし、あざ笑った。&#x000a;&#x000a;たとえ、彼らの持つものが真の愛であったとしても。</element> <element id="attachment">1,digi-charat_186096.jpg,186096,image/jpeg,,1396710680,false</element> <option id="email_notification" value="false" /> </message> <message id="2" date="2014-04-06 00:11:55" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">愛など粘液が生み出す幻想にすぎない</element> <element id="attachment"></element> <option id="email_notification" value="false" /> </message> </report>""")
    val report = Report.byXml(xml)

    assert(report.id == 1)
  }

  test("parse title") {
    val xml = XML.loadString("""<?kagemai version="1.0" encoding="EUC-JP"?> <report id="1"> <message id="1" date="2014-04-06 00:11:20" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">&quot;光を求めよ&quot;&#x000a;&#x000a;&#x000a;ある者がそう言った。それがキッカケだ。その日、全てが崩壊した。&#x000a;&#x000a;難民たちは、新天地を求めた。偽善者は彼らを導いた。そして、最後に残った者達を、生きることを放棄した者とみなし、あざ笑った。&#x000a;&#x000a;たとえ、彼らの持つものが真の愛であったとしても。</element> <element id="attachment">1,digi-charat_186096.jpg,186096,image/jpeg,,1396710680,false</element> <option id="email_notification" value="false" /> </message> <message id="2" date="2014-04-06 00:11:55" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">愛など粘液が生み出す幻想にすぎない</element> <element id="attachment"></element> <option id="email_notification" value="false" /> </message> </report>""")
    val report = Report.byXml(xml)

    assert(report.id == 1)
  }

  test("parse email") {
    val xml = XML.loadString("""<?kagemai version="1.0" encoding="EUC-JP"?> <report id="1"> <message id="1" date="2014-04-06 00:11:20" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">&quot;光を求めよ&quot;&#x000a;&#x000a;&#x000a;ある者がそう言った。それがキッカケだ。その日、全てが崩壊した。&#x000a;&#x000a;難民たちは、新天地を求めた。偽善者は彼らを導いた。そして、最後に残った者達を、生きることを放棄した者とみなし、あざ笑った。&#x000a;&#x000a;たとえ、彼らの持つものが真の愛であったとしても。</element> <element id="attachment">1,digi-charat_186096.jpg,186096,image/jpeg,,1396710680,false</element> <option id="email_notification" value="false" /> </message> <message id="2" date="2014-04-06 00:11:55" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">愛など粘液が生み出す幻想にすぎない</element> <element id="attachment"></element> <option id="email_notification" value="false" /> </message> </report>""")
    val report = Report.byXml(xml)

    assert(report.email == "numa08@numa.jp")
  }

  test("parse body") {
    val xml = XML.loadString("""<?kagemai version="1.0" encoding="EUC-JP"?> <report id="1"> <message id="1" date="2014-04-06 00:11:20" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">&quot;光を求めよ&quot;&#x000a;&#x000a;&#x000a;ある者がそう言った。それがキッカケだ。その日、全てが崩壊した。&#x000a;&#x000a;難民たちは、新天地を求めた。偽善者は彼らを導いた。そして、最後に残った者達を、生きることを放棄した者とみなし、あざ笑った。&#x000a;&#x000a;たとえ、彼らの持つものが真の愛であったとしても。</element> <element id="attachment">1,digi-charat_186096.jpg,186096,image/jpeg,,1396710680,false</element> <option id="email_notification" value="false" /> </message> <message id="2" date="2014-04-06 00:11:55" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">愛など粘液が生み出す幻想にすぎない</element> <element id="attachment"></element> <option id="email_notification" value="false" /> </message> </report>""")
    val report = Report.byXml(xml)

    assert(report.body == """"光を求めよ"


ある者がそう言った。それがキッカケだ。その日、全てが崩壊した。

難民たちは、新天地を求めた。偽善者は彼らを導いた。そして、最後に残った者達を、生きることを放棄した者とみなし、あざ笑った。

たとえ、彼らの持つものが真の愛であったとしても。""")
  }

  test("no body") {
    val xml = XML.loadString("""<?kagemai version="1.0" encoding="EUC-JP"?> <report id="1"> <message id="1" date="2014-04-06 00:11:20" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element>  <element id="attachment">1,digi-charat_186096.jpg,186096,image/jpeg,,1396710680,false</element> <option id="email_notification" value="false" /> </message> <message id="2" date="2014-04-06 00:11:55" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">愛など粘液が生み出す幻想にすぎない</element> <element id="attachment"></element> <option id="email_notification" value="false" /> </message> </report>""")
    val report = Report.byXml(xml)

    assert(report.body == "")
  }

  test("no email") {
    val xml = XML.loadString("""<?kagemai version="1.0" encoding="EUC-JP"?> <report id="1"> <message id="1" date="2014-04-06 00:11:20" hide="false" ip_addr="10.0.2.2"> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element>  <element id="attachment">1,digi-charat_186096.jpg,186096,image/jpeg,,1396710680,false</element> <option id="email_notification" value="false" /> </message> <message id="2" date="2014-04-06 00:11:55" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">愛など粘液が生み出す幻想にすぎない</element> <element id="attachment"></element> <option id="email_notification" value="false" /> </message> </report>""")
    val report = Report.byXml(xml)

    assert(report.email == "")
  }

  test("no title") {
    val xml = XML.loadString("""<?kagemai version="1.0" encoding="EUC-JP"?> <report > <message id="1" date="2014-04-06 00:11:20" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="status">新規</element>  <element id="attachment">1,digi-charat_186096.jpg,186096,image/jpeg,,1396710680,false</element> <option id="email_notification" value="false" /> </message> <message id="2" date="2014-04-06 00:11:55" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">愛など粘液が生み出す幻想にすぎない</element> <element id="attachment"></element> <option id="email_notification" value="false" /> </message> </report>""")
    val report = Report.byXml(xml)

    assert(report.title == "")
  }

  test("no id") {
    val xml = XML.loadString("""<?kagemai version="1.0" encoding="EUC-JP"?> <report> <message id="1" date="2014-04-06 00:11:20" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="status">新規</element>  <element id="attachment">1,digi-charat_186096.jpg,186096,image/jpeg,,1396710680,false</element> <option id="email_notification" value="false" /> </message> <message id="2" date="2014-04-06 00:11:55" hide="false" ip_addr="10.0.2.2"> <element id="email">numa08@numa.jp</element> <element id="title">世界の終わりのその時に</element> <element id="status">新規</element> <element id="body">愛など粘液が生み出す幻想にすぎない</element> <element id="attachment"></element> <option id="email_notification" value="false" /> </message> </report>""")
    val report = Report.byXml(xml)

    assert(report.id == -1)
  }

  test("load file") {
    val xml = XML.loadFile("1.xml")
    val report = Report.byXml(xml)

    assert(report.id == 1)
  }

  test("ja name to Status") {
    val jaName = "新規"
    val status = Report.Status.withJAName(jaName)
    assert(status == Report.Status.New)
  }

  test("active status") {
    val s = Report.Status.New
    val active = Report.Status.active
    assert(active.contains(s))
  }
}
