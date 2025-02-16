package geek.spring.rabbitmq.exchange.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import geek.spring.rabbitmq.dto.User;

@Service
public class TopicExchangeProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(TopicExchangeProducer.class);

	@Value("${rabbitmq.topic.exchange}")
	private String exchange;

	@Value("${rabbitmq.topic.routing.key}")
	private String routingKey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(User user) {
		LOGGER.info(String.format("JSON Message sent = %s", user.toString()));
		rabbitTemplate.convertAndSend(exchange, routingKey, user);
	}

}
