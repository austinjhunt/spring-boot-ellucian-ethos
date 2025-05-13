# Spring Boot - Ellucian Ethos

This is a Java Spring Boot application that leverages the [Ellucian Ethos Integration Java SDK](https://github.com/ellucian-developer/integration-sdk-java) to read and eventually write data from and to Banner via Ethos Integration.

# Set up a development environment

1. [Install Java SE version 23](https://www.oracle.com/java/technologies/downloads/)
2. [Install Gradle 7.5+](https://gradle.org/install/)
3. Clone this repo
4. Open the repo in an IDE of your choice. If using VSCode, [install Visual Studio Code Coding Pack for Java](https://code.visualstudio.com/docs/languages/java#_install-visual-studio-code-for-java)
5. Set an environment variable `ETHOS_API_KEY` for your system using a valid API Key from [Ethos Integration Hub](https://integrate.elluciancloud.com)
6. Run the project with `./gradlew bootRun`
7. Make a request either with `curl` or in your browser against `http://localhost:8080`, then `http://localhost:8080/courses`. The first is a basic test, the second is a test of reading data out of Ethos.
8. Monitor logs for any errors and if there are any, resolve them as directed.

# Relevant resources

1. [CofC Web Forms on Page Builder in SSB Test](https://ssb.test.cofc.edu/BannerExtensibility/customPage/page/WebForms?form_id=21)
