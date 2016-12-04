package com.custom_runner;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.io.FileWriter;
import java.io.IOException;

public class CustomRunListener extends RunListener {
    private StringBuffer resultContent = new StringBuffer();
    private StringBuffer failureContent = new StringBuffer();
    private String cellSeparator = "</td><td>";
    private String rowSeparator = "</tr><tr>";
    private String fileName = "./TestReport.html";
    private FileWriter fileWriter = new FileWriter(fileName, true);

    public CustomRunListener() throws IOException {
    }


    @Override
    public void testRunStarted(Description description) throws Exception {
        resultContent.append("<h1>Tests executed:</h1>")
                .append("<table border=\"1\"><tr><th>Test Class</th>" +
                        "<th>Test Method</th></tr><tr>");
        System.out.println(resultContent.toString());
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        resultContent.append("</td></tr></table><br /><h1>Test Summary:</h1><table border=\"1\">" +
                "<tr><th>Tests</th><th>Success</th>" +
                "<th>Test Time (seconds)</th></tr><tr><td>");
        int numberOfTest = result.getRunCount();
        int numberOfTestFail = result.getFailureCount();
        int numberOfTestIgnore = result.getIgnoreCount();
        int numberOfTestSuccess = numberOfTest - numberOfTestFail - numberOfTestIgnore;

        double time = result.getRunTime();
        resultContent.append(numberOfTest+cellSeparator)
        .append(numberOfTestSuccess+cellSeparator)
        .append(Double.valueOf(time / 1000))
        .append("</td></tr></table><br />");
        System.out.println(resultContent.toString());
        fileWriter.write(resultContent.toString());
        if(failureContent.length()>0){
            fileWriter.write(failureContent.toString());
        }
        fileWriter.close();
    }

    @Override
    public void testStarted(Description description) throws Exception {
        resultContent.append("<td>"+description.getClassName()
                +cellSeparator
                +description.getMethodName()+"</td>"
                +rowSeparator);
        System.out.println(resultContent.toString());
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        failureContent.append("Test failure:" + failure.getDescription());
    }


    @Override
    public void testIgnored(Description description) throws Exception {
        failureContent.append("Test ignored: " + description.getDisplayName());
    }
}
