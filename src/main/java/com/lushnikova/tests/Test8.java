package com.lushnikova.tests;

import com.lushnikova.jpa.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test8 {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

       Thread thread = new Thread(() -> {
           System.out.println("hello");
           try {
               Thread.currentThread().sleep(10000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       });
       thread.start();
       thread.join();


        context.close();
    }
}
