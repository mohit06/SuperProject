package com.ordercommandservice.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.ordercommandservice.app.entities.OrderEntity;

@SpringBootApplication
public class OrderCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderCommandServiceApplication.class, args);
	}

//	@Bean
//	public ProducerFactory<String, OrderEntity> producerFactory() {
//		Map<String, Object> configProps = new HashMap<>();
//		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, String.class);
//		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//				org.springframework.kafka.support.serializer.JsonSerializer.class);
//		return new DefaultKafkaProducerFactory<>(configProps);
//	}
//
//	@Bean
//	public KafkaTemplate<String, OrderEntity> kafkaTemplate() {
//		return new KafkaTemplate<>(producerFactory());
//	}

}
