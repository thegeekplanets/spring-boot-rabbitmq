package geek.spring.rabbitmq.exchange.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DirectExchangeConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(DirectExchangeConsumer.class);

	@RabbitListener(queues = { "${rabbitmq.direct.queue}" })
	public void consume(String message) {
		LOGGER.info(String.format("Message Received by consume() = %s", message));
	}
}
