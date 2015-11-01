
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object queryEC2Info_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class queryEC2Info extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.16*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<h1>EC2 Instance Query Info</h1>
<p>Enter Your KeyID(not ssh key pem content)</p>
< method="post">
    <table>
        <tr>
            <td>
                KeyName:
            </td>
            <td>
                <input type="text" name="keyName"><br/>
            </td>
        </tr>
        <tr>
            <td>
                SystemPassword:
            </td>
            <td>
                <input type="text" name="systemPassword"><br/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>

</form>
<table border="True">
    <tr>
        <td>
            InstanceID
        </td>
        <td>
            Name
        </td>
        <td>
            Status
        </td>
        <td>
            PublicIp
        </td>
        <td>
            PrivateIp
        </td>
    </tr>
    """),_display_(/*56.6*/message),format.raw/*56.13*/("""
"""),format.raw/*57.1*/("""</table>



</body>
</html>"""))
      }
    }
  }

  def render(message:Html): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((Html) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object queryEC2Info extends queryEC2Info_Scope0.queryEC2Info
              /*
                  -- GENERATED --
                  DATE: Sun Nov 01 10:53:31 CST 2015
                  SOURCE: /home/cirrusdi/testPlay/app/views/queryEC2Info.scala.html
                  HASH: 7ccefbcb466db2df72fa808a5919bcbb9a2cb1d3
                  MATRIX: 539->1|648->15|675->16|1695->1010|1723->1017|1751->1018
                  LINES: 20->1|25->1|26->2|80->56|80->56|81->57
                  -- GENERATED --
              */
          