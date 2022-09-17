# Automated mobile tests for Wikipedia app on Android

## :tv: Contents

- <a href="#tv-technology-stack">Technology stack</a>
- <a href="#tv-launch">Launch</a>
- <a href="#tv-jenkins-build">Jenkins build</a>
- <a href="#tv-Test-results-report-in-Allure-Report">Test results report in Allure Report</a>
- <a href="#tv-Video-attach-example">Video attach example</a>

## :tv: Technology stack

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logos/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logos/Java.svg">
<img width="6%" title="Selenide" src="images/logos/Selenide.svg">
<img width="6%" title="Appium" src="images/logos/Appium.svg">
<img width="6%" title="Allure Report" src="images/logos/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logos/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logos/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logos/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logos/Jenkins.svg">
<img width="6%" title="Allure TestOps" src="images/logos/Allure_TO.svg">
</p>

## :tv: Launch

### To launch tests remotely on Browserstack use the following command:

```
gradle clean test
```

### Launch tests on the local machine with emulation

You must have Android Studio and Appium installed and configured, and edit LocalConfig.properties file to match device and OS version yours emulation device.
To launch test locally use the following command:

```
gradle clean test -Dhost=local
```

## <img width="4%" title="Jenkins" src="images/logos/Jenkins.svg"> [Jenkins build](https://jenkins.autotests.cloud/job/C12-tevton-unit21/)

<p align="center">
  <img src="images/screens/Jenkins.png">
</p>

## <img width="4%" title="Allure Report" src="images/logos/Allure_Report.svg"> Test results report in [Allure Report](https://jenkins.autotests.cloud/job/C12-tevton-unit21/allure/)
### :pushpin: Allure report main page

<p align="center">
<img title="Allure Overview" src="images/screens/allure_overview.png">
</p>

### :pushpin: The test suite

<p align="center">
<img title="Allure Behaviors" src="images/screens/allure_test_suite.png">
</p>

## <img width="4%" title="Selenoid" src="images/logos/Selenoid.svg"> Video attach example
Each test in the report is accompanied by a video. One such video is shown below.
<p align="center">
  <img title="Selenoid Video" src="images/gif/Test_video.gif">
</p>