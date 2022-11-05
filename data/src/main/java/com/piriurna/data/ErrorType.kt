package com.piriurna.data

enum class ErrorType(val code : Int) {

    INVALID_PARAMETER(1),
    NO_INTERNET(2),
    TIMEOUT(3),
    IO(4);


    companion object {
        fun valueFromCode(code: Int?) : ErrorType? {
            return values().firstOrNull { it.code == code }
        }
    }
}