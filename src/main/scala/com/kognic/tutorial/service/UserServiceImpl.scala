package com.kognic.tutorial.service

import com.kognic.tutorial.User
import com.kognic.tutorial.repo.UserRepo

class UserServiceImpl(userRepo: UserRepo) extends UserService {
  override def getUsers(userIds: Seq[Int]): Seq[User] =
    userIds.map(id => userRepo.getUser(id))
}
