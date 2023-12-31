package com.kognic.tutorial.repo

import com.kognic.tutorial.User
import spray.json.DefaultJsonProtocol._
import spray.json._

import java.nio.file.Path
import scala.io.Source
import scala.util.{Failure, Success, Using}

object UserRepoImpl extends UserRepo {
  override def getUser(userId: Int): User =
    Using(openSource(userId))(id => parseUser(id)) match {
      case Failure(exception) => throw exception
      case Success(user) => user
    }

  private def openSource(userId: Int): Source = {
    val userPath = Path.of(s"/user_$userId.json")
    val inputStream = getClass.getResourceAsStream(userPath.toString)
    if (inputStream == null)
      throw new NullPointerException("User not found")
    else
      Source.fromInputStream(inputStream)
  }

  private def parseUser(userSource: Source): User = {
    implicit val userJsonFormat: RootJsonFormat[User] = jsonFormat3(User.apply)
    userSource.getLines.mkString.parseJson.convertTo[User]
  }
}
