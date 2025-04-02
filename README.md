# ReMind

***

## Introduction

ReMind is a Java application
designed to manage and organize elements with different types such as text and phone elements.
The application uses a factory pattern for element creation and JSON handling for data processing.

## Requirements
***

To run the application, you need to have:
* Java JDK (11 or higher)
* Google's json-simple-1.1.1.jar library (included in the project)

## How to use the application
***

To launch the application, you need to run the `ApplicationRunner` class.

* Navigate to the project directory in your terminal
* Compile the project using your preferred method (IDE or command line)
* Execute the `ApplicationRunner` class located in the `fr.ynov.remind.main` package
* If you encounter any errors while running the project, ensure all dependencies are properly set up

## Features
***

### Main Page

The main page serves as the entry point to the application, providing access to all core functionalities:
* Create and delete elements (text and phone)
* View all elements in a structured format (with their respective tags and associated data)

### Element Management

The application allows you to:
* Create different types of elements using the ElementsFactory (text or phone elements)
* Assign tags to elements for categorization (e.g. "Urgent", "ToBeTreated", "Priority")

## Project Structure
***
The project is structured as follows:

```
/ReMind
│/src                                           # Source code
│   ├/main                                      # Main source folder
│   │   ├/java                                  # Java source files
│   │   │   ├/fr.ynov.remind                    # Main package
│   │   │   │   ├/domain                        # Domain objects
│   │   │   │   │   ├── Element.java            # Base element class
│   │   │   │   │   ├── PhoneElement.java       # Phone-specific element
│   │   │   │   │   ├── Tags.java               # Tags management
│   │   │   │   │   ├── TextElement.java        # Text-specific element
│   │   │   │   ├/factory                       # Factory pattern implementation
│   │   │   │   │   ├── ElementsFactory.java    # Factory for element management
│   │   │   │   │   ├── JsonHandler.java        # JSON data processing
│   │   │   │   ├/gui                           # User interface
│   │   │   │   │   ├── ElementPage.java        # Element creation page detail view
│   │   │   │   │   ├── MainPage.java           # Main page view
│   │   │   │   ├/main                          # Application entry point
│   │   │   │   │   ├── ApplicationRunner.java  # Main runner class
│   │   │   │   ├/lib       # Libraries
│   │   │   │   │   ├── json-simple-1.1.1.jar   # JSON library
│/resources                                     # Application resources
│   ├── elements.txt                            # Elements data storage
│README.md                                      # Project documentation
```

Key Components:

* **domain/** → Contains the core data models:
    * `Element.java`: Base class for all elements
    * `PhoneElement.java`: Specialized element for phone data
    * `TextElement.java`: Specialized element for text data
    * `Tags.java`: Tag management functionality
* **factory/** → Implements the factory pattern:
    * `ElementsFactory.java`: Creates different types of elements
    * `JsonHandler.java`: Handles JSON serialization/deserialization
* **gui/** → User interface components:
    * `MainPage.java`: Main page interface
    * `ElementPage.java`: Element creation interface
* **main/** → Application entry point:
    * `ApplicationRunner.java`: Main class to start the application

## About the project
***

### Versions

* 1.0 - Initial Release (02/04/2025)

### Technologies / Languages Used
<img src="https://skillicons.dev/icons?i=java" alt="Java logo"><br>
Java 23

### Authors

* Noah CHARRIN--BOURRAT ([@CharrBourrAh](https://github.com/CharrBourrAh))

### Useful Links

* GitHub Repository: [Project Link](https://github.com/CharrBourrAh/ReMind)