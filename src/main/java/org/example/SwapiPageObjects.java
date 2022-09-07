package org.example;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SwapiPageObjects {

    private static final String URL_SWAPI = "https://swapi.dev/";

    private WebDriver driver;

    public  SwapiPageObjects() {
        System.setProperty("webdriver.Chrome.driver", "src\\driver\\chromedriver.exe");
        ChromeDriverService service = new ChromeDriverService.Builder()

                .usingDriverExecutable(new File("src\\driver\\chromedriver.exe"))

                .usingAnyFreePort()

                .build();

        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver = new ChromeDriver(service);
        this.driver.navigate().to(URL_SWAPI);
        driver.manage().window().maximize();

    }

    @Step("Pesquisar API -  API search")
    public void apiSearch(String value) throws InterruptedException {

        JavascriptExecutor pageDown = (JavascriptExecutor)driver;
        pageDown.executeScript("window.scroll(0, 600)");
        Thread.sleep(400);

        WebElement apiSearch = driver.findElement(By.id("interactive"));
        apiSearch.clear();
        apiSearch.sendKeys(value);
        screenshot();

    }

    @Step("Botão Request  - Button Request")
    public void btnRequest() throws InterruptedException {


        WebElement btnRequest = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/span[2]/button"));
        btnRequest.click();
        Thread.sleep(900);
        screenshot();

    }

    @Step("Validar requisição com erro  - Validate request with error")
    public void validateRequestError () throws InterruptedException {
        Thread.sleep(1000);
        WebElement validateMessage = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/pre"));
        String resultRequest = validateMessage.getText();
        Assert.assertTrue(resultRequest.contains("404 error"));

        screenshot();

    }

    @Step("Validar requisição  - Validate request")
    public void validateRequestSuccessfully () throws InterruptedException {
        Thread.sleep(1500);
        WebElement validateMessage = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/pre"));
        String resultRequest = validateMessage.getText();
        Assert.assertTrue(resultRequest.contains("name"));

        screenshot();

    }





    @Step("Fechar navegador - Close browser")
    public void close(){
        this.driver.quit();
    }

    @Attachment(value = "Passos", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
