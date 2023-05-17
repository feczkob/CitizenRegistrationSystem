package com.crs.client.entity

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.MongoId
import java.time.LocalDate

class Citizen(
    @MongoId
    @Indexed // * https://www.baeldung.com/spring-data-mongodb-unique
    var id: String? = null,
    var name: String = "",
    var dateOfBirth: LocalDate = LocalDate.of(1970, 1, 1),
    @Indexed(unique = true)
    var idNumber: String = ""
)