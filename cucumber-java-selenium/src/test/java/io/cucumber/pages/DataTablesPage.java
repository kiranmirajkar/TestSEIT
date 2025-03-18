package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class DataTablesPage extends Page {

    public DataTablesPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(css = "#table1 tbody tr")
    private List<WebElement> tableRows;

    public List<List<String>> getTableData() {
        return tableRows.stream().map(row ->
                row.findElements(By.tagName("td")).stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList())
        ).collect(Collectors.toList());
}
}