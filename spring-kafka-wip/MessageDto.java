package com.mhdanh.tryout.kafka;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MessageDto {
    private Long id;
    private String name;
    private boolean working;
    private int age;
    private BigDecimal salary;
    private String[] hobbies;

    private List<String> skills;
    private List<History> histories;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class History {
        private int year;
        private String event;
    }
}
