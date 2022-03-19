package br.com.dg.panteao.cronus.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        exception: NotFoundException,
        request: HttpServletRequest
    ): ErrorView = logAndReturn(HttpStatus.NOT_FOUND, exception.message, request)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationError(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ErrorView {
        val errorMessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach { e ->
            errorMessage.put(e.field, e.defaultMessage)
        }
        return logAndReturn(HttpStatus.BAD_REQUEST, errorMessage.toString(), request)
    }

    @ExceptionHandler(InvalidAtividadeStatusException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInvalidAtividadeStatus(
        exception: NotFoundException,
        request: HttpServletRequest
    ): ErrorView = logAndReturn(HttpStatus.BAD_REQUEST, exception.message, request)

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(
        exception: Exception,
        request: HttpServletRequest
    ): ErrorView {
        val rootException = (exception as HttpMessageNotReadableException).rootCause
        if (rootException is InvalidAtividadeStatusException) {
            return logAndReturn(HttpStatus.BAD_REQUEST, rootException.message, request)
        }

        return logAndReturn(HttpStatus.INTERNAL_SERVER_ERROR, exception.message, request)
    }

    fun logAndReturn(httpStatus: HttpStatus, message: String?, request: HttpServletRequest): ErrorView {
        logger.error(
            "path={}; error={}; message={}; status={}",
            request.servletPath,
            httpStatus.name,
            message,
            httpStatus.value()
        )

        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = request.servletPath
        )
    }
}