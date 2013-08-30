package models

case class JobRequest(id: Option[Long], userId:String, nthFibonacci:Int)

case class JobResponse(result:Long)

case class JobError(error:String)
