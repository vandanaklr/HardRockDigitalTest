This project is a small Selenium-TestNG automation framework built to test [HardRockDigital.com](https://www.hardrockdigital.com).  
It focuses on verifying that the social media icons (Twitter and LinkedIn) on the homepage open the correct pages in new tabs.
What This Project Does

I created a few simple yet practical UI tests using **Java, Selenium, and TestNG**.  
Here’s what the tests currently cover:

- **Launch the Hard Rock Digital homepage** in Chrome
- **Click the Twitter icon** in the footer and verify it opens [https://x.com/HardRockDigital](https://x.com/HardRockDigital) in a new tab
- **Close the Twitter tab** and switch back to the main site
- **Click the LinkedIn icon** and verify it redirects correctly
- Cleanly **close all browser sessions** at the end

These tests use the **Page Object Model (POM)** approach to keep locators and actions separate from test logic.

## ⚙️ Tools & Technologies

- **Language:** Java
- **Automation Framework:** Selenium WebDriver + TestNG
- **Driver Manager:** WebDriverManager
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA

The framework automatically captures a screenshot whenever a test fails.
This helps quickly identify what went wrong — for example, missing elements, navigation errors, or unexpected page behavior.

Future plan: I’ll continue adding more functional tests, such as verifying navigation menus and other social icons, to expand coverage and make this a complete UI regression suite.