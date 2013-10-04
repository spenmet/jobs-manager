package actor

import akka.actor.Actor
import models._

class FibonacciActor extends Actor {
	
	def receive = {
		case job:JobRequest => {
			sender ! JobResponse(job.id, Some(fibonacci(job.nthFibonacci)), "") 
		}
	}

	def fibonacci(n:Int):Long = {
		n match {
			case 0 => 0
			case 1 => 1
			case _ =>  fibonacci(n-1) + fibonacci(n-2)
		}
	}
}