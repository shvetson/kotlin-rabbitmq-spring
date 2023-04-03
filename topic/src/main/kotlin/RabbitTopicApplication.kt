package ru.shvets.rabbitmq.topic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitTopicApplication

fun main(args: Array<String>) {
    runApplication<RabbitTopicApplication>(*args)
}