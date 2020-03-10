# LCD Screen Simulator

## What you need
* Java (tested with java **1.8**)
* Maven (tested with maven **3.6.2**)

## Compilation in your own device
In your terminal, go to the project main directory and enter the following command
``mvn clean compile assembly:single``

## Using the program 
To execute the program, use the following command 
``java -jar target/lcd_screen-0.0.1-SNAPSHOT-jar-with-dependencies.jar 123``

## Parameters accepted
* You have to give one parameter to the program. 
* The parameter have to be a number 
* Otherwise an error is returned to the user terminal

## Tests
A few simple small tests are given, you can launch them by entering the following command
``mvn test``

100% of the simulator class is covered by these simple tests
![header of the Junit covering array](./screenshot1.png)
![content of the Junit convering array](./screenshot2.png)
