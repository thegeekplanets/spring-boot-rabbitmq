package geek.spring.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfiguration {

	@Value("${rabbitmq.topic.exchange}")
	private String tpExchange;

	@Value("${rabbitmq.topic.queue}")
	private String tpQueue;

	@Value("${rabbitmq.topic.queue2}")
	private String tpQueue2;

	@Value("${rabbitmq.topic.queue3}")
	private String tpQueue3;

	@Bean
	public Queue tpQueue() {
		return new Queue(tpQueue);
	}

	@Bean
	public Queue tpQueue2() {
		return new Queue(tpQueue2);
	}

	@Bean
	public Queue tpQueue3() {
		return new Queue(tpQueue3);
	}

	@Bean
	public TopicExchange tpExchange() {
		return new TopicExchange(tpExchange);
	}

	@Bean
	public Binding tpQueueBinding() {
		return BindingBuilder.bind(tpQueue()).to(tpExchange()).with("topic.routing.*");
	}

	@Bean
	public Binding tpQueue2Binding() {
		return BindingBuilder.bind(tpQueue2()).to(tpExchange()).with("topic.routing.*");
	}

	@Bean
	public Binding tpQueue3Binding() {
		return BindingBuilder.bind(tpQueue3()).to(tpExchange()).with("topic.routing.test.key");
	}
}
