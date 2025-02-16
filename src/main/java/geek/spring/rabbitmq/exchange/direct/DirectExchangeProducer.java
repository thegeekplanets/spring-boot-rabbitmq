package geek.spring.rabbitmq.exchange.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DirectExchangeProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(DirectExchangeProducer.class);

	@Value("${rabbitmq.direct.exchange}")
	private String exchange;

	@Value("${rabbitmq.direct.routing.key}")
	private String routingKey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(String message) {
		LOGGER.info(String.format("Sending message = %s", message));
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
		LOGGER.info("Message sent");
	}

}
