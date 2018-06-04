package com.mblinn.oo.tinyweb.steptwo

import com.mblinn.oo.tinyweb.HttpRequest
import com.mblinn.oo.tinyweb.HttpResponse
import com.mblinn.oo.tinyweb.ControllerException
import com.mblinn.oo.tinyweb.RederingException

trait Controller {
  def handleRequest(httpRequest: HttpRequest): HttpRequest
}

class FunctionController(view: View, doRequest: (HttpRequest) => Map[String, List[String]]) extends Controller {
  var responseCode = 200
  var responseBody = ""

  try {
    val model = doRequest(request)
    responseBody = view.render(model)
  } catch {
    case e : Controller => responseCode = e.getStatusCOde()
    case e : RenderException => {
      respnoseCode = 500
      responseBody = "Exception while rendering"
    }
    case e : Exception => responseCode = 500
  }

  HttpResponse.Builder.newBuilder()
      .body(responseBody).responseCode(responseCode).build()
}