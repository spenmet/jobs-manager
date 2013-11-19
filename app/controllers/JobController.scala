package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.concurrent._
import play.api.Play.current
import models._
import actor.FibonacciActor
import akka.actor._
import scala.concurrent.Await
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent._
import scala.concurrent.duration._
import akka.routing._


object JobController extends Controller {

  implicit val JobRequestFormat = Json.format[JobRequest]

  val fibActor = Akka.system.actorOf(Props[FibonacciActor].withRouter(FromConfig()), "fibRouter")
  //val fibActor = Akka.system.actorOf(Props[FibonacciActor], "fibActor")


  def submitJob = Action { request =>
    request.body.asJson.map { json =>

      json.validate[JobRequest].map{ 
        case job:JobRequest => 
          val result = sendToFibonacciActor(job)
          Ok(Json.toJson(result))
      }.recoverTotal{
        e => BadRequest("Detected error:"+ JsError.toFlatJson(e))
      }
    }.getOrElse {
      BadRequest("Expecting Json data")
    }
  }

  
  def getJob(id : String) = Action {
    Ok(s"get job with id: $id")
  }


  def updateJob(id : String) = Action {
    Ok(s"update job with id: $id")
  }


  def cancelJob(id : String) = Action {
    Ok(s"cancel job with id: $id")
  }


  def getJobList = Action {
    val jobsList = Json.toJson(List(
    			JobRequest(Some(123),"joe",12,100), 
    			JobRequest(Some(124),"shmo",400,20),
    			JobRequest(Some(125),"guy", 33, 0)))
    Ok(jobsList)
  }

  def sendToFibonacciActor(job: JobRequest) = {

    implicit val timeout = Timeout(10 seconds)
    val future = fibActor ? job 
    

    try {
      Await.result(future, timeout.duration).asInstanceOf[JobResponse]
    } catch {
      case e: TimeoutException => 
        JobResponse(job.id, None, e.getMessage)
    }

    
  }

}