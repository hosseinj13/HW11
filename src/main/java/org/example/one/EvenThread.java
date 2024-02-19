package org.example.one;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)


class EvenThread extends Thread {
     SharedResource sharedResource;
     int maxNumber;

    @Override
    public void run() {
        for (int i = 0; i <= maxNumber; i += 2) {
            sharedResource.addNumber(i);
        }
    }
}