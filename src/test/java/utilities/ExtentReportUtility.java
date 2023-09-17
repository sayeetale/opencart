package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.Baseclass;

public class ExtentReportUtility implements ITestListener
{

	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	 String reportname;
	public void onStart(ITestContext testcontext)
	{
		Date d1 = new Date();
		SimpleDateFormat sp = new SimpleDateFormat ("yyyy.MM.dd.HH.mm.ss");
	 String timestamp = sp.format(d1);
	 
//	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
	 
     reportname = "test-report" +timestamp+ ".html";
      
       sparkreporter = new ExtentSparkReporter(".\\TestReports\\"+ reportname);
       
      // sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReport.html");
       
     /* String abc = System.getProperty("user.dir") + "\\reports\\" + reportname;
      sparkreporter = new ExtentSparkReporter(abc);*/
      
       sparkreporter.config().setDocumentTitle("Opencart Automation Report");
       sparkreporter.config().setReportName("Functional Opencart Testing");
       sparkreporter.config().setTheme(Theme.DARK);
       
        extent = new ExtentReports();
        extent.attachReporter(sparkreporter);
        extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
	}
		/*public void onTestSuccess​(ITestResult result)
		{
			 test = extent.createTest(result.getName());
			 test.log(Status.PASS, "test pass");
		}*/
	
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
	
        public void onTestFailure(ITestResult result)
        {
        	test = extent.createTest(result.getName());
			 test.log(Status.FAIL, "test fail");
			 test.log(Status.FAIL, result.getThrowable().getMessage());
			 String imgPath;
			try {
				imgPath = new Baseclass().capturescreen(result.getName());
				test.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
        	
        }
        public void onTestSkipped(ITestResult result)
        {
        	test = extent.createTest(result.getName());
			 test.log(Status.SKIP, "test skip");
			 test.log(Status.SKIP, result.getThrowable().getMessage());
        	
        }
        
        public void onFinish(ITestContext testContext) {
    		extent.flush();
      
		
	}
}
	
	
	
	
	

