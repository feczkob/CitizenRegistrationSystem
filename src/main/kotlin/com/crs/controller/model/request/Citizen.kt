package com.crs.controller.model.request

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Schema(name = "Citizen request")
data class Citizen(
    @Schema(description = "Name of the citizen", nullable = false)
    @field:NotBlank
    var name: String = "",
    @Schema(description = "Date of birth of the citizen", nullable = false)
    @field:NotNull
    var dateOfBirth: LocalDate = LocalDate.of(1970, 1, 1),
    @Schema(description = "Id number of the citizen", nullable = false)
    @field:NotBlank
    var idNumber: String = ""
)