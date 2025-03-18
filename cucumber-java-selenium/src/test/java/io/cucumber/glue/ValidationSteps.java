package io.cucumber.glue;

import io.cucumber.java.en.Then;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.pages.BasicAuthPage;
import io.cucumber.pages.DataTablesPage;
import io.cucumber.pages.Home;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationSteps extends Context {

    private static final List<String> EXPECTED_LINKS = Arrays.asList(
            "A/B Testing",
            "Add/Remove Elements",
            "Basic Auth (user and pass: admin)",
            "Broken Images",
            "Challenging DOM",
            "Context Menu",
            "Digest Authentication (user and pass: admin)",
            "Disappearing Elements",
            "Drag and Drop",
            "Dropdown",
            "Dynamic Content",
            "Dynamic Controls",
            "Dynamic Loading",
            "Entry Ad",
            "Exit Intent",
            "File Download",
            "File Upload",
            "Floating Menu",
            "Forgot Password",
            "Form Authentication",
            "Geolocation",
            "Horizontal Slider",
            "Infinite Scroll",
            "Inputs",
            "JavaScript Alerts",
            "JavaScript onload event error",
            "Key Presses",
            "Large & Deep DOM",
            "Multiple Windows",
            "Nested Frames",
            "Notification Messages",
            "Redirect Link",
            "Secure File Download",
            "Shadow DOM",
            "Shifting Content",
            "Slow Resources",
            "Sortable Data Tables",
            "Status Codes",
            "Typos",
            "WYSIWYG Editor"
    );

    public ValidationSteps(Manager manager) {
        super(manager);
    }

    @Then("the list of examples contains all expected entries")
    public void verifyExampleLinks() {
        Home home = new Home((ChromeDriver) manager.getDriver());
        List<String> actualLinks = home.getExampleLinksText();

        // Print each actual link
        for (String link : actualLinks) {
            System.out.println( link);
        }

        // Verify expected links are present
        assertTrue(actualLinks.containsAll(EXPECTED_LINKS));
    }

    @Then("Congratulations should be displayed")
    public void verifyBasicAuthSuccess() {
        BasicAuthPage authPage = new BasicAuthPage((ChromeDriver) manager.getDriver());
        assertTrue(authPage.getAuthMessage().contains("Congratulations"));
    }

    @Then("Example 1 table displays expected results")
    public void verifyTableData() throws InterruptedException {
        DataTablesPage tablesPage = new DataTablesPage((ChromeDriver) manager.getDriver());
        Thread.sleep(5000);
        List<List<String>> expectedData = Arrays.asList(
                Arrays.asList("Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com"),
                Arrays.asList("Bach", "Frank", "fbach@yahoo.com", "$51.00", "http://www.frank.com"),
                Arrays.asList("Doe", "Jason", "jdoe@hotmail.com", "$100.00", "http://www.jdoe.com"),
                Arrays.asList("Conway", "Tim", "tconway@earthlink.net", "$50.00", "http://www.timconway.com")
        );
        assertEquals(expectedData, tablesPage.getTableData());
}
}