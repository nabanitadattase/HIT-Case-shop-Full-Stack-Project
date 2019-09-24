# HIT-Case-shop-Full-Stack-Project

HIT Case shop (JSP,Servlet,MVC,Java7,Java DB, Restful Webservice)Full Stack Project:

About:

The goal of the project is to create a backend application  for a web shop that sells mobile shells to several different brands and models.

The requirements are:

•	A simple web shop GUI where user can select, search and add shells.
•	Display List of available Model Shells available in the shop

•	Display Shell brand, manufacturer, color details according to the searched model number.
•	It should include functionality to add phones and information about the manufacturer, model and other necessary information that may be of interest.
•	To retrieve and save information, use web services.

WorkFlow: 

- Create database connection, 
- Run the sql dump to insert data in the table. 
- Build java web application - MobileShell to create RESTful webservice, 
- Use NetBeans IDE to create entity classes and RESTful Web Services in the same process.
- Entity Package is com.shellentity. Entity Class is Shell.java.
- Number of entity classes depends on the number of tables in the database.
- ShellFacadeREST.java is the restful webservice class for shell entity (basically this is the REST front end of our application).

index.jsp is used for display purpose through which JSP can call servlet, webservice and can get the response which will display in this JSP page. 
Three java files in controller package are used for servlet. Two java files in mobileShellClient package which is used to implement retrieve and save information using webservice call.

Technologies & Tools used during development:

Front-end: HTML,JavaScript, JSP

Tool: Netbeans IDE 7.2.1, webservice testing tool - postman/Test restful webservices via Netbeans

Database: SQL database ('Java DB' database server)

Application Server: GlassFish server 3.1.2

Back-end: Built with using servlet follwed MVC model structure, Java7, Restful webservice formed using 'Java DB'

Browser: Mozila fire-fox, Google chrome

Operating System: Window 7
