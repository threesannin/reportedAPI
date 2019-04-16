package com.cst495.reportedAPI;

import com.cst495.reportedAPI.entities.Form;
import com.cst495.reportedAPI.entities.Response;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.*;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ReportedController {

    private Logger logger = Logger.getLogger(ReportedController.class.getName());
    private static HashMap<String,String> mCategory = new HashMap<String,String>(){
        {
            put("Graffiti", "GRA");
            put("Illegal Encampment", "IEN");
            put("Landscaping - Weeds, Trees, Brush", "LDT");
            put("Litter - Trash and Debris", "LTD");
            put("Roadway - Pothole", "RPH");
            put("disabled", "DIV");
            put("Adopt-A-Highway", "AAH");
            put("Amtrak California", "ACA");
            put("Caltrain", "CTR");
            put("Chains/Snow Tires", "CST");
            put("Curb and Sidewalk - Cracked or Broken", "CSC");
            put("Current Highway Conditions/CHIN", "CHC");
            put("Deceased Animal", "DEA");
            put("DMV", "DMV");
            put("Electronic Message Signs (CMS)", "CMS");
            put("Fencing - Missing or Damaged", "FAA");
            put("Highway Advisory Radio", "HAR");
            put("HT65", "HT6");
            put("Illegal Connection", "ICO");
            put("Illegal Dumping", "IDP");
            put("Illicit Discharge", "IDC");
            put("Landscaping - Broken Sprinkler", "LDS");
            put("Litter - Unauthorized Signs, Banners or Posters", "LSB");
            put("Maps", "MAP");
            put("Other Service Request", "OTH");
            put("Park and Ride", "PNR");
            put("Permits", "PMT");
            put("QuickMap - Submit Corrections", "QMP");
            put("Report Misuse of a Caltrans Vehicle and/or Driver Issue", "RMV");
            put("Rest Area - Cleanliness, Plumbing", "RAC");
            put("Roadway - Flooding, Drainage, or Erosion", "RDF");
            put("Roadway - Guardrail Missing or Damaged", "RGM");
            put("Roadway - Rough Pavement", "RRP");
            put("Roadway - Stripes, Reflective Lane Markers", "RSR");
            put("Signs - Missing, Broken, Blocked or Down", "SMB");
            put("Soundwall - Down or Damaged", "SDW");
            put("Toll Lanes - Bay Area", "TLB");
            put("Toll Lanes - Los Angeles", "TLL");
            put("Toll Lanes - San Diego", "TLD");
            put("Toll Lanes - State Route 91", "TLS");
            put("Toll Roads - Orange County", "TLO");
            put("TOSNET", "TOS");
            put("Traffic Cameras", "VCA");
            put("Traffic Lighting", "TLN");
            put("Traffic or Work Zone Concerns", "WZN");
            put("Traffic Signal", "TSN");
            put("Unlisted Concern", "UNL");
        }
    };

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

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://csr.dot.ca.gov/";
        driver.get(baseUrl);

        //Elements in the WebPage
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

        //category.sendKeys("GRA");
        if(mCategory.containsKey(form.getCategory())){
            category.sendKeys(mCategory.get(form.getCategory()));
        } else{
            return new Response("error occurred while mapping category " , false);
        }
        dirOfTravel.sendKeys(form.getDirOfTravel());
        crossStreet.sendKeys(form.getCrossStreet());
        modeOfTrans.sendKeys(form.getModeOfTrans());
        date.sendKeys(form.getDate());
        time.sendKeys(form.getTime());
        description.sendKeys(form.getDescription());
        descriptionGeoLoc.sendKeys(form.getDescriptionGeoLoc());
        email.sendKeys(form.getEmail());
        if(form.isReceiveResponse()) {
            name.sendKeys(form.getName());
            phone.sendKeys(form.getPhone());
        }

        driver.close();
        return new Response("got your form " , false);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("seleniumTest")
    public Response seleniumTest() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://csr.dot.ca.gov/";
        driver.get(baseUrl);

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

        driver.close();
        return new Response("done with selenium test", false);
    }
}
