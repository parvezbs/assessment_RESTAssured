This is a REST API automation framework to test DarkSKY APIs using RESTAssured test automation tool using JAVA.
All the test cases, framework is written and available in the suite.
There is one challenge with respect to Jackson JSON binders were not bbeing downloaded on my machine 
which is causing to bind the JAVA object and JSON objects to bind together. This will fail few test cases 
which will evaluate Object types. All the logic is written. Just resolving the dependencies will do the job.

How to execute the test suite:
There is a jar file named "DarkSky_API_automation.jar"
All you need to do is, checkout the project to the local machine.
And from the same directory, lanch command promt.
Enter command: java -jar DarkSky_API_automation.jar
That's all! Automation will start and the testng report will publish the result in the test-output directory.

Pre-requisites:
Need to have java installed on your machine to run and see the test cases.

Test cases:
will evaluate the content of the json objects, validate presence of json objects, array sizes, read data of a specofic child array value, etc.
There will be 4 failed test cases which will fail with an error: "java.lang.IllegalStateException: Cannot parse object because no JSON deserializer found in classpath. Please put either Jackson or Gson in the classpath."
Like mentioned above, mvn is unable to download the packages hence the binding between json and java objects fail 
which will fail to evaluate the objec types. Other than that, all other tests pass.

Please let me know if any questions/comments.

Thanks,
Parvez
9985300392
s.parvezbasha@gmail.com
