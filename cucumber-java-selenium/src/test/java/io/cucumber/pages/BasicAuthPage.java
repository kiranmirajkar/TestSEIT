package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage extends Page {

    public BasicAuthPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.example p")
    private WebElement authMessage;

    public String getAuthMessage() {
        return authMessage.getText();
}
}