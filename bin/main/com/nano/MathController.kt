package com.nano

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import io.micronaut.http.annotation.Body

@Controller("/calculator")
@Validated
class MathController {

    @Get("/greeting")
    fun greeting(): HttpResponse<String> {
        return HttpResponse.ok("Hello world!")
    }

    @Post("/add", produces = [MediaType.APPLICATION_JSON])
    fun add(@Body numbers: Numbers): HttpResponse<String> {
        val result = numbers.first + numbers.second
        val jsonResponse = "{\"result\": $result}"
        return HttpResponse.ok(jsonResponse)
    }

    @Post("/subtract", produces = [MediaType.APPLICATION_JSON])
    fun subtract(@Body numbers: Numbers): HttpResponse<String> {
        val result =numbers.first - numbers.second
        val jsonResponse = "{\"result\": $result}"
        return HttpResponse.ok(jsonResponse)
    }
}

