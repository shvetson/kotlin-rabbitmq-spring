package ru.shvets.rabbitmq.fanout.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.shvets.rabbitmq.fanout.config.RabbitConfig

/**
 * @author  Oleg Shvets
 * @version 1.0
 * @date  02.04.2023 22:04
 */

@RestController
class DefaultController(
    private val template: RabbitTemplate
) {
    val logger: Logger = LoggerFactory.getLogger(DefaultController::class.java)

    @PostMapping("/fanout")
    fun emit(@RequestBody message: String): ResponseEntity<String> {
        logger.info("Emit to myQueue")

        val exchange = RabbitConfig().fanoutExchange().name
        template.exchange = exchange
        template.convertAndSend(message)

        return ResponseEntity.ok("Success emit to queue")
    }
}