package com.example.venue_guide.venueData

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.query
import java.util.*

@Service
class VenueDataService(val db: JdbcTemplate) {

    fun getAllVenues() :List<VenueData>  = db.query("select * from venues") {
        response, _ ->
            VenueData(
                response.getString("id"),
                response.getString("name"),
                response.getInt("capacity"),
                response.getInt("accessibility")
            )
    }

    fun addVenue(venue: VenueData) {
        val id = venue.id ?: UUID.randomUUID().toString()
        val capacity = venue.capacity ?: 0

        db.update("insert into venues values (?, ?, ?, ?)",
            id,
            venue.name,
            capacity,
            venue.accessibility
            )
    }

    fun getVenueById(id: String) :List<VenueData>  = db.query("select * from venues where id = ?", id) { response, _ ->
            VenueData(
                response.getString("id"),
                response.getString("name"),
                response.getInt("capacity"),
                response.getInt("accessibility")
            )
        }

}