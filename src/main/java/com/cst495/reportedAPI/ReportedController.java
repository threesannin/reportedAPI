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
    public Response testPostCall(@RequestBody Response name){
        logger.log(Level.ALL, name.toString());
        return new Response("done with post", false);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/t", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    //, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Response authenticate(@RequestParam Response paramMap){
        if(paramMap == null) {
            return new Response("null error", true);
        }
        logger.log(Level.WARNING, "*********************************************************8" + paramMap.toString());
        System.out.println(paramMap);
        return new Response("done", false);
    }

}
