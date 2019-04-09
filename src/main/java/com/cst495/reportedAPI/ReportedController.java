package com.cst495.reportedAPI;

import com.cst495.reportedAPI.entities.Form;
import com.cst495.reportedAPI.entities.Response;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public Response testPostCall(@RequestBody Response input){
        logger.log(Level.WARNING, "*******" + input.toString() + "*******" );
        return new Response(input.getStatus(), false);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("submitPost")
    public Response submitPost(@RequestBody Form form){
        logger.log(Level.WARNING, "*******" + form.toString() + "*******" );
        //selenium
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:4200/add";
        driver.get(baseUrl);

        // Get the WebElement corresponding to the Email Address(TextField)
//        WebElement email = driver.findElement(By.id("email"));

        // Get the WebElement corresponding to the Password Field
//        WebElement password = driver.findElement(By.name("passwd"));

        WebElement className = driver.findElement(By.id("classname"));
        WebElement department = driver.findElement(By.id("department"));
        WebElement classRoom = driver.findElement(By.id("classroom"));

        className.sendKeys("selenium Test");
        department.sendKeys("test");
        classRoom.sendKeys("999");
        System.out.println("Text Field Set");

        // Deleting values in the text box
        className.clear();
        department.clear();
        classRoom.clear();
        System.out.println("Text Field Cleared");

        // Find the submit button
        WebElement submitButton = driver.findElement(By.id("addClass"));

        // Using click method to submit form
        className.sendKeys("selenium Test");
        department.sendKeys("test");
        classRoom.sendKeys("999");
        submitButton.click();
        System.out.println("Login Done with Click");

        //using submit method to submit the form. Submit used on password field
        driver.get(baseUrl);
        driver.findElement(By.id("classname")).sendKeys("selenium test");
        driver.findElement(By.name("department")).sendKeys("test");
        driver.findElement(By.name("classroom")).sendKeys("999");
        driver.findElement(By.id("addClass")).submit();
        System.out.println("Login Done with Submit");

        //driver.close();
        return new Response("got your form " + form.getCategory(), false);
    }
}
