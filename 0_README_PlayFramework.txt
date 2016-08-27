#Java + Play + AngularJS Tutorial - CRUD Application

### Installation:

*) Goto https://www.playframework.com/ and click on Download
*) Scroll down in Download page to see "Alternative Downloads"
*) Download a zip file, not the activator. Currently the latest Play zip is "play-2.2.6.zip"
*) Copy the folder at a particular location say .. D:\work\play-2.2.6 and give this as a path in the environmental variables path. 
   Just append "D:\work\play-2.2.6" after the last path in the path value. Don't forget semicolon before appending this.
*) Now open a new cmd prompt and type play. You should see a play logo printed.
*) Goto to the work place where you want to create a project. In my case it is eclipse workspace.
	==> cd D:\work\workspace
*) To create a project do, "play new PlayDemo"
*) Then it will ask whether you want Scala or Java. Select the one you want. 
*) Now goto the project location, cd PlayDemo.
*) Just to check whether the project created is working or not. Do "play"
*) Do "eclipse". It will create project in eclipse. 
   NOTE: Here it is "eclipse" not "eclipsify". "eclipsify" is deprecated.
*) Not goto eclipse to import the project. Eclipse -> Import -> General -> Existing Project into workspace -> Browse for the project -> Done.
*) Finally to run our applciation, go back to the cmd prompt where there previously that is inside PlayDemo project folder and type "run". 
		NOTE: You should be in" play prompt" to run. If you are not in "play prompt" then do "play" which takes you to play prompt.
*) It will show you an URL and type it on the browser to see the result.
		==> URL: localhost:9000

### How does the page actually loaded?
  ==> Goto conf/routes and see what happens when you hit the url.

### Starting to code

*) Goto Application class and in the index() method update the return text .. say "Hello World!"
*) Just refresh your browser. That's the beauty .. you no need to restart the server.

### Adding classes

*) Create a package under app just parallel to controllers package. Call it "models".
*) Create a Student class with id, name, email, age as attributes.
*) Create a StudentController inside controllers package and write CRUD methods. Following are the methods
    *) Create a Student
    *) Delete a Student
    *) Uodating a Student
    *) Reading all the Students.

### Adding UI

 *) We won't be using the default index pages which are under app/views.
 *) Create an index.html inside public folder. This will be our start page. How to route it will be discusses later.
 *) I assume you know angular if try a simple Angular application. There are plenty of resources online.
 *) Create a controller under public/javascripts/. This will have all the functionalites from front-end prespective.
 *) So how deos the server calls happend when we click on create/delete/update/read?
 *) We need to add the url's of the server calls in our route file under conf folder.
 
### Enablind DB
 *) Play provides an in-memory database called H2.
 *) We will use this for our applicaiton.
 *) To enable it we need to make few changes in our conf/application.conf file.
         Uncomment following lines,
          1) db.default.driver=org.h2.Driver
          2) db.default.url="jdbc:h2:mem:play"
          3) ebean.default="models.*"
         Add the following line after ebean.default="models.*",
          4) applyEvolutions.default=true
          
### Ready to run the application
 *) We got all the three modules (View(Angular+html)-Controller(Play+ Java)-Model(H2 DB)) ready.
 *) Now we will run our application. 
 *) NOTE: If you get any DB error then just apply that particular schema to database.
 *) Run the applcaition at localhost:9000