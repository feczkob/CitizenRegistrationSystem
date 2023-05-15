package com.crs.client.persistence.entity

import org.springframework.data.annotation.Id
import java.time.LocalDate

class Citizen(
    @Id
    var id: String? = null,
    var name: String = "",
    var dateOfBirth: LocalDate = LocalDate.of(1970, 1, 1),
    var idNumber: String = ""
)