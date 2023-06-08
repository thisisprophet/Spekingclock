# Speaking Clock

## Description
The Speaking Clock project is a Java-based application that converts a 24-hour clock time into words. It provides a REST ful API endpoint to handle user input and convert the time into spoken words. Additionally, it supports recognizing and returning "Midday" and "Midnight" as specific time inputs.

## Build and Deployment

### Prerequisites
- JDK 8 or above
- Maven
- Internet connectivity for dependency downloads

### Installation
1. Clone the repository to your local machine using the following command: git clone <https://github.com/thisisprophet/Spekingclock.git>

2. Navigate to the project's root directory:
cd speaking-clock

### Build
To build the project, run the following Maven command:
mvn clean install

### Usage
1. Run the application using the following Maven command:
mvn spring-boot:run


2. The application will start and listen on the default port (8080) or a specified port.

3. Access the API endpoint using a tool like curl or Postman:
GET http://localhost:8080/convertTime?time=08:34


4. Replace `08:34` with the desired 24-hour time. The response will be the time converted into spoken words.

### Deployment
To deploy the Speaking Clock application to a production or staging environment, follow these steps:

1. Build the project using the Maven command:
mvn clean install


2. Deploy the generated JAR file to your desired deployment environment.

3. Configure the deployment environment with the appropriate runtime environment variables, such as the server port and any required database configurations.

4. Start the deployed application using the appropriate commands for your deployment environment.

### Troubleshooting
If you encounter any issues during the build or deployment process, consider the following:

- Verify that you have the required Java version (JDK 8 or above) installed and properly configured.
- Check your internet connectivity to ensure that Maven can download the required dependencies.
- Review the error messages and stack traces for any specific error details.

thank you :)


