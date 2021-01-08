import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideoPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class=\"lister_pop_box\"]/div[@class=\"question\"]")
    WebElement questionWindow;

    @FindBy(xpath = "//*[@id=\"answer\"]")
    WebElement correctAnswer;

    @FindBy(xpath = "//span[@value=\"A\"]")
    WebElement A;

    @FindBy(xpath = "//span[@value=\"B\"]")
    WebElement B;

    @FindBy(xpath = "//span[@value=\"C\"]")
    WebElement C;

    @FindBy(xpath = "//span[@value=\"D\"]")
    WebElement D;

    @FindBy(xpath = "//*[@id=\"player\"]/div[8]/div/div[2]/div/div[3]/span")
    WebElement answerButton;

    @FindBy(xpath = "//*[@id=\"player\"]/div[8]/div[2]/div[2]")
    WebElement failWindow;

    @FindBy(xpath = "//*[@id=\"player\"]/div[8]/div[2]/div[2]/div/div[2]/span")
    WebElement failButton;

    public VideoPage(WebDriver driver){
    this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
