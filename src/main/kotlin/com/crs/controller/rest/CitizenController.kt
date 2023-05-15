package com.crs.controller.rest

import com.crs.controller.Constants.Companion.CITIZEN
import com.crs.controller.Constants.Companion.CITIZEN_ID
import com.crs.controller.model.request.Citizen
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.ws.rs.core.UriBuilder

@Controller
@RequestMapping(CITIZEN)
class CitizenController {

    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "OK",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = String::class)
            )]
        )]
    )
    @Operation(description = "Test")
    @GetMapping
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("Test")
    }

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
                mediaType = MediaType.APPLICATION_JSON_VALUE
            )]
        ), ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE
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
        val c = com.crs.controller.model.response.Citizen("id", "name", LocalDate.now(), "id")
        val processedUri = UriBuilder.fromResource(com.crs.controller.model.response.Citizen::class.java)
            .path(CITIZEN_ID)
            .build(c.id)
        return ResponseEntity.created(processedUri).body(c)
    }
}