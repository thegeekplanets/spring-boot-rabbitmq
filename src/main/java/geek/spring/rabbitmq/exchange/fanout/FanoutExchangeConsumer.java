package geek.spring.rabbitmq.exchange.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import geek.spring.rabbitmq.dto.User;

@Service
public class FanoutExchangeConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(FanoutExchangeConsumer.class);

	@RabbitListener(queues = { "${rabbitmq.fanout.queue}" })
	public void consume(User user) {
		LOGGER.info(String.format("Message Received by queue = %s", user.toString()));
	}

	@RabbitListener(queues = { "${rabbitmq.fanout.queue2}" })
	public void consume2(User user) {
		LOGGER.info(String.format("Message Received by queue2 = %s", user.toString()));
	}

	@RabbitListener(queues = { "${rabbitmq.fanout.queue3}" })
	public void consume3(User user) {
		LOGGER.info(String.format("Message Received by queue3 = %s", user.toString()));
	}

	@RabbitListener(queues = { "${rabbitmq.fanout.queue4}" })
	public void consume4(User user) {
		LOGGER.info(String.format("Message Received by queue4 = %s", user.toString()));
	}
}
