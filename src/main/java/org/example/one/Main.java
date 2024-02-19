package org.example.one;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your number: ");
        int maxNumber = scanner.nextInt();

        SharedResource sharedResource = new SharedResource();

        EvenThread evenThread = new EvenThread(sharedResource, maxNumber);
        OddThread oddThread = new OddThread(sharedResource, maxNumber);

        evenThread.start();
        oddThread.start();

        while (!sharedResource.isFinished(maxNumber)) {
            try {
                Thread.sleep(100); // Waiting for threads to complete their tasks
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        List<Integer> finalList = sharedResource.getSharedList();
        System.out.println("Final List: " + finalList);
    }
}