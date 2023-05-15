package com.crs.business.service

import com.crs.business.handler.CitizenHandler
import com.crs.business.model.Citizen
import org.springframework.stereotype.Service

@Service
class CitizenService: CitizenHandler {

    override fun saveCitizen(citizen: Citizen): Citizen {
        TODO("Not yet implemented")
    }

    override fun loadCitizen(citizenId: String): Citizen {
        TODO("Not yet implemented")
    }
}