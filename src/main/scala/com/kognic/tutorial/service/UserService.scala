package com.kognic.tutorial.service

import com.kognic.tutorial.User

trait UserService {
  def getUsers(userIds: Seq[Int]): Seq[User]

}
