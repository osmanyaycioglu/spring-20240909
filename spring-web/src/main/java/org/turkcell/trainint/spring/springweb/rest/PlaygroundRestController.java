package org.turkcell.trainint.spring.springweb.rest;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.turkcell.trainint.spring.springweb.aop.MethodLog;
import org.turkcell.trainint.spring.springweb.async.MyAsyncService;
import org.turkcell.trainint.spring.springweb.configuration.Location;
import org.turkcell.trainint.spring.springweb.services.InputService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/rest/playground")
@RequiredArgsConstructor
public class PlaygroundRestController {
    private final InputService   inputService;
    private final MyAsyncService myAsyncService;

    @MethodLog(prefix = "Rest : method1",methodTime = true)
    @PostMapping("/test1")
    public String method1(@Valid @RequestBody Location locationParam) {
        return "OK.";
    }

    @GetMapping("/test2")
    public String method2(@RequestParam String name,
                          @RequestParam String surname) {
        return "Hello 2 " + name + " " + surname;
    }

    @GetMapping("/test3/{name}/{surname}")
    public String method3(@PathVariable String name,
                          @PathVariable String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    @GetMapping("/input/{name}")
    public String input(@PathVariable String name) {
        String sLoc = myAsyncService.syncMethod(name);
        System.out.println("Before Async Called");
        Future<String> stringFutureLoc = myAsyncService.asyncMethod(name);
        System.out.println("Async Called");
        try {
            String sLoc1 = stringFutureLoc.get();
            System.out.println("Got response : " + sLoc1);
        } catch (Exception eParam) {
        }

        return "Hello 3 " + name + " " + inputService.increase();
    }

}
