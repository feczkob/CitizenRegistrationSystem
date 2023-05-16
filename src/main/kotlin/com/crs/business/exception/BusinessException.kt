package com.crs.business.exception

data class BusinessException(
    val errorType: ErrorType
) : Exception() {

}