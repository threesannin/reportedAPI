package com.cst495.reportedAPI;

import com.cst495.reportedAPI.entities.Form;
import com.cst495.reportedAPI.entities.Response;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
    public Form testCall() {
        Form f = new Form("Unlisted Concern", "Northbound", "Car", "main n second",
                "04/13/2019", "1.2.12", "12.321.12", "selenium Test server test",
                "Name","seleniumTest@gmail.com", "831 770-9620", "wrong neighborhood",true);
        return f;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("submitPost")
    public Response submitPost(  @RequestBody Form form ){
        logger.log(Level.WARNING, "*******" + form.toString() + "*******" );
        //selenium

        //System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe"); // windows
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver"); // MAC
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
//        WebElement descriptionGeoLoc = driver.findElement(By.id("situationGeoLoc"));
        WebElement email = driver.findElement(By.id("custEmail"));
        WebElement name = driver.findElement(By.id("custName"));
        WebElement phone = driver.findElement(By.id("custPhone"));
        WebElement mapSearchInput = driver.findElement(By.id("pac-input"));
        WebElement submitFormButton = driver.findElement(By.id("submitBttn"));

        //category.sendKeys("GRA");
        if(mCategory.containsKey(form.getIssueCategory())){
            category.sendKeys(mCategory.get(form.getIssueCategory()));
        } else{
            return new Response("error occurred while mapping category " , false);
        }
        mapSearchInput.sendKeys(form.getNearestCrossStreet() + Keys.ENTER);

        dirOfTravel.sendKeys(form.getDirOfTravel());
        crossStreet.sendKeys(form.getNearestCrossStreet());
        modeOfTrans.sendKeys(form.getTransMode());
        String dateTime = form.getDateTime();
        System.out.println(dateTime);
        String dateS = dateTime.substring(0,dateTime.indexOf(" at"));
        System.out.println(dateS);
        String timeS = dateTime.substring(dateTime.indexOf("at ")+3, dateTime.indexOf(':'));
        System.out.println(timeS);
        String amPM = dateTime.substring(dateTime.length()-2, dateTime.length());
        System.out.println(amPM);
        String finalTime = "";
        if(timeS.equals("12")){
            if(amPM.equals("AM")){
                finalTime+="midnight - 1 am";
            }else{
                finalTime += "12 noon - 1 pm";
            }
        } else{
            finalTime += timeS + " " + amPM + " - ";
            int t = 1 + Integer.parseInt(timeS);
            if(t == 12){
                if(amPM.equals("AM"))
                    finalTime += "12 noon";
                else
                    finalTime += "midnight";
            } else {
                finalTime += t + " " + amPM;
            }
        }
        System.out.println(finalTime);

        date.sendKeys(dateS);
        time.sendKeys(finalTime);

        description.sendKeys(form.getDescripText());
//        descriptionGeoLoc.sendKeys(form.getDescriptionGeoLoc());
        email.sendKeys(form.getEmail());
        if(form.isFollowUp()) {
            name.sendKeys(form.getName());
            phone.sendKeys(form.getPhone());
        }
        submitFormButton.click();


//        driver.close();
        return new Response("got your form " , false);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("seleniumTest")
    public Response seleniumTest() throws MalformedURLException {

//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe"); //Windows
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver"); // MAC


        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://csr.dot.ca.gov/";

        driver.get(baseUrl);

        WebElement category = driver.findElement(By.id("typeDesc"));
        WebElement dirOfTravel = driver.findElement(By.id("dirTravel"));

//        Select dirOfTravel = new Select(driver.findElement(By.id("dirTravel")));
        WebElement crossStreet = driver.findElement(By.id("crossStreet"));
        WebElement modeOfTrans = driver.findElement(By.id("transMode"));
        WebElement date = driver.findElement(By.id("situationNoticedDate"));
        WebElement time = driver.findElement(By.id("situationNoticedTime"));
        WebElement description = driver.findElement(By.id("situationDesc"));
        WebElement descriptionGeoLoc = driver.findElement(By.id("situationGeoLoc"));
        WebElement email = driver.findElement(By.id("custEmail"));
        WebElement name = driver.findElement(By.id("custName"));
        WebElement phone = driver.findElement(By.id("custPhone"));
        WebElement mapSearchInput = driver.findElement(By.id("pac-input"));
        WebElement submitFormButton = driver.findElement(By.id("submitBttn"));

        category.sendKeys("GRA");
        mapSearchInput.sendKeys("100 Twelfth St, Marina, CA 93933, USA" + Keys.ENTER);

        dirOfTravel.sendKeys("Northbound");
//        dirOfTravel.selectByVisibleText("Northbound");
        crossStreet.sendKeys("999");
        modeOfTrans.sendKeys("Car");
        date.sendKeys("04/08/2019");
        time.sendKeys("1 am - 2 am");
        description.sendKeys("selenium test");
        descriptionGeoLoc.sendKeys("selenium test");
        email.sendKeys("v1030615@nwytg.net");
        name.sendKeys("selenium test");
        phone.sendKeys("selenium test");
        submitFormButton.click();

//        driver.close();
        return new Response("done with selenium test", false);
    }
}
