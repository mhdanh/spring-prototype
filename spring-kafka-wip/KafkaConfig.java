package com.mhdanh.tryout.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("mhdanh")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("again")
                .partitions(10)
                .replicas(2)
                .build();
    }

    @Bean
    public NewTopic objectMe() {
        return TopicBuilder.name("object")
                .partitions(10)
                .replicas(2)
                .build();
    }

//    @KafkaListener(id = "myId", topics = "mhdanh")
//    public void listenMhdanh(String in) {
//        System.out.println("Mhdanh topic:" + in);
//    }

    @KafkaListener(id = "myPart", topics = "mhdanh", topicPartitions = {@TopicPartition(
            topic = "mhdanh",
            partitions = { "7"}
    )
    })
    public void listenPartition(String in) {
        System.out.println("new mhdanh:" + in);
    }

//    @KafkaListener(id = "myId2", topics = "quickstart", groupId = "g1")
//    public void listenQuickstart(String in) {
//        System.out.println("quickstart topic: " + in);
//    }

//    @KafkaListener(id = "myId3", topics = "quickstart", groupId = "g2")
//    public void listenQuickstart2(String in) {
//        System.out.println("quickstart topic 2: " + in);
//    }

//    @KafkaListener(id="mId4", topics = {"quickstart", "mhdanh"})
//    public void multipleTopic(ConsumerRecord<?, ?> in) {
//        System.out.println("multiple: " + in);
//    }


    @KafkaListener(id="mId6", topics = {"object"})
    public void multipleTopic(ConsumerRecord<String, MessageDto> record) {
        System.out.println("topic: "
                + record.topic()
                + ":partition:"
                + record.partition()
                + ":key:" + record.key()
                + ":offset" + record.offset()
        );
        System.out.println("multiple: " + record.value());
    }



}
