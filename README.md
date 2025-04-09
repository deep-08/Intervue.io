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
Add the following dependencies to your pom.xml file for Selenium and file handling:

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
  - Run the following command in the project root directory:
mvn clean install

## 4..Set Up ChromeDriver
Option 1: Manual Setup
Download ChromeDriver from https://chromedriver.chromium.org/ matching your Chrome version.

Place it in a known location (e.g., C:\drivers\chromedriver.exe on Windows or /usr/local/bin/chromedriver on Linux/Mac).

Update the script before WebDriver initialization:
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

## Create Screenshots Folder
  Create a screenshots directory in the project root to store login failure screenshots:
  // mkdir screenshots





