package com.piriurna.data.remote

import com.piriurna.data.ErrorType
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object HandleApi {

    suspend fun <T> safeApiCall(callFunction: suspend () -> T): T {
        return try{

            callFunction.invoke()

        }
        catch (ex: Exception){
            when(ex){
                is HttpException -> {
                    throw GTException.NetworkException(code = ex.code(), message = ex.message())
                }
                is UnknownHostException -> throw GTException.NoInternetException

                is SocketTimeoutException -> throw GTException.TimeoutException(ex.message)

                is IOException -> throw GTException.NetworkException(code = ErrorType.IO.code, message = ex.message)


                else -> throw ex

            }
        }
    }



}