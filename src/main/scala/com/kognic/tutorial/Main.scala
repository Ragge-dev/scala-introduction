package com.kognic.tutorial

import com.kognic.tutorial.repo.UserRepoImpl
import com.kognic.tutorial.service.UserServiceImpl

object Main extends App {
  val userRepo = UserRepoImpl
  val userService = new UserServiceImpl(userRepo)

  val userIds = List(1, 2)
  val users = userService.getUsers(userIds)
  println(s"FOUND USERS $users")
}