package com.api.shoppingcart.config

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@RestControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler
    fun exceptionHandler(ex: Exception): ResponseEntity<ErrorDetails> {
        val errorDetails = ex.message?.let { ErrorDetails(Date(), "Api Error", it) }
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

}

data class ErrorDetails(
    val time: Date,
    val message: String,
    val details: String
)