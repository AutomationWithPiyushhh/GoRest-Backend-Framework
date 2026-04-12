
# 🚀 GoRest API - Enterprise Backend Automation Framework

A high-performance, **Industrial-Grade API Automation Framework** engineered for comprehensive microservices validation. Built using RestAssured, TestNG, and Maven, this project demonstrates advanced backend testing concepts including POJO-based serialization, OAuth2 handling, Data-Driven execution, and stateful request chaining.

-----

## 🏗️ Project Architecture

The framework follows a modular "Separation of Concerns" design pattern to ensure maximum maintainability and scalability:

```text
GoRest-Backend-Framework
├── 📂 src/main/java
│   ├── 📦 endpoints         # API Routes and HTTP Method Abstractions (Given/When/Then)
│   ├── 📦 payloads          # POJO Classes using Lombok for seamless JSON mapping
│   └── 📦 utilities         # Excel Data Providers, Properties handling, and Reporting logic
├── 📂 src/test/java
│   └── 📦 tests             # Sequential E2E and Data-Driven test scripts
├── 📂 src/test/resources    # External Test Data (.xlsx), Schemas, and Environment Configs
└── 📄 pom.xml               # Maven Dependency and Build Lifecycle management
```

-----

## 🛠️ Tech Stack & Key Components

| Component | Technology | Role |
| :--- | :--- | :--- |
| **Language** | Java | Core framework implementation. |
| **API Library** | REST Assured | BDD-styled HTTP request execution and validation. |
| **Test Engine** | TestNG | Test orchestration, assertions, and dependency management. |
| **Data Binding** | Jackson & Lombok | Zero-boilerplate Serialization/Deserialization of JSON payloads. |
| **Reporting** | Extent Reports | Automated interactive HTML reports with embedded stack traces. |
| **Data-Driven** | Apache POI | Reading complex, multi-row test data from Excel workbooks. |
| **Build Tool** | Maven | Build automation and Jenkins CI/CD integration. |

-----

## 🌟 Framework Features & SDET Highlights

  * ✅ **Stateful Request Chaining:** Implemented dynamic variable extraction (e.g., extracting a generated User ID from a `POST` response) to drive subsequent `GET`, `PUT`, and `DELETE` requests for true End-to-End validation.
  * ✅ **Contract Testing Integration:** Utilized `JsonSchemaValidator` to ensure the API response structure strictly matches predefined technical specifications, catching silent backend changes early.
  * ✅ **Dynamic Payload Generation:** Engineered robust data-driven logic to dynamically append timestamps to payload fields (like emails), effectively preventing `422 Unprocessable Entity` database conflicts during bulk execution.
  * ✅ **Environment Isolation:** Abstracted all environment-specific data (OAuth2 Bearer Tokens, Base URLs) into external `.properties` files for secure, cross-environment CI/CD execution.
  * ✅ **Fail-Fast Architecture:** Designed custom utilities with strict exception handling to instantly fail executions if configurations or external data files are missing or malformed.

-----

## 🚀 Quick Start & Execution Guide

### 1\. Prerequisites

  * **Java:** JDK 11 or higher.
  * **Maven:** Installed and configured in System Environment Variables.
  * **API Token:** Generate a free Bearer Token at [GoRest.co.in](https://gorest.co.in/) and place it in `src/test/resources/config.properties`.

### 2\. Setup

```bash
# Clone the repository
git clone https://github.com/AutomationWithPiyushhh/GoRest-Backend-Framework.git

# Navigate to project directory
cd GoRest-Backend-Framework

# Clean the target folder and install dependencies
mvn clean install
```

### 3\. Execution Options

**Run the Entire Test Suite (via TestNG XML):**
*This is the recommended approach as it triggers the Extent Report listeners.*

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

-----

## 📊 Reporting

This framework uses custom TestNG Listeners to generate visually rich, interactive reports automatically after execution.

  * **Location:** `reports/API-Automation-Report-[Timestamp].html`
  * **Features:** Includes environment details, pass/fail ratios, and detailed exception stack traces for failed assertions.

-----

## 👨‍💻 Author

**Piyush Baldaniya**

  * **Role:** QA Automation Engineer
  * **Expertise:** Backend Microservices & UI Automation Architecture
  * **GitHub:** [@AutomationWithPiyushhh](https://www.google.com/search?q=https://github.com/AutomationWithPiyushhh)
