package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class Home extends Page {

  public Home(ChromeDriver driver) {
    super(driver);
  }

  @FindBy(css = "h1")
  private WebElement title;

  @FindBy(css = "#content ul li a")
  private List<WebElement> exampleLinks;

  public WebElement getTitle() {
    return title;
  }

  public List<String> getExampleLinksText() {
    return exampleLinks.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
}
}