package org.turkcell.trainint.spring.springweb.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class MyAsyncService {


    public String syncMethod(String str) {
        System.out.println("Sync run : " + str + " Thread : " + Thread.currentThread()
                                                                      .getName());
        return "sync : " + str;
    }


    @Async
    public Future<String> asyncMethod(String str) {
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException eParam) {

        }
        System.out.println("Async run : " + str + " Thread : " + Thread.currentThread()
                                                                       .getName());
        return CompletableFuture.completedFuture("sync : " + str);
    }

}
