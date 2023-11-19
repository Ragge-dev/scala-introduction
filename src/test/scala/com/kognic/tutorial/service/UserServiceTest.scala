package com.kognic.tutorial.service

import com.kognic.tutorial.repo.UserRepo
import org.scalamock.scalatest.MockFactory
import org.scalatest.funsuite.AnyFunSuite
import com.kognic.tutorial.User

class UserServiceTest extends AnyFunSuite with MockFactory {
  test("Should return list of users given valid userIds") {
    val userRepo = mock[UserRepo]
    (userRepo.getUser _)
      .expects(1)
      .returning(User(1, "Sandra", 25))

    val userService = new UserServiceImpl(userRepo)
    val userIds = Seq(1)
    val users = userService.getUsers(userIds)
    assert(users == Seq(User(1, "Sandra", 25)))
  }

  test("Should return error if error is thrown in repo") {
    val userRepo = mock[UserRepo]
    (userRepo.getUser _)
      .expects(*)
      .throwing(new NullPointerException)
      .anyNumberOfTimes()

    val userService = new UserServiceImpl(userRepo)
    val userIds = Seq(1)
    intercept[NullPointerException] {
      userService.getUsers(userIds)
    }
  }
}
