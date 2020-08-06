package serviceLoaders;

import annotations.TestMethodInfo;
import org.testng.*;

public class ConsoleWriterLoader implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        TestMethodInfo annotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestMethodInfo.class);
        if (annotation != null) {
            System.out.println("Priority: " + annotation.priority() + " " + "Author: " + annotation.author() + " " + "Last Modified: " + annotation.lastModified());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
