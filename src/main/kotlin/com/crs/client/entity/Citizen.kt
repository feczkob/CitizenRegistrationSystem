package com.crs.client.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import java.time.LocalDate

class Citizen(
    @Id
    @Indexed
    var id: String? = null,
    var name: String = "",
    var dateOfBirth: LocalDate = LocalDate.of(1970, 1, 1),
    @Indexed(unique = true)
    var idNumber: String = ""
)