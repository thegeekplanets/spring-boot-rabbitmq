package geek.spring.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	/**
	 * @return message converter for handling the JSON type data.
	 */
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	/**
	 * 
	 * This is will configure the Rabbit Template with capability of processing JSON
	 * type data using Jackson2JsonMessageConverter.
	 * 
	 * If we non JSON type data like string, integer, etc. then we don't need this.
	 * because spring boot will automatically create it for us.
	 * 
	 * @param connectionFactory
	 * @return rabbitTemplate configured with message converter which support JSON
	 *         type data.
	 */
	@Bean
	public AmqpTemplate ampAmqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}

}
