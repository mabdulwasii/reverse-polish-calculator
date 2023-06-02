reverse-polish-notation-calculator

[__TOC__]

## 1. Description

This is a calculator based on reverse polish notation (RPN). for more information
about the calculator notation please [see this wikipedia article](https://en.wikipedia.org/wiki/Reverse_Polish_notation)

The application is developed using springboot version 2.7.3 and java 17. It is a spring mvc application
that uses [thymleaf](https://www.thymeleaf.org/) as its templating engine.

## 2. Environment Models

- The environment model is based on clean architecture
  by [Uncle bob-clean architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- Also, the entry point to the app is through a web interface base on Springboot Thymeleaf.

## 3. Supported Devices

The application support any device capable of running a modern web browser. The app has been tested on all major
browsers
to be working well.

## 4. Running the app

You can run the application in development mode by executing the following command from the app root directory:

```bash
./mvnw 
```

## 5. Test application

You can test the application by running the command below:

```bash
./mvnw test
```

