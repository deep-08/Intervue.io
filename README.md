Intervue Homepage Login and Navigation Test Script
This repository contains a Selenium-based Java test script (LandingHomePage.java) that automates login testing and subsequent navigation on the Intervue website (https://www.intervue.io/). The script logs in, checks for login success or failure, takes a screenshot on failure, and performs additional actions like searching and logging out if the login succeeds.

Prerequisites
Before running the script, ensure you have the following installed:

Java Development Kit (JDK): Version 8 or higher (e.g., OpenJDK or Oracle JDK)
Maven: For dependency management (download from maven.apache.org)
Google Chrome Browser: Required for ChromeDriver
IDE (Optional): IntelliJ IDEA, Eclipse, or any Java IDE for easier development
Project Setup
Clone or Create the Project
Clone this repository or create a new Maven project:
bash

Collapse

Wrap

Copy
git clone <repository-url>
cd intervue-homepage-test
Alternatively, create a directory and copy LandingHomePage.java into src/main/java/intervueHomepage/.
Configure pom.xml
Add these dependencies to your pom.xml:
xml

Collapse

Wrap

Copy
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.intervue</groupId>
    <artifactId>intervue-homepage-test</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.18.1</version>
        </dependency>
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.15.1</version>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.7.0</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
Install Dependencies
Run this command in the project root:
bash

Collapse

Wrap

Copy
mvn clean install
Set Up ChromeDriver
Option 1: Manual Setup
Download ChromeDriver from chromedriver.chromium.org matching your Chrome version.
Place it in a known location (e.g., C:\drivers\chromedriver.exe or /usr/local/bin/chromedriver).
Update the script:
java

Collapse

Wrap

Copy
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
Option 2: Use WebDriverManager (Recommended)
Add this before initializing the driver:
java

Collapse

Wrap

Copy
import io.github.bonigarcia.wdm.WebDriverManager;
WebDriverManager.chromedriver().setup();
Create Screenshots Folder
Create a screenshots directory in the project root:
bash

Collapse

Wrap

Copy
mkdir screenshots
Script Overview
File: src/main/java/intervueHomepage/LandingHomePage.java
Functionality:
Opens https://www.intervue.io/ in Chrome.
Clicks the "Login" button on the homepage.
Switches to the new tab.
Attempts login with neha@intervue.io / Ps@neha@123.
Checks for failure using //span[@class='ant-alert-description'].
Takes a screenshot on login failure (saved in screenshots/ with a timestamp).
On success:
Clicks the search placeholder.
Searches for "hello".
Submits the search.
Clicks the profile header.
Logs out.
Closes the browser.
Execution Instructions
Compile the Project
Run:
bash

Collapse

Wrap

Copy
mvn compile
Run the Script
Execute with Maven:
bash

Collapse

Wrap

Copy
mvn exec:java -Dexec.mainClass="intervueHomepage.LandingHomePage"
Or run in an IDE by opening LandingHomePage.java and clicking "Run".
Expected Output
Console logs:
"Switched to new tab: <URL>"
"New tab title: <title>"
"Login failed! Screenshot saved at: <path>" (if login fails)
"Login successful! Proceeding to next step..." (if login succeeds, followed by search/logout actions)
"Error: <message>" (on exceptions)
Browser closes after execution.
Customization
Login Credentials
Update in the script:
java

Collapse

Wrap

Copy
driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("your_email");
driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("your_password");
Failure Detection
Verify //span[@class='ant-alert-description'] matches the login error element; adjust if needed.
Post-Login Actions
Modify the search term ("hello") or add steps after logout in the else block.
Troubleshooting
NoSuchElementException
Verify XPaths in Chrome DevTools (F12).
Tab Not Switching
Increase Thread.sleep(2000) or use WebDriverWait.
Screenshot Not Saving
Ensure the screenshots folder exists and is writable.
Login Failure Detection Failing
Inspect the page after a failed login to confirm the error XPath.
Notes
Uses Thread.sleep() for simplicity; consider WebDriverWait for production.
Requires an internet connection.
Browser closes automatically via driver.quit().
Notes on Formatting
Used Markdown headings (#, ##) for structure.
Code blocks (```) for commands and code snippets.
Bold (**) for emphasis on tools and options.
Bullet points (-) and numbered lists (1.) for clarity.
