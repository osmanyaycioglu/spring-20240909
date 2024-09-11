package org.turkcell.trainint.spring.springweb.rest;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.turkcell.trainint.spring.springweb.configuration.Location;

@RestController
@RequestMapping("/api/v1/rest/playground")
public class PlaygroundRestController {


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

}
