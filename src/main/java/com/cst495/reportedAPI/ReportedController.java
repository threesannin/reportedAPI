package com.cst495.reportedAPI;

import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ReportedController {

    Logger logger = Logger.getLogger(ReportedController.class.getName());

    @CrossOrigin(origins = "*")
    @GetMapping("test")
    public Response testCall(){
        return new Response("test result", false);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("testpost")
    public Response testPostCall(@RequestBody String name){
        logger.log(Level.ALL, name);
        return new Response("Done with Post Call", false);
    }
}
