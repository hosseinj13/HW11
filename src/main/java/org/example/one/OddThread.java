package org.example.one;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

class OddThread extends Thread {
     SharedResource sharedResource;
     int maxNumber;

    @Override
    public void run() {
        for (int i = 1; i <= maxNumber; i += 2) {
            sharedResource.addOddNumber(i);
        }
    }
}
