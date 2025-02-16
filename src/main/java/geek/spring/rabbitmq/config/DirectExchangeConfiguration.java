package geek.spring.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfiguration {

	@Value("${rabbitmq.direct.exchange}")
	private String dirExchange;

	@Value("${rabbitmq.direct.queue}")
	private String dirQueue;

	@Value("${rabbitmq.direct.routing.key}")
	private String dirRoutingKey;

	@Bean
	public Queue directQueue() {
		return new Queue(dirQueue);
	}

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(dirExchange);
	}

	@Bean
	public Binding directQueueBinding() {
		return BindingBuilder.bind(directQueue()).to(directExchange()).with(dirRoutingKey);
	}
}
