import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class Chrome {
    public WebDriver driver;
    public VideoPage videoPage;
    public static Logger logger = Logger.getLogger(Chrome.class);

    Chrome(){
//        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
        videoPage = new VideoPage(driver);
    }

    public void open() {
        driver.get("http://jxjy.czt.zj.gov.cn/front/jxjy.html");
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public void jianting() {
        if(isAvailable(videoPage.questionWindow)){
            logger.info("发现答题弹窗");
            logger.info("尝试答题，回答A");
            try{videoPage.A.click();}catch (NoSuchElementException e){logger.info("没找到选项");}
            try { sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            videoPage.answerButton.click();
            try { sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
//            driver.navigate().refresh();
        }
        if(isAvailable(videoPage.failWindow)){
            logger.info("回答失败");
            videoPage.failButton.click();
            try { sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            logger.info("尝试获取正确回答");
            String anstext = videoPage.correctAnswer.getText();
            String ans = getans2(anstext);
            logger.info("正确回答为"+ans+",开始填充正确回答");
            //先把之前的A给取消掉
            videoPage.A.click();
            try { sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            if(ans.contains("A")){
                videoPage.A.click();
                try { sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            if(ans.contains("B")){
                videoPage.B.click();
                try { sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            if(ans.contains("C")){
                videoPage.C.click();
                try { sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            if(ans.contains("D")){
                videoPage.D.click();
                try { sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            videoPage.answerButton.click();
            try { sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }

            logger.info("二次回答成功");
        }
    }

    Boolean isAvailable(WebElement webElement){
        try {
            if (webElement.isDisplayed()) {
//                System.out.println("发现答题弹窗");
                return true;
            }else {
//                System.out.println("找到了，没看到");
                return false;
            }
        }catch (NoSuchElementException e){
//            System.out.println("没找到");
            return false;
        }
    }

    public static char getans(String anstext) {
        Pattern pattern = Pattern.compile("正确答案：(.*)");
        Matcher m = pattern.matcher(anstext);
        String str="";
        if (m.find()) {
            str = m.group(1);
        }
        char ans = str.toCharArray()[0];
        return ans;
    }

    public static String getans2(String anstext) {
        Pattern pattern = Pattern.compile("正确答案：(.*)");
        Matcher m = pattern.matcher(anstext);
        String str="";
        if (m.find()) {
            str = m.group(1);
        }
        return str;
    }
}
