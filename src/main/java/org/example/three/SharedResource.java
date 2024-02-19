package org.example.three;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)

public class SharedResource {
     int itemCount = 0;


    public synchronized void produce() {
        // تولید یک مورد جدید
        System.out.println("Producing item...");
        itemCount++;
        System.out.println("Item count: " + itemCount);
        notifyAll(); // اعلان به تمام نخ‌های در انتظار
        try {
            Thread.sleep(1000); // تاخیر برای شبیه‌سازی عملیات تولید
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consume() {
        // مصرف یک مورد
        while (itemCount == 0) {
            // در انتظار برای موجود شدن مورد
            try {
                System.out.println("Waiting for item to be produced...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // مورد مصرف شده
        System.out.println("Consuming item...");
        itemCount--;
        System.out.println("Item count: " + itemCount);
    }
}
