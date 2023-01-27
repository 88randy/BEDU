import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class StackoverflowTest {
    private WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);
    }

    @AfterTest
    public void teardown(){
        if (driver != null){
            driver.quit();
        }
    }
    /*
    * Realizaremos pruebas sobre la siguiente página de una pregunta de stack overflow
    * https://stackoverflow.com/questions/57455436/using-object-to-embed-svg-but-doesnt-show-anything/57536936#57536936
    * Una prueba que valide el título de la pregunta
    * Una prueba que valide el número de votos de la pregunta
    * Una prueba que valide el número de respuestas
    * Una prueba que valide el usuario de la primera respuesta
    * Una prueba que valide el número de la respuesta más votada
     */

    @Test
    public void verifyStackoverflowTitle() {
        driver.get("https://stackoverflow.com/questions/57455436/using-object-to-embed-svg-but-doesnt-show-anything/57536936#57536936");
        WebElement questionHeader = driver.findElement(By.id("question-header"));
        WebElement questionTitle = questionHeader.findElement(By.className("question-hyperlink"));
        String title = questionTitle.getText();
        assertEquals(title, "Using <object> to embed svg but doesn't show anything");
    }

    @Test
    public void verifyStackoverflowVotes() {
        driver.get("https://stackoverflow.com/questions/57455436/using-object-to-embed-svg-but-doesnt-show-anything/57536936#57536936");
        int expectedVotes = 0;
        int actualVotes = Integer.parseInt(driver.findElement(By.className("js-vote-count")).getAttribute("data-value"));
        assertEquals(expectedVotes, actualVotes);
    }

    @Test
    public void verifyStackoverflowAnswers() {
        driver.get("https://stackoverflow.com/questions/57455436/using-object-to-embed-svg-but-doesnt-show-anything/57536936#57536936");
        int expectedAnswers = 2;
        int actualAnswers = driver.findElements(By.className("js-answer")).size();
        assertEquals(expectedAnswers, actualAnswers);
    }

    @Test
    public void verifyStackoverflowFirstAnswerUser() {
        driver.get("https://stackoverflow.com/questions/57455436/using-object-to-embed-svg-but-doesnt-show-anything/57536936#57536936");
        String expectedUsername = "Noe Lopez";
        String actualUsername = driver.findElement(By.cssSelector("div.user-details > a")).getText();
        assertEquals(expectedUsername, actualUsername);
    }

    @Test
    public void verifyStackoverflowMostVotedAnswer() {
        driver.get("https://stackoverflow.com/questions/57455436/using-object-to-embed-svg-but-doesnt-show-anything/57536936#57536936");
        int expectedVotes = 0;
        int maxVotes = Integer.MIN_VALUE;
        List<WebElement> voteCountElements = driver.findElements(By.className("js-vote-count"));
        for (WebElement element : voteCountElements) {
            int currentVotes = Integer.parseInt(element.getAttribute("data-value"));
            if (currentVotes > maxVotes) {
                maxVotes = currentVotes;
                expectedVotes = currentVotes;
            }
        }
        assertEquals(expectedVotes, maxVotes);
    }
}