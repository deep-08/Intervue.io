
# Intervue Homepage Login and Navigation Test Script

This repository contains a **Selenium-based Java test script** (`LandingHomePage.java`) that automates login testing and subsequent navigation on the Intervue website ([https://www.intervue.io/](https://www.intervue.io/)).  
The script logs in, checks for login success or failure, takes a screenshot on failure, and performs additional actions like searching and logging out if the login succeeds.

---

## Prerequisites

Before running the script, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or higher (e.g., OpenJDK or Oracle JDK).
- **Maven**: For dependency management ([https://maven.apache.org](https://maven.apache.org)).
- **Google Chrome Browser**: The script uses ChromeDriver, so Chrome must be installed.
- **IDE (Optional)**: IntelliJ IDEA, Eclipse, or any Java IDE for easier development.

---

## Project Setup

### 1. Clone or Create the Project

Clone this repository or create a new Maven project:

## Alternatively, create a new directory and copy the provided LandingHomePage.java into:

- src/main/java/intervueHomepage/

## 2.Configure pom.xml
### Add the following dependencies to your pom.xml file for Selenium and file handling:
        
      <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>SeleniumWebdriver</groupId>
      <artifactId>Intervue</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <name>Intervue</name>
      
      <dependencies>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.27.0</version>
    </dependency>
    
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.5.3</version> <!-- Latest version -->
    </dependency>
      	
      </dependencies>
      
    </project>

 ## 3.Install Dependencies
    Run the following command in the project root directory:    mvn clean install

## 4..Set Up ChromeDriver
Option 1: Manual Setup
Download ChromeDriver from https://chromedriver.chromium.org/ matching your Chrome version.

Place it in a known location (e.g., C:\drivers\chromedriver.exe on Windows or /usr/local/bin/chromedriver on Linux/Mac).

## Update the script before WebDriver initialization:
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

## Create Screenshots Folder
    Create a screenshots directory in the project root to store login failure screenshots: mkdir screenshots

  
# Script Overview
     File: src/main/java/intervueHomepage/LandingHomePage.java

## Functionality:
  **Opens https://www.intervue.io/ in Chrome.**

- Clicks the "Login" button on the homepage.

**Switches to the new tab that opens.**

## Attempts login with credentials:
  neha@intervue.io / Ps@neha@123

## Checks for login failure using:
    //span[@class='ant-alert-description']
- Takes a screenshot if login fails (saved in screenshots/ with a timestamp).

**If login succeeds:**

- Clicks the search placeholder.

- Enters "hello" in the search field.

**Submits the search.**

- Clicks a profile header.

- Logs out.

## Closes the browser after execution.

# Execution Instructions
## 1. Compile the Project

-- mvn compile

## 2. Run the Script
- Execute using Maven:

      mvn exec:java -Dexec.mainClass="intervueHomepage.LandingHomePage"
Or, run it directly in your IDE by opening LandingHomePage.java and clicking Run.

## Expected Output
 Console logs will show:

- Switched to new tab: <URL> and New tab title: <title> on successful tab switch.

- Login failed! Screenshot saved at: <path> if login fails, with a screenshot in the screenshots/ folder.

- Login successful! Proceeding to next step... if login succeeds, followed by search and logout actions.

- Error: <message> if an exception occurs (e.g., element not found).

- The browser closes automatically after execution.

# Customization
- Login Credentials: Update the email and password in the script if needed:

      driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("your_email");
      driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("your_password");

## Failure Detection: The current failure check uses //span[@class='ant-alert-description'].
**Verify this matches the error element on the login page after a failed attempt, or update accordingly.**

- Post-Login Actions: Modify the search term ("hello") or add more steps after logout in the else block.

# Troubleshooting
    NoSuchElementException: Ensure all XPaths match the current webpage structure. Inspect using Chrome DevTools (F12).

- Tab Not Switching: Increase Thread.sleep(2000) if the new tab takes longer to open, or replace with WebDriverWait.

- Screenshot Not Saving: Confirm the screenshots/ folder exists and is writable.

- Login Failure Detection Failing: Inspect the page after a failed login to confirm the error element's XPath.

# Notes
- The script uses Thread.sleep() for simplicity. For production use, consider replacing with WebDriverWait for more robust timing.

- Ensure an active internet connection, as the script interacts with a live website.

- The browser closes automatically due to driver.quit() in the finally block.




