
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
<head>
    <title>"""),_display_(/*6.13*/title),format.raw/*6.18*/("""</title>

    <style>
    body """),format.raw/*9.10*/("""{"""),format.raw/*9.11*/("""
        """),format.raw/*10.9*/("""margin-top: 50px;
    """),format.raw/*11.5*/("""}"""),format.raw/*11.6*/("""
    """),format.raw/*12.5*/("""</style>
</head>
<body>
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a id="titleLink" class="brand" href="/">"""),_display_(/*18.59*/title),format.raw/*18.64*/("""</a>
            </div>
        </div>
    </div>
    <div class="container">
        """),_display_(/*23.10*/content),format.raw/*23.17*/("""
    """),format.raw/*24.5*/("""</div>
</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Sun Nov 01 10:53:31 CST 2015
                  SOURCE: /home/cirrusdi/testPlay/app/views/main.scala.html
                  HASH: 12ece10381b647ce6d74469c8cca84b33351bb7e
                  MATRIX: 530->1|655->31|683->33|751->75|776->80|834->111|862->112|898->121|947->143|975->144|1007->149|1235->350|1261->355|1375->442|1403->449|1435->454
                  LINES: 20->1|25->1|27->3|30->6|30->6|33->9|33->9|34->10|35->11|35->11|36->12|42->18|42->18|47->23|47->23|48->24
                  -- GENERATED --
              */
          