package br.com.dg.panteao.cronus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CronusApplication

fun main(args: Array<String>) {
    runApplication<CronusApplication>(*args)
}

