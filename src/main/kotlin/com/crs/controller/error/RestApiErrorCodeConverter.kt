package com.crs.controller.error

import com.crs.business.exception.ErrorType
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestApiErrorCodeConverter(
    private val businessInterfaceCodes: MutableMap<ErrorType, String> = EnumMap(ErrorType::class.java),
) {

    init {
        businessInterfaceCodes[ErrorType.UNKNOWN_ERROR] = RestApiError.ERROR_CODE_UNKNOWN_ERROR
        businessInterfaceCodes[ErrorType.MISSING_ENTITY] = RestApiError.ERROR_CODE_MISSING_ENTITY
        businessInterfaceCodes[ErrorType.ID_NOT_SET] = RestApiError.ERROR_CODE_INTERFACE_VALIDATION_ERROR
    }

    /**
     * Function that converts errorType to String
     * The returned string will appear as an error message
     * @param errorType ErrorType
     * @return String
     */
    fun getRestApiErrorCode(errorType: ErrorType): String {
        var restErrorCode: String?
        return if (businessInterfaceCodes[errorType]
                .also { restErrorCode = it } == null
        ) RestApiError.ERROR_CODE_UNKNOWN_ERROR else restErrorCode!!
    }

}