package com.crs.controller.rest

import com.crs.business.config.CitizenConfig
import com.crs.controller.Constants.Companion.CITIZEN
import com.crs.controller.Constants.Companion.CITIZEN_ID
import com.crs.controller.converter.CitizenToBusinessConverter
import com.crs.controller.error.RestApiError
import com.crs.controller.model.request.Citizen
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.modelmapper.ModelMapper
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.ws.rs.core.UriBuilder

@Controller
@RequestMapping(CITIZEN)
class CitizenController(
    private val citizenToBusinessConverter: CitizenToBusinessConverter,
    private val modelMapper: ModelMapper,
    private val citizenConfig: CitizenConfig,
) {

    @ApiResponses(
        value = [ApiResponse(
            responseCode = "201",
            description = "Created",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = com.crs.controller.model.response.Citizen::class)
            )]
        ), ApiResponse(
            responseCode = "400",
            description = "Bad request",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = RestApiError::class)
            )]
        ), ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = RestApiError::class)
            )]
        )]
    )
    @Operation(description = "Add citizen")
    @PostMapping
    fun addCitizen(
        @io.swagger.v3.oas.annotations.parameters.RequestBody
        @Valid @NotNull
        @RequestBody
        citizen: Citizen,
    ): ResponseEntity<com.crs.controller.model.response.Citizen> {
        val c = citizenToBusinessConverter.convert(citizen).addCitizen()
        val processedUri = UriBuilder.fromResource(com.crs.controller.model.response.Citizen::class.java)
            .path(CITIZEN_ID)
            .build(c.id)
        return ResponseEntity.created(processedUri)
            .body(modelMapper.map(c, com.crs.controller.model.response.Citizen::class.java))
    }

    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "OK",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = com.crs.controller.model.response.Citizen::class)
            )]
        ), ApiResponse(
            responseCode = "404",
            description = "Not found",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = RestApiError::class)
            )]
        ), ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = RestApiError::class)
            )]
        )]
    )
    @Operation(
        description = "Get a citizen",
    )
    @GetMapping(CITIZEN_ID)
    fun getCitizen(
        @NotNull
        @PathVariable citizenId: String,
    ): ResponseEntity<com.crs.controller.model.response.Citizen> {
        val business = citizenConfig.getCitizen()
        business.id = citizenId

        return ResponseEntity.ok().body(
            modelMapper.map(
                business.loadCitizen(),
                com.crs.controller.model.response.Citizen::class.java
            )
        )
    }

    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "OK",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = com.crs.controller.model.response.Citizen::class)
            )]
        ), ApiResponse(
            responseCode = "404",
            description = "Not found",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = RestApiError::class)
            )]
        ), ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = RestApiError::class)
            )]
        )]
    )
    @Operation(
        description = "Get a citizen by Id number",
    )
    @GetMapping
    fun getCitizenByIdNumber(
        @NotNull
        @RequestParam idNumber: String,
    ): ResponseEntity<com.crs.controller.model.response.Citizen> {
        val business = citizenConfig.getCitizen()
        business.idNumber = idNumber

        return ResponseEntity.ok().body(
            modelMapper.map(
                business.loadCitizenByIdNumber(),
                com.crs.controller.model.response.Citizen::class.java
            )
        )
    }
}