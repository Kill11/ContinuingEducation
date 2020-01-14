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

    @FindBy(xpath = "//div[@class=\"lister_pop_box\"]/div[@class=\"question\"]/div[@class=\"pop_box_foot clearfix\"]/span[@class=\"box-sure\"]")
    WebElement answerButton;

    @FindBy(xpath = "//div[@class=\"lister_pop_box pop-tip-panel\"]/div[@class=\"question\"]")
    WebElement failWindow;

    @FindBy(xpath = "//div[@class=\"lister_pop_box pop-tip-panel\"]/div[@class=\"question\"]/div[@class=\"pop_box_foot clearfix\"]/span[@class=\"box-sure\"]")
    WebElement failButton;

    public VideoPage(WebDriver driver){
    this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
