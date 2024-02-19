package org.example.three;

import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)


public class StarvationExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread producer = new Thread(() -> {
            while (true) {
                sharedResource.produce();
            }
        });


        Thread consumer1 = new Thread(() -> {
            while (true) {
                sharedResource.consume();
            }
        });
        Thread consumer2 = new Thread(() -> {
            while (true) {
                sharedResource.consume();
            }
        });

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
