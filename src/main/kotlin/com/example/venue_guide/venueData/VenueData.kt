package com.example.venue_guide.venueData

import java.util.UUID

data class VenueData(
    val id: UUID?,
    val name: String,
    val capacity: Int?
)
