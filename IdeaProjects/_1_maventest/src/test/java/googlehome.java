import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

public class googlehome {
    private WebDriver driver;
    String appURL = "http://google.com";
    static ExtentReports extent;
    static ExtentTest logger;
    static ExtentHtmlReporter htmlReporter;
    static String htmlreportpath="C:\\Users\\ashis\\Desktop/ownreport.html";
     ITestResult result;

@BeforeTest
public void setup(){
    htmlReporter =new ExtentHtmlReporter(htmlreportpath);
    extent= new ExtentReports();
    extent.attachReporter(htmlReporter);

}


    @BeforeClass
    public void testSetUp() {
System.out.println("before class");
    }

    @Test
    public void verifyGooglePageTittle() {
        logger=extent.createTest("Google","homepage test");
        logger.log(Status.INFO,"opened webpage");

        Assert.assertEquals("Google", "Google");
       logger.log(Status.FAIL,"Google page loaded");

        Reporter.log("pass");
}
@AfterMethod

public void getresult(ITestResult result) throws Exception {
    if (result.getStatus() == ITestResult.FAILURE) {
        logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
        logger.fail(result.getThrowable());
    } else if (result.getStatus() == ITestResult.SUCCESS) {
        logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
    } else if (result.getStatus() == ITestResult.SKIP) {
        logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
    }

}

    @AfterTest
    public void testend() throws Exception {
        extent.flush();
    }


    @AfterClass
    public void tearDown() {
        System.out.println("After Class");
    }

}
