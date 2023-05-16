package com.crs.business.model

import com.crs.business.exception.BusinessException
import com.crs.business.exception.ErrorType
import com.crs.business.handler.CitizenHandler
import java.time.LocalDate

class Citizen(
    @Transient
    private val citizenHandler: CitizenHandler,
    var id: String? = null,
    var name: String = "",
    var dateOfBirth: LocalDate = LocalDate.of(1970, 1, 1),
    var idNumber: String = ""
) {

    fun addCitizen() = citizenHandler.saveCitizen(this)

    fun loadCitizen() = citizenHandler.loadCitizen(id ?: throw BusinessException(ErrorType.ID_NOT_SET))

    fun loadCitizenByIdNumber() = citizenHandler.loadCitizenByIdNumber(idNumber)
}