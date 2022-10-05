package twitterBot.service;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

//Lord and savior came in clutch for the screenshot to base64 conversion
import org.apache.commons.codec.binary.Base64OutputStream;
import twitterBot.model.Profile;
import twitterBot.dao.JdbcProfileDao;

import java.util.ArrayList;
import java.util.List;


public class RobotService{

    public RobotService() throws AWTException {}
    private JdbcProfileDao jdbcProfileDao;

    Robot robot = new Robot();
    Rectangle rectangle = new Rectangle();
    Toolkit t = Toolkit.getDefaultToolkit();

    public BufferedImage takeScreenshot () {
        Dimension screenSize = t.getScreenSize();
        Rectangle screen = new Rectangle(screenSize.width, screenSize.height);
        return robot.createScreenCapture(screen);
    }

    public String convertScreenshotToBase64 (BufferedImage screenshot) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutputStream base64 = new Base64OutputStream(outputStream);
        ImageIO.write(screenshot, "png", base64);
        String profilePictureBase64 = outputStream.toString("UTF-8");
        return profilePictureBase64;

    }

    // Use this to check whether we get profile or create profile in database!
    public boolean ProfilePictureDoesExistInDatabase(BufferedImage screenshot){
        return false;
    }

    //Maybe use a boolean to test?
    public BufferedImage getProfilePictureFromScreenshot(BufferedImage screenshot) {

        Rectangle dmScreen = new Rectangle(420, 530);
        Rectangle profilePictureScreen = new Rectangle(40, 40);





        return new BufferedImage(0, 0, 0);
    }

    public Profile getProfileWithMatchingPFPIfExists(BufferedImage profilePicture) throws IOException {
        List<Profile> profiles = jdbcProfileDao.getAllProfiles();

        String profilePictureBase64 = convertScreenshotToBase64(profilePicture);

        for (Profile profile : profiles) {
            if (profilePictureBase64.equals(profile.getProfilePictureBase64())) {
                return profile;
            }
        }

        System.out.println("No Matching Profile Found, make a new one!");

        return new Profile();
    }

    public static void main (String[] args) throws AWTException, IOException{
        Robot robot = new Robot();
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();
        Rectangle screen = new Rectangle(screenSize.width, screenSize.height);
        Rectangle dmScreen = new Rectangle(screen.width - 420, screen.height - 530,420, 530);
        robot.delay(5000);
        BufferedImage dmScreenshot = robot.createScreenCapture(dmScreen);
        ImageIO.write(dmScreenshot, "png", new File("C:\\Users\\Student\\workspace\\TwitterEGDMBot\\src\\main\\java\\twitterBot\\screenshot\\dm.png"));

        //This moves the mouse to the corner of the dm screen! Progress (:
        //robot.mouseMove(screen.width - 420, screen.height - 530);
        //robot.mouseMove(0,0);
        System.out.println(screen.width);
    }



}
