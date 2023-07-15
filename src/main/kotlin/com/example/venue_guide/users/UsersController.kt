package com.example.venue_guide.users

import jakarta.websocket.server.PathParam
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(val service: UsersService) {

    @PostMapping("/api/v1/users")
    fun addUser(@RequestBody requestBody: User) = service.addUser(requestBody)

    @GetMapping("/api/v1/users")
    fun getAllUsers() = service.getAllUsers()

    @DeleteMapping("/api/v1/users/{username}")
    fun deleteUser(@PathVariable username: String) = service.deleteUser(username)

}