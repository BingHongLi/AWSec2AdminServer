
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Welcome to Play Framework")/*3.35*/ {_display_(Seq[Any](format.raw/*3.37*/("""

    """),format.raw/*5.5*/("""<div class="well">
        <h1>"""),_display_(/*6.14*/message),format.raw/*6.21*/("""</h1>
    </div>

""")))}),format.raw/*9.2*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Sat Nov 21 17:30:17 CST 2015
                  SOURCE: /home/cirrusdi/AwsEc2AdminServer/app/views/index.scala.html
                  HASH: 5aa97dabcc7cbc9a99cd16fd6ef401d2fb6bac64
                  MATRIX: 527->1|639->18|667->21|708->54|747->56|779->62|837->94|864->101|912->120
                  LINES: 20->1|25->1|27->3|27->3|27->3|29->5|30->6|30->6|33->9
                  -- GENERATED --
              */
          