package com.example.venue_guide.venueData

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class VenueDataController(val service: VenueDataService) {

    @GetMapping("/venues/{id}")
    fun getVenueById(@PathVariable("id") id: String): List<VenueData> = service.getVenueById(id)

    @GetMapping("/venues")
    fun getAllVenues(): List<VenueData> = service.getAllVenues()

    @PostMapping("/venues")
    fun addVenue(@Valid @RequestBody body: VenueData) = service.addVenue(body)
}