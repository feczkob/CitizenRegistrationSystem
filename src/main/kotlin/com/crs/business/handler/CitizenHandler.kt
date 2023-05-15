package com.crs.business.handler

import com.crs.business.model.Citizen

interface CitizenHandler {

    fun saveCitizen(citizen: Citizen): Citizen
    fun loadCitizen(citizenId: String): Citizen
}