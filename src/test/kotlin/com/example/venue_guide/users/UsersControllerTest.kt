package com.example.venue_guide.users

import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import jdk.jfr.ContentType
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class UsersControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var usersService: UsersService

    @Test
    fun ifAllRequiredFieldsArePassedReturns200OK() {

        val testUser = User(
            "1",
            "Test",
            "email",
            "password"
        )

        val jsonBody = ObjectMapper().writeValueAsString(testUser)

        every { usersService.addUser(testUser) } returns Unit;
        print(usersService.addUser(testUser))

        mockMvc.perform(post("/api/v1/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonBody)
        ).andExpect(status().isOk)

    }

    @Test
    fun ifIdIsNotPassedReturns200OK() {

        val testUser = User(
            null,
            "Test",
            "email",
            "password"
        )

        val jsonBody = ObjectMapper().writeValueAsString(testUser)

        every { usersService.addUser(testUser) } returns Unit;
        print(usersService.addUser(testUser))

        mockMvc.perform(post("/api/v1/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonBody)
        ).andExpect(status().isOk)

    }

    @Test
    fun ifUserNameIsNotPassedReturns4xx() {

        val testUser = "{\"email\":  \"email\",\"password\":  \"password\" }"

        mockMvc.perform(post("/api/v1/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(testUser)
        ).andExpect(status().is4xxClientError)

    }

    @Test
    fun ifEmailIsNotPassedReturns4xx() {

        val testUser = "{\"userName\":  \"Test\",\"password\":  \"password\" }"

        mockMvc.perform(post("/api/v1/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(testUser)
        ).andExpect(status().is4xxClientError)

    }

    @Test
    fun ifPasswordIsNotPassedReturns4xx() {

        val testUser = "{\"userName\":  \"Test\",\"email\":  \"email\" }"

        mockMvc.perform(post("/api/v1/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(testUser)
        ).andExpect(status().is4xxClientError)

    }

    @Test
    fun getAllUsersReturns200OK() {

        every { usersService.getAllUsers() } returns listOf<User>(
            User("","", "", "")
        );

        mockMvc.perform(get("/api/v1/users")
        ).andExpect(status().isOk)

    }

    @Test
    fun deleteUserReturns200OK() {

        every { usersService.deleteUser("123") } returns "Updated";

        mockMvc.perform(delete("/api/v1/users/123")
        ).andExpect(status().isOk)

    }

    @Test
    fun deleteUserWithNoUsernameReturns4xxOK() {

        mockMvc.perform(delete("/api/v1/users")
        ).andExpect(status().is4xxClientError)

    }

}