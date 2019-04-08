package com.cst495.reportedAPI;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportedController {

    @CrossOrigin(origins = "*")
    @GetMapping("test")
    public String testCall(){
        return "test result";
    }
}
