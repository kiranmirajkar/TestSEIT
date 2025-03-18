package io.cucumber.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import org.openqa.selenium.By;

public class Navigation extends Context {

  public Navigation(Manager manager) {
    super(manager);
  }

  @Given("^the page under test is '(.+)'$")
  public void navToPage(String url) {
    if (!url.startsWith("http")) {
      url = "https://the-internet.herokuapp.com/" + url.toLowerCase().replace(" ", "_");
    }
    manager.getDriver().get(url);
  }

  @And("the user clicks on the {string} link")
  public void clickLink(String linkText) {
    manager.getDriver().findElement(By.linkText(linkText)).click();
  }

  @When("the {string} example is opened")
  public void the_example_is_opened(String example) {
    if (example.equalsIgnoreCase("Basic Auth")) {
      // If it's Basic Auth, navigate to the URL with embedded credentials
      String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
      manager.getDriver().get(url);
    } else {
      // Handle other cases if needed, or throw an exception for unsupported examples
      throw new UnsupportedOperationException("This example is not handled: " + example);
    }
  }
}
