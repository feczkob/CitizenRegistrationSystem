package com.crs.controller.model.response

import com.crs.controller.Constants
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import javax.ws.rs.Path

@Path(Constants.CITIZEN)
@Schema(name = "Citizen response")
data class Citizen(
    @Schema(description = "Id of the citizen", nullable = false)
    var id: String = "",
    @Schema(description = "Name of the citizen", nullable = false)
    var name: String = "",
    @Schema(description = "Date of birth of the citizen", nullable = false)
    var dateOfBirth: LocalDate = LocalDate.of(1970, 1, 1),
    @Schema(description = "Id number of the citizen", nullable = false)
    var idNumber: String = ""
)
