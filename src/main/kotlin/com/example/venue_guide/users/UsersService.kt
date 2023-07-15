package com.example.venue_guide.users

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.query
import java.util.*

@Service
class UsersService(val db: JdbcTemplate) {

    fun addUser(user: User) {
        val id = user.id ?: UUID.randomUUID().toString()

        if (findUserById(user.username).isNotEmpty()) {
            throw IllegalStateException("Username already used")
        }

        db.update("insert into users values ( ?, ?, ?, ?)",
            id, user.username, user.email, user.password)
    }

    fun getAllUsers(): List<User> = db.query("select * from users") { response, _ ->
        User(
            response.getString("id"),
            response.getString("username"),
            response.getString("email"),
            response.getString("password")
            )
    }


    fun deleteUser(username: String): String {
        val person = arrayOf(username)
        val result = db.update("delete from users where username = ?", person)

        return if (result >= 1) "User Removed" else "User not Removed"

    }

    fun findUserById(username: String): List<User> = db.query("select * from users where username = ?", username) { response, _ ->
        User(
            response.getString("id"),
            response.getString("username"),
            response.getString("email"),
            response.getString("password")
        )
    }

}