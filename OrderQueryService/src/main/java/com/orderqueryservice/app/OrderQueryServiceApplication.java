package com.orderqueryservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.ordercommandservice.app.entities"})
public class OrderQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderQueryServiceApplication.class, args);
	}

//	@Bean
//	public ConsumerFactory<String, OrderEntity> consumerFactory() {
//		Map<String, Object> configProps = new HashMap<>();
//		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group-id");
//		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class);
//		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//				org.springframework.kafka.support.serializer.JsonDeserializer.class);
//		configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//		return new DefaultKafkaConsumerFactory<>(configProps);
//	}

//	@Bean
//	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setConsumerFactory(consumerFactory());
//		return factory;
//	}

}
