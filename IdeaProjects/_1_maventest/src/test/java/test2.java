import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test2 {

    @Test
    public void test2verify()   {
        googlehome.logger=googlehome.extent.createTest("Test2","homepage test");
        googlehome.logger.log(Status.INFO,"opened webpage");

        Assert.assertEquals("Google", "Google");
        googlehome.logger.log(Status.FAIL,"Test2 page loaded");

        Reporter.log("pass");
    }


}
