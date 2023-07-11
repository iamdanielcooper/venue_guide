package com.example.venue_guide.users

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class UsersService(val db: JdbcTemplate) {

    fun addUser(user: User) = "Adding user to database"

    fun getAllUsers() = "Getting all users"

    fun deleteUser(userName: String) = "Deleting user $userName's data"

}