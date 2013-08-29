package controllers

import play.api._
import play.api.mvc._

object JobController extends Controller {
  
  def submitJob = Action {
    Ok("job submitted.")
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