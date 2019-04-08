package com.cst495.reportedAPI;

import org.springframework.web.bind.annotation.*;

@RestController
public class ReportedController {

    @CrossOrigin(origins = "*")
    @GetMapping("test")
    public Response testCall(){
        return new Response("test result", false);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("testpost")
    public Response testPostCall(@RequestBody String name){
        System.out.println(name);
        return new Response("Done with Post Call", false);
    }
}
