package ru.shvets.rabbitmq.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitApplication

fun main(args: Array<String>) {
    runApplication<RabbitApplication>(*args)
}