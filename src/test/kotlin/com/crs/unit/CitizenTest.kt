package com.crs.unit

import com.crs.business.exception.BusinessException
import com.crs.business.handler.CitizenHandler
import com.crs.business.model.Citizen
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class CitizenTest {

    private val citizenHandlerMock = mock(CitizenHandler::class.java)
    private val citizen = Citizen(citizenHandlerMock)
    private val citizenId = "12345"
    private val citizenIdNumber = "123"

    @Test
    fun testAddCitizenOk() {
        `when`(citizenHandlerMock.saveCitizen(citizen)).thenReturn(citizen.citizenWithId(citizenId))

        val result = citizen.addCitizen()

        assertEquals(citizenId, result.id)
    }

    @Test
    fun loadCitizenOk() {
        val loadedCitizen = Citizen(citizenHandlerMock, id = citizenId)
        `when`(citizenHandlerMock.loadCitizen(citizenId)).thenReturn(loadedCitizen)

        citizen.id = citizenId
        val result = citizen.loadCitizen()

        assertEquals(loadedCitizen, result)
    }

    @Test
    fun loadCitizenExc() {
        assertThrows(BusinessException::class.java) { citizen.loadCitizen() }
    }

    @Test
    fun loadCitizenByIdNumberOk() {
        val loadedCitizen = Citizen(citizenHandlerMock, idNumber = citizenIdNumber)
        `when`(citizenHandlerMock.loadCitizenByIdNumber(citizenIdNumber)).thenReturn(loadedCitizen)

        citizen.idNumber = citizenIdNumber
        val result = citizen.loadCitizenByIdNumber()

        assertEquals(loadedCitizen, result)
    }

    private fun Citizen.citizenWithId(id: String): Citizen {
        this.id = id
        return this
    }
}