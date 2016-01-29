package controllers.connectline

import akka.actor.{Actor, ActorRef, Props}

object GameActor {
  def props(playerOneActor: ActorRef, playerTwoActor: ActorRef) = Props(new GameActor(playerOneActor, playerTwoActor))
}

class GameActor(playerOneActor: ActorRef, playerTwoActor: ActorRef) extends Actor {
  override def receive: Receive = {
    case msg => msg
  }
}
