# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

# What's up Bulbie squad

This is the basic skeleton of a Java backend that uses the Spring Framework.  What is the Spring Framework? You can read about
it all online, but ( https://www.tutorialspoint.com/spring/spring_quick_guide.htm ) is a pretty good quick starty guide. 
We want to use Spring because it makes developing Java applications easier, let's you really easily utilize helpful dependencies,
and has a really  nice Web development module.  

# How to run the development server / project structure

SchedulsaurBackendApplication.java is the entry point for spring. To start the application, right click on that file and select
"Run as Java Project".  Once the application is running, HTTP requests are handled via exposing REST endpoints in UserController.java.  

What are REST endpoints?  Check out this guide: (http://www.drdobbs.com/web-development/restful-web-services-a-tutorial/240169069 ), or if you are a visual learner ( https://www.youtube.com/watch?v=SLwpqD8n3d0 ) for a better explanation than I could possibly give.

The default for a Spring application is http://localhost:8080 (our frontend is on :3000).  In UserController, you can see I have exposed two endpoints, a GET and POST which for now return dummy data.  I didn't want to mess with the file structure of the backend much, but ultimately all of the files from logic can be put into our spring application for easy access.

So far I have support for HTTP requests for the dashboard buttons on the frontend, more will be coming.  Take a look at the code in the frontend, run it alongside the spring application, execute a POST or GET, and check the console in chrome or eclipse to see the response.  Or, simply run the spring application and visit http://localhost:8080/hello in your browser to see resposne JSON immediately (the url bar is just a GET request).

# Also
I decided to use Maven for our dependency management, this is a maven project :)