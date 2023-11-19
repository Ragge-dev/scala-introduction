package com.kognic.tutorial.repo

import com.kognic.tutorial.User

trait UserRepo {
  def getUser(userId: Int): User
}
