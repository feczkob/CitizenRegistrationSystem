package com.crs.controller.converter

import com.crs.business.config.CitizenConfig
import com.crs.controller.model.request.Citizen
import org.modelmapper.ModelMapper
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CitizenToBusinessConverter(
    private val modelMapper: ModelMapper,
    private val citizenConfig: CitizenConfig
): Converter<Citizen, com.crs.business.model.Citizen> {

    override fun convert(source: Citizen): com.crs.business.model.Citizen {
        return with(citizenConfig.getCitizen()) {
            modelMapper.map(source, this)
            this
        }
    }
}