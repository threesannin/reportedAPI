package com.cst495.reportedAPI;

import com.cst495.reportedAPI.entities.Form;
import com.cst495.reportedAPI.entities.Response;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ReportedController {

    private Logger logger = Logger.getLogger(ReportedController.class.getName());

    @CrossOrigin(origins = "*")
    @GetMapping("test")
    public Response testCall(){
        return new Response("test result", false);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("testpost")
    public Response testPostCall(@RequestBody Response response){
        logger.log(Level.WARNING, "*******" + response.toString() + "*******" );
        return new Response(response.getStatus(), false);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("submitPost")
    public Response submitPost(@RequestBody Form form){
        logger.log(Level.WARNING, "*******" + form.toString() + "*******" );
        return new Response("got your form " + form.getCategory(), false);
    }
}
