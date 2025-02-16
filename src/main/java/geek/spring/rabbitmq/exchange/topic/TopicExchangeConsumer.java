package geek.spring.rabbitmq.exchange.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import geek.spring.rabbitmq.dto.User;

@Service
public class TopicExchangeConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(TopicExchangeConsumer.class);

	@RabbitListener(queues = { "${rabbitmq.topic.queue}" })
	public void consume(User user) {
		LOGGER.info(String.format("Message Received by consume() = %s", user.toString()));
	}

	@RabbitListener(queues = { "${rabbitmq.topic.queue2}" })
	public void consume2(User user) {
		LOGGER.info(String.format("Message Received by consume2() = %s", user.toString()));
	}

	@RabbitListener(queues = { "${rabbitmq.topic.queue3}" })
	public void consume3(User user) {
		LOGGER.info(String.format("Message Received by consume3() = %s", user.toString()));
	}

}
