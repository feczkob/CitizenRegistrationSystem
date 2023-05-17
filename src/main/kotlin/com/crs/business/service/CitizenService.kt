package com.crs.business.service

import com.crs.business.exception.BusinessException
import com.crs.business.exception.ErrorType
import com.crs.business.handler.CitizenHandler
import com.crs.business.model.Citizen
import com.crs.business.service.converter.CitizenConverter
import com.crs.client.repository.CitizenRepository
import org.modelmapper.ModelMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CitizenService(
    private val citizenRepository: CitizenRepository,
    private val modelMapper: ModelMapper,
    private val citizenConverter: CitizenConverter
): CitizenHandler {

    override fun saveCitizen(citizen: Citizen): Citizen {
        val toBeSaved = modelMapper.map(citizen, com.crs.client.entity.Citizen::class.java)
        val saved = citizenRepository.save(toBeSaved)
        modelMapper.map(saved, citizen)
        return citizen

//        modelMapper.map(modelMapper.map(citizen, com.crs.client.entity.Citizen::class.java)
//            .apply { citizenRepository.save(this) }, citizen)
//        return citizen
    }

    override fun loadCitizen(citizenId: String): Citizen {
        return citizenRepository.findByIdOrNull(citizenId)?.let { citizenConverter.convert(it) }
            ?: throw BusinessException(ErrorType.MISSING_ENTITY)
    }

    override fun loadCitizenByIdNumber(idNumber: String): Citizen {
        return citizenRepository.findCitizenByIdNumberEquals(idNumber)?.let { citizenConverter.convert(it) }
            ?: throw BusinessException(ErrorType.MISSING_ENTITY)
    }
}