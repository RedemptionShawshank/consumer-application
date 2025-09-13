package com.example.testApp.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

//    @KafkaListener(topics = "test-topic", groupId = "my-group")
//    public void consume(String message) {
//        System.out.println("Received message: " + message);
//    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "test-topic", partitions = { "0" }),
            groupId = "json-message" // Listen to partition 0
    )
    public void listenToPartition(ConsumerRecord<String, String> record) {
        String key = record.key();      // This will be the "name"
        String value = record.value();  // This will be the "message"
        int partition = record.partition();

        System.out.printf("Received message: [key=%s, value=%s] %n", key, value);
        // You can now process or store the message as needed
    }
}
