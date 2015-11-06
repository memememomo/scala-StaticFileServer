package controllers

import java.io.File

import play.api._
import play.api.mvc._

object Application extends Controller {
  def download(name: String) = Action {
    var file = new File("public/%s".format(name))
    if (file.exists()) {
      Ok.sendFile(
        content = file,
        inline = true
      )
    } else {
      NotFound
    }
  }
}