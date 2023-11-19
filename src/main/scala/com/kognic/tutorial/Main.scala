package com.kognic.tutorial

import com.kognic.tutorial.repo.{UserRepo, UserRepoImpl}
import com.kognic.tutorial.service.UserServiceImpl

object Main extends App {
  val userRepo: UserRepo = UserRepoImpl
  val userService = new UserServiceImpl(UserRepoImpl)
  val userIds = Seq(1, 2)
  val users = userService.getUsers(userIds)
  println(users)
}