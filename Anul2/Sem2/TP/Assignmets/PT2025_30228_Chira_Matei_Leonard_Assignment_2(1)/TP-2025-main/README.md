# Installation 

## Prerequisites

Would be great if you have them set in your PATH variable

* Java >= 21
* Maven >= 3.9

## Steps

* clone the repository or download the repository

        git clone https://github.com/SamyBP/TP-2025.git
* build the application
    * from command line, using mvn and java (if set in the PATH variable)
  
            mvn clean package
    * from Intellij, just run the main file

* configuring mvn and java (optional if you prefer not running from IDE) (windows only)
  * add java to the user variables
  * open System Environment Variables and under user variables set:
            
              JAVA_HOME=*path_to_your_java_jdk*
  
  * add mvn to the PATH variable
  * expand PATH from the system environment variables and append the path to your maven directory, something simialr to this:
  
            C:\Users\.m2\wrapper\dists\apache-maven-3.9.7-bin\3k9n615lchs6mp84v355m633uo\apache-maven-3.9.7         
  * in order for changes to take effect, you must refresh your pc  

# Queue Simulation - Usage Guide

## Examples

### Basic Usage
```bash
run.app.bat
```
Runs the simulation with the GUI.

# Logs

Each run will have it's own log in a file named by the following rule:

        *STRATEGY*/T*SIMULATION_TIME*_C*CLIENT_COUNT*_Q*QUEUE_COUNT*_A*ARRIVAL_INTERVAL*_S*SERVICE_INTERVAL*_*UNIX_TIMESTAMP*.log

**Note** the values between '*' are just placeholder for the actual values the simulation was ran with