package com.example.venue_guide.venueData

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

data class VenueData(
    val id: String?,
    val name: String,
    val capacity: Int?,

    @field:Min(value = 0, message = "Accessibility rating must be between 0 - 10")
    @field:Max(value = 10, message = "Accessibility rating must be between 0 - 10")
    val accessibility: Int?
)
