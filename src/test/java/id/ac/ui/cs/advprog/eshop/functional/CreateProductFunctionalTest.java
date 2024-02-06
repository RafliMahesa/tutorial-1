package id.ac.ui.cs.advprog.eshop.functional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import io.github.bonigarcia.seljup.SeleniumJupiter;
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
        /**
     * The port number assigned to the running application during test execution. * Set automatically during each test run by Spring Framework's test context. */
    @LocalServerPort
    private int serverPort;
     /**
     * The base URL for testing. Default to {@code http://localhost}.
     */
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void pageTitle_isCorrect (ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);

        // Click button to product list page
        driver.findElement(By.tagName("a")).click();

        // Click button to create product page
        driver.findElement(By.tagName("a")).click();
        String h3String = driver.findElement(By.tagName("h3")).getText();
        // Verify
        assertEquals("Create New Product", h3String);
    }

    @Test
    void makeProduct_isCorrect (ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);

        // Click button to product list page
        driver.findElement(By.tagName("a")).click();

        // Click button to create product page
        driver.findElement(By.tagName("a")).click();

        String name = "box";
        String quantity = "3";

        // Fill in the product name
        WebElement fieldForName = driver.findElement(By.id("nameInput"));
        fieldForName.clear();
        fieldForName.sendKeys(name);

        // Fill in the product quantity
        WebElement fieldForQuantity = driver.findElement(By.id("quantityInput"));
        fieldForQuantity.clear();
        fieldForQuantity.sendKeys(quantity);
        
        driver.findElement(By.id("submit")).click();

        String webSourceCode = driver.getPageSource();

        // Verify
        assertTrue(webSourceCode.contains(name));
        assertTrue(webSourceCode.contains(quantity));
        
    }
}
