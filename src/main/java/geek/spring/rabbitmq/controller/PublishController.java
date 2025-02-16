package geek.spring.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import geek.spring.rabbitmq.dto.User;
import geek.spring.rabbitmq.exchange.direct.DirectExchangeProducer;
import geek.spring.rabbitmq.exchange.fanout.FanoutExchangeProducer;
import geek.spring.rabbitmq.exchange.topic.TopicExchangeProducer;

@RestController
@RequestMapping(path = "/mq")
public class PublishController {

	@Autowired
	private DirectExchangeProducer directExchangeProducer;

	@Autowired
	private TopicExchangeProducer topicExchangeProducer;

	@Autowired
	private FanoutExchangeProducer fanoutExchangeProducer;

	@GetMapping("/direct")
	public ResponseEntity<String> triggerDirectExchange(@RequestParam("message") String message) {
		directExchangeProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to RabbitMQ");
	}

	@PostMapping("/topic")
	public ResponseEntity<User> triggerTopicExchange(@RequestBody User user) {
		topicExchangeProducer.sendMessage(user);
		return ResponseEntity.ok(user);
	}

	@PostMapping("/fanout")
	public ResponseEntity<User> triggerFanoutExchange(@RequestBody User user) {
		fanoutExchangeProducer.sendMessage(user);
		return ResponseEntity.ok(user);
	}

}
