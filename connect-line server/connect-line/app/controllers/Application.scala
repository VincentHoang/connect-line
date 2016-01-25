package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    val testVh: TestVH = new TestVH
    testVh.printSomething()
    Ok(views.html.index("Your new application is ready."))
  }

}
