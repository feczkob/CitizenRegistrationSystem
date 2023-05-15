package com.crs.client.persistence.repository

import com.crs.client.persistence.entity.Citizen
import org.springframework.data.mongodb.repository.MongoRepository

interface CitizenRepository: MongoRepository<Citizen, String> {
}