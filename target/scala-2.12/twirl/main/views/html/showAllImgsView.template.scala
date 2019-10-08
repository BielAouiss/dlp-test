
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


Seq[Any](format.raw/*2.1*/("""<a href="/randomService" class="button">Random Image</a>
<ul>
"""),_display_(/*4.2*/for(index <- 0 until list.size) yield /*4.33*/ {_display_(Seq[Any](format.raw/*4.35*/("""
        """),format.raw/*5.9*/("""<li>
                <img src="""),_display_(/*6.27*/list/*6.31*/.get(index).getDownload_url()),format.raw/*6.60*/("""  """),format.raw/*6.62*/("""width ="200" height="250" ></img>
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
                  DATE: Tue Oct 08 20:01:46 CEST 2019
                  SOURCE: /home/bilel/Desktop/TestTechnique/dlp-test/app/views/showAllImgsView.scala.html
                  HASH: d3d0ee183eafa85bb37ccae9b0582e6d569757b7
                  MATRIX: 966->1|1082->24|1170->87|1216->118|1255->120|1290->129|1347->160|1359->164|1408->193|1437->195|1515->244|1546->248
                  LINES: 28->1|33->2|35->4|35->4|35->4|36->5|37->6|37->6|37->6|37->6|39->8|43->12
                  -- GENERATED --
              */
          