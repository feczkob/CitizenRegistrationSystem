package com.crs.business.service.converter

import com.crs.business.config.CitizenConfig
import com.crs.client.entity.Citizen
import org.modelmapper.ModelMapper
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CitizenConverter(
    private val modelMapper: ModelMapper,
    private val citizenConfig: CitizenConfig
) : Converter<Citizen, com.crs.business.model.Citizen> {

    override fun convert(source: Citizen): com.crs.business.model.Citizen {
        val citizen = citizenConfig.getCitizen()
        modelMapper.map(source, citizen)
        return citizen
    }
}