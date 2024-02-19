package org.example.one;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
class SharedResource {
    List<Integer> sharedList = new ArrayList<>();
    int count;
    boolean isOddThreadTurn = false;

    public synchronized void addNumber(int number) {
        while (isOddThreadTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        sharedList.add(number);
        count++;
        isOddThreadTurn = true;
        notify();
    }

    public synchronized void addOddNumber(int number) {
        while (!isOddThreadTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        sharedList.add(number);
        count++;
        isOddThreadTurn = false;
        notify();
    }

    public synchronized boolean isFinished(int maxNumber) {
        return count >= maxNumber;
    }

    public List<Integer> getSharedList() {
        return sharedList;
    }

}
