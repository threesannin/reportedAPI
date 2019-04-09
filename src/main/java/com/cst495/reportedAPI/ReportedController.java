package com.cst495.reportedAPI;

import org.springframework.http.MediaType;
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
    public Response testPostCall(@RequestBody Response response){
        logger.log(Level.WARNING, "*********************************************************8" + response.toString());
        return new Response("done with post", false);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/t", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    //, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Response testPostCall2(String response){
        Response r = new Response("done", false);
        if(response == null) {
           r.setStatus("null error");
           r.setError(true);
        }
        logger.log(Level.WARNING, "*********************************************************8" + response);
        System.out.println(response);
        return r;
    }

}
