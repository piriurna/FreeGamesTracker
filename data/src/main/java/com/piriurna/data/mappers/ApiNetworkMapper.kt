package com.piriurna.data.mappers

import com.piriurna.data.remote.GTException
import com.piriurna.domain.ApiNetworkError

fun GTException.toApiNetworkError() : ApiNetworkError {
  return ApiNetworkError(
      code = this.code,
      message = this.message,
      errors = listOf(this.toString())
  )

}