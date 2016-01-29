package controllers

import akka.actor.{Props, Actor}

object PlayerActor {
  def props = Props(new PlayerActor)
}

class PlayerActor extends Actor {
  
  override def receive: Receive = {
    case msg => msg
  }
}
