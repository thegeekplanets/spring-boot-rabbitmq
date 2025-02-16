package geek.spring.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutExchangeConfiguration {

	@Value("${rabbitmq.fanout.exchange}")
	private String fanoutExchange;

	@Value("${rabbitmq.fanout.queue}")
	private String fanoutQueue;

	@Value("${rabbitmq.fanout.queue2}")
	private String fanoutQueue2;

	@Value("${rabbitmq.fanout.queue3}")
	private String fanoutQueue3;

	@Value("${rabbitmq.fanout.queue4}")
	private String fanoutQueue4;

	@Bean
	public Queue ftQueue() {
		return new Queue(fanoutQueue);
	}

	@Bean
	public Queue ftQueue2() {
		return new Queue(fanoutQueue2);
	}

	@Bean
	public Queue ftQueue3() {
		return new Queue(fanoutQueue3);
	}

	@Bean
	public Queue ftQueue4() {
		return new Queue(fanoutQueue4);
	}

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(fanoutExchange);
	}

	@Bean
	public Binding ftQBinding() {
		return BindingBuilder.bind(ftQueue()).to(fanoutExchange());
	}

	@Bean
	public Binding ftQ2Binding() {
		return BindingBuilder.bind(ftQueue2()).to(fanoutExchange());
	}

	@Bean
	public Binding ftQ3Binding() {
		return BindingBuilder.bind(ftQueue3()).to(fanoutExchange());
	}

	@Bean
	public Binding ftQ4Binding() {
		return BindingBuilder.bind(ftQueue4()).to(fanoutExchange());
	}

}
