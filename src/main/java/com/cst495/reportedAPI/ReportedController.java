package com.cst495.reportedAPI;

import com.cst495.reportedAPI.entities.Form;
import com.cst495.reportedAPI.entities.Response;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
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
    public Response submitPost(  @RequestBody Form form ){
        logger.log(Level.WARNING, "*******" + form.toString() + "*******" );
        //selenium
        return new Response("got your form " , false);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("seleniumTest")
    public Response seleniumTest() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/app/.apt/usr/bin/google-chrome");
        //WebDriver driver = new RemoteWebDriver(new java.net.URL("http://127.0.0.1:9515"), DesiredCapabilities.chrome());
        //driver.get("http://www.google.com");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://csr.dot.ca.gov/";
        driver.get(baseUrl);

//        WebElement className = driver.findElement(By.id("classname"));
//        WebElement department = driver.findElement(By.id("department"));
//        WebElement classRoom = driver.findElement(By.id("classroom"));
//
//        // Find the submit button
//        WebElement submitButton = driver.findElement(By.id("addClass"));
//
//        // Using click method to submit form
//        className.sendKeys("selenium Test 3");
//        department.sendKeys("test");
//        classRoom.sendKeys("999");
//        submitButton.click();
//
////      Deleting values in the text box
//        className.clear();
//        department.clear();
//        classRoom.clear();
//        System.out.println("Text Field Cleared");

        WebElement category = driver.findElement(By.id("typeDesc"));
        WebElement dirOfTravel = driver.findElement(By.id("dirTravel"));
        WebElement crossStreet = driver.findElement(By.id("crossStreet"));
        WebElement modeOfTrans = driver.findElement(By.id("transMode"));
        WebElement date = driver.findElement(By.id("situationNoticedDate"));
        WebElement time = driver.findElement(By.id("situationNoticedTime"));
        WebElement description = driver.findElement(By.id("situationDesc"));
        WebElement descriptionGeoLoc = driver.findElement(By.id("situationGeoLoc"));
        WebElement email = driver.findElement(By.id("custEmail"));
        WebElement name = driver.findElement(By.id("custName"));
        WebElement phone = driver.findElement(By.id("custPhone"));

        category.sendKeys("GRA");
        dirOfTravel.sendKeys("Northbound");
        crossStreet.sendKeys("999");
        modeOfTrans.sendKeys("Car");
        date.sendKeys("04/08/2019");
        time.sendKeys("1 am - 2 am");
        description.sendKeys("selenium test");
        descriptionGeoLoc.sendKeys("selenium test");
        email.sendKeys("selenium test");
        name.sendKeys("selenium test");
        phone.sendKeys("selenium test");




        //driver.close();
        return new Response("done with selenium test", false);
    }
}
