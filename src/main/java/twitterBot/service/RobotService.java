package twitterBot.service;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
//Lord and savior came in clutch for the screenshot to base64 conversion
import org.apache.commons.codec.binary.Base64OutputStream;


public class RobotService{

    public RobotService() throws AWTException {}

    Robot robot = new Robot();
    Rectangle rectangle = new Rectangle();
    Toolkit t = Toolkit.getDefaultToolkit();

    public BufferedImage createPNGOfScreen () {
        Dimension screenSize = t.getScreenSize();
        Rectangle screen = new Rectangle(screenSize.width, screenSize.height);
        System.out.println(robot.createScreenCapture(screen).getType());
        return robot.createScreenCapture(screen);
    }

    public static void main (String[] args) throws AWTException, IOException {
        Robot robot = new Robot();

        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();
        Rectangle screen = new Rectangle(screenSize.width, screenSize.height);
        System.out.println(robot.createScreenCapture(screen).getType());
        BufferedImage screenshot = robot.createScreenCapture(screen);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        OutputStream b64 = new Base64OutputStream(os);
        ImageIO.write(screenshot, "png", b64);
        String result = os.toString("UTF-8");
        System.out.println(result);
    }

}
