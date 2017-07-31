# conwaysGameOfLife
Interactive web application solving a classic puzzle

--Instructions on how to build, test, run--
This Maven dynamic web page project was built in the Eclipse IDE. I would recommend running it through an IDE.

    Build & Run
    In order to do this you will need to import the project into your IDE as an existing Maven project. The current runtime environment is Apache Tomcat 8.5. You may need to change this to the server you will be running it out of. In Eclipse this is under project Properties > Project Facets > Runtimes then select your server and deselect the current server. Once this is complete you will need to run the project on the server and the web page will load. 
    Test
    In order to run the unit tests out of your Java IDE, simply run the project as JUnit Test.

    Additional Features
        -Offers a two page web layout that is easily navigable
        -Program allows for arbitrarily sized grids
        -Cell state is randomly generated and the user capable of changing the probability
        -Exercise problem logic solved in both Java and Javascript
        -Capable of iterating through generations with the click of a button
        -Animation counts generations and user is able to pause and start animation with button click
        -User is able to click on cells and toggle their state both during and outside of animation with a proper response
        -Results display is streamlined and attractive
