
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object random extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(list: List[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""

    """),format.raw/*4.5*/("""<ul>
    """),_display_(/*5.6*/for(url <- list) yield /*5.22*/ {_display_(Seq[Any](format.raw/*5.24*/("""
        """),format.raw/*6.9*/("""<li>
            <img src="""),_display_(/*7.23*/url),format.raw/*7.26*/("""  """),format.raw/*7.28*/("""width="250" height="250" />
        </li>
    """)))}),format.raw/*9.6*/("""



    """),format.raw/*13.5*/("""</ul>

"""))
      }
    }
  }

  def render(list:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(list)

  def f:((List[String]) => play.twirl.api.HtmlFormat.Appendable) = (list) => apply(list)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Oct 14 17:34:20 CEST 2019
                  SOURCE: /home/bilel/Desktop/TestTechnique/dlp-test/app/views/random.scala.html
                  HASH: 261f857a0141f8efbc289d450751a5f44017201c
                  MATRIX: 955->1|1069->22|1101->28|1136->38|1167->54|1206->56|1241->65|1294->92|1317->95|1346->97|1422->144|1457->152
                  LINES: 28->1|33->2|35->4|36->5|36->5|36->5|37->6|38->7|38->7|38->7|40->9|44->13
                  -- GENERATED --
              */
          