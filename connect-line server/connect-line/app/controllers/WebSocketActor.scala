package controllers

import akka.actor._

object WebSocketActor {
    def props(out: ActorRef) = Props(new WebSocketActor(out))
}

class WebSocketActor(out: ActorRef) extends Actor {
  override def receive = {
    case msg: String => {
      println(msg)
      out ! "yay!!!!"
    }
  }
}
