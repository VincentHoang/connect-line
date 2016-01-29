package controllers

import play.api.Play.current
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    val testVh: TestVH = new TestVH
    testVh.printSomething()
    Ok(views.html.index("Your new application is ready."))
  }
  
  def socket = WebSocket.acceptWithActor[String, String] { request => out =>
    println("Hello socket")
    WebSocketActor.props(out)
  }

}
