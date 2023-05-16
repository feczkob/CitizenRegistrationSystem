package com.crs.client.repository

import com.crs.client.entity.Citizen
import org.springframework.data.mongodb.repository.MongoRepository

interface CitizenRepository: MongoRepository<Citizen, String> {

    fun findCitizenByIdNumberEquals(idNumber: String): Citizen?
}