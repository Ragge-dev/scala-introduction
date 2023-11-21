package com.kognic.tutorial.service

import com.kognic.tutorial.repo.UserRepo
import org.scalamock.scalatest.MockFactory
import org.scalatest.funsuite.AnyFunSuite

import com.kognic.tutorial.User

class UserServiceTest extends AnyFunSuite with MockFactory {
  test("UserService should return list of users") {
    val userRepo = mock[UserRepo]
    (userRepo.getUser _)
      .expects(1)
      .returning(User(id = 1, name = "Filip", age = 25))

    val userService = new UserServiceImpl(userRepo)

    val actualUsers = userService.getUsers(List(1))
    val expectedUsers = List(User(id = 1, name = "Filip", age = 25))
    assert(actualUsers == expectedUsers)
  }
}
