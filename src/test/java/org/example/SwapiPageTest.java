package org.example;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwapiPageTest{

  private SwapiPageObjects swapi;

  @BeforeTest
  public void beforeTest() {this.swapi = new SwapiPageObjects(); }

  @AfterTest
  public void afterTest(){this.swapi.close();}


  //####################   PEOPLES   #####################
  @Test
  public void swapiRequestPeopleSuccessfully() throws InterruptedException {
    swapi.apiSearch("people/7");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();
  }
  @Test
  public void swapiMultipleRequestPeopleSuccessfully() throws InterruptedException {
    swapi.apiSearch("people/2");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();
    swapi.apiSearch("people/3");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();
    swapi.apiSearch("people/5");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();
    swapi.apiSearch("people/7");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();
    swapi.apiSearch("people/10");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();

  }

  @Test
  public void swapiRequestErrorPeopleSpecialCharacters() throws InterruptedException {
    swapi.apiSearch("people/$$$");
    swapi.btnRequest();
    swapi.validateRequestError();
  }

  @Test
  public void swapiRequestErrorPeopleAlphabetCharacters() throws InterruptedException {
    swapi.apiSearch("people/Luke Skywalker");
    swapi.btnRequest();
    swapi.validateRequestError();
  }

// #####################  PLANETS ########################

  @Test
  public void swapiRequestPlanetsSuccessfully() throws InterruptedException {
    swapi.apiSearch("planets/3");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();

  }
  @Test
  public void swapiMultipleRequestPlanetsSuccessfully() throws InterruptedException {
    swapi.apiSearch("planets/1");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();
    swapi.apiSearch("planets/3");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();
    swapi.apiSearch("planets/4");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();
    swapi.apiSearch("planets/7");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();
    swapi.apiSearch("planets/10");
    swapi.btnRequest();
    swapi.validateRequestSuccessfully();


  }

  @Test
  public void swapiRequestErrorPlanetsSpecialCharacters() throws InterruptedException {
    swapi.apiSearch("planets/$$$");
    swapi.btnRequest();
    swapi.validateRequestError();

  }

  @Test
  public void swapiRequestErrorPlanetsAlphabetCharacters() throws InterruptedException {
    swapi.apiSearch("planets/Kamino");
    swapi.btnRequest();
    swapi.validateRequestError();


  }




}


