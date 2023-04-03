package ru.shvets.rabbitmq.direct

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitDirectApplication

fun main(args: Array<String>) {
    runApplication<RabbitDirectApplication>(*args)
}