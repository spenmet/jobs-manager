package actor

import akka.actor.Actor
import models._
import scala.annotation.tailrec

class FibonacciActor extends Actor {
	
	def receive = {
		case job:JobRequest => {
			sender ! JobResponse(job.id, Some(fibonacci(job.nthFibonacci)), "") 
		}
	}

	
	def fibonacci(n:Int):BigInt = {
		
	  @tailrec
	   def calcFib(acc:BigInt, n:Int):BigInt = {
		  n match {
		    case 1 => acc
		    case _ => calcFib(acc * n, n-1)
		  }
		}
		
	   n match {
	     case 0 => 0
	     case 1 => 1
	     case _ => calcFib(1, n)
	   }
		
	}
}