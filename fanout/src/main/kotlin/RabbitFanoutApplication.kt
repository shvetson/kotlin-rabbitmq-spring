package ru.shvets.rabbitmq.fanout

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitFanoutApplication

fun main(args: Array<String>) {
    runApplication<RabbitFanoutApplication>(*args)
}