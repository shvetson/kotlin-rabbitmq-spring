package ru.shvets.rabbitmq.direct.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.shvets.rabbitmq.direct.config.RabbitConfig

/**
 * @author  Oleg Shvets
 * @version 1.0
 * @date  03.04.2023 19:04
 */

@RestController
class DefaultController(
    private val template: RabbitTemplate,
) {
    val logger: Logger = LoggerFactory.getLogger(DefaultController::class.java)

    @PostMapping("/direct")
    fun direct(@RequestBody map: Map<String, String>): ResponseEntity<String> {
        logger.info("Emit to myQueue")

        val exchange = RabbitConfig().directExchange().name
        template.exchange = exchange

        if (map.isNotEmpty()) {
            template.convertAndSend(map["key"].toString(), map["message"].toString())
        }

        return ResponseEntity.ok("Success emit to queue")
    }
}