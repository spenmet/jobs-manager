package models

import play.api.libs.json._


case class JobRequest(id: Option[Long], userId:String, nthFibonacci:Int)

object JobRequest {
  implicit val implicitJobResponseWrites = new Writes[JobRequest] {
    def writes(jobRequest: JobRequest): JsValue = {
      Json.obj(
        "id" -> jobRequest.id,
        "userId" -> jobRequest.userId,
        "nthFibonacci" -> jobRequest.nthFibonacci
      )
    }
  }
}


case class JobResponse(jobId: Option[Long], result:Option[Long], error:String)

object JobResponse {
  implicit val implicitJobResponseWrites = new Writes[JobResponse] {
    def writes(jobResponse: JobResponse): JsValue = {
      Json.obj(
        "jobId" -> jobResponse.jobId,
        "result" -> jobResponse.result,
        "error" -> jobResponse.error
      )
    }
  }
}


