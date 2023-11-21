package com.kognic.tutorial.repo

import com.kognic.tutorial.User

import java.nio.file.Path
import scala.io.Source

import spray.json._

object UserRepoImpl extends UserRepo {
  override def getUser(userId: Int): User = ???

  private def openSource(userId: Int): Source = {
    val userPath = Path.of(s"/user_$userId.json")
    val inputStream = getClass.getResourceAsStream(userPath.toString)
    if (inputStream == null)
      throw new NullPointerException("User not found")
    else
      Source.fromInputStream(inputStream)
  }

  private def parseUser(userSource: Source): User = {
    userSource.getLines.mkString.parseJson.convertTo[User]
  }
}
