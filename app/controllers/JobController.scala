package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
// you need this import to have combinators
import play.api.libs.functional.syntax._
import models.JobRequest

object JobController extends Controller {

  implicit val JobRequestFormat = Json.format[JobRequest]

  def submitJob = Action { request =>
    request.body.asJson.map { json =>

      json.validate[JobRequest].map{ 
        case job:JobRequest => Ok(s"nthFibonacci for ${job.id}, ${job.userId}, ${job.nthFibonacci}")
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


  def getJobList(page : Long) = Action {
    Ok(s"get job list with page: $page")
  }

}