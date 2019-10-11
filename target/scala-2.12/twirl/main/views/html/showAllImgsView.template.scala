
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

object showAllImgsView extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[ImageMap],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(list: List[ImageMap]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<input type="submit" onclick="location.href='/randomService';" value="Show One Image" />
<ul>
"""),_display_(/*4.2*/for(index <- 0 until list.size) yield /*4.33*/ {_display_(Seq[Any](format.raw/*4.35*/("""
        """),format.raw/*5.9*/("""<li>
                <img src="""),_display_(/*6.27*/list/*6.31*/.get(index).getDownload_url()),format.raw/*6.60*/("""  """),format.raw/*6.62*/("""width="200" height="250" ></img>
        </li>
""")))}),format.raw/*8.2*/("""



"""),format.raw/*12.1*/("""</ul>"""))
      }
    }
  }

  def render(list:List[ImageMap]): play.twirl.api.HtmlFormat.Appendable = apply(list)

  def f:((List[ImageMap]) => play.twirl.api.HtmlFormat.Appendable) = (list) => apply(list)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Oct 10 10:40:00 CEST 2019
                  SOURCE: /home/bilel/Desktop/TestTechnique/dlp-test/app/views/showAllImgsView.scala.html
                  HASH: 2114582c68a8fb4227553a21fd03eaf49832b635
                  MATRIX: 966->1|1082->24|1202->119|1248->150|1287->152|1322->161|1379->192|1391->196|1440->225|1469->227|1546->275|1577->279
                  LINES: 28->1|33->2|35->4|35->4|35->4|36->5|37->6|37->6|37->6|37->6|39->8|43->12
                  -- GENERATED --
              */
          