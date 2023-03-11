package com.piriurna.data.remote

import com.piriurna.data.ErrorType

sealed class GTException(val code : Int?, message : String?) : Exception(message) {

    class InvalidParameterException(message: String) : GTException(code = ErrorType.INVALID_PARAMETER.code, message = message)

    class NetworkException(code : Int, message : String?) : GTException(code, message)

    object NoInternetException : GTException(code = ErrorType.NO_INTERNET.code, message = "No internet connection available")

    class TimeoutException(message : String?) : GTException(code = ErrorType.TIMEOUT.code, message = message)
}