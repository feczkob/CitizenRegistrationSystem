package com.crs.business.config

import com.crs.business.handler.CitizenHandler
import com.crs.business.model.Citizen
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CitizenConfig {

    @Bean(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun citizen(citizenHandler: CitizenHandler): Citizen {
        return Citizen(citizenHandler)
    }
}