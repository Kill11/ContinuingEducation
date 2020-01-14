import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main extends Thread {

    public static String in = null;
    boolean status = false;
    Chrome chrome;
    public static Logger logger = Logger.getLogger(Main.class);

    Main(){
        chrome = new Chrome();
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Thread t = new Thread(new Main());
        t.start();
        while (true) {
            if (in == null) {
                in = scanner.nextLine();
            }
            if (!t.isAlive()) {
                logger.info("程序已退出，再见");
                return;
            }
            sleep(3000);
        }
    }

    @Override
    public void run() {
        //监听命令
        while (true) {
//            System.out.println("runing...");
            if (in != null) {
                if (in.equals("quit")) {
                    logger.info("退出程序");
                    chrome.driver.quit();
                    return;
                } else if (in.equals("open")) {
                    logger.info("打开目标站点");
                    chrome.open();
                } else if(in.equals("start")){
                    logger.info("开始监听答题窗口");
                    status = true;
                } else if(in.equals("stop")){
                    logger.info("停止监听答题窗口");
                    status = false;
                } else if(in.equals("refresh")){
                    logger.info("刷新页面");
                    chrome.refresh();
                }
                in = null;
            }
            if(status){
                chrome.jianting();
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
