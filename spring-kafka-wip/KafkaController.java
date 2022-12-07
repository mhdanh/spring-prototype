package com.mhdanh.tryout.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("kafka")
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaTemplate<String, MessageDto> kafkaTemplateObject;

    @PostMapping
    public String send(@RequestBody String msg, @RequestParam("topic") String topic,
                       @RequestParam(value = "partition", required = false) Integer partition,
                       @RequestParam(value = "key", required = false) String key) {
        // send message to topic with specific partition number
        MessageBuilder<String> builder = MessageBuilder.withPayload(msg)
                .setHeader(KafkaHeaders.TOPIC, topic);

        if(partition != null) {
            builder.setHeader(KafkaHeaders.PARTITION_ID, partition);
        }

        if(key != null && !key.isBlank()) {
            builder.setHeader(KafkaHeaders.MESSAGE_KEY, key);
        }

        kafkaTemplate.send(builder.build());
        return msg;
    }

    @PostMapping("objects")
    public void createModel(@RequestParam String topic) {
        MessageDto message = MessageDto.builder().id(1L)
                .age(30)
                .name("Me")
                .hobbies(Arrays.asList("Football", "Swimming", "Playing").toArray(new String[0]))
                .skills(List.of("Java", "SQL", "Cloud", "Distributed", ""))
                .histories(List.of(MessageDto.History.builder().event("Was born").year(2000).build()))
                .salary(BigDecimal.valueOf(203))
                .working(true)
                .build();

        kafkaTemplateObject.send(MessageBuilder.withPayload(message)
                        .setHeader(KafkaHeaders.TOPIC, topic)
                .build());
    }
}
