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

## Overview
You can run it from the command line with different arguments, this will not fire up th ui and will not consider any actual time units i.e use it if you 
don't want to wait for the entire duration of the simulation, the application will still be synchronized between it's threads

If no arguments are provided it will fire up the simulation ui, there you will see the "passage of time", the ui updating every one second

## Command Line Arguments

| Argument | Short | Description                                                      | Default |
|----------|-------|------------------------------------------------------------------|---------|
| `--time` | `-t` | Maximum simulation time (in seconds)                             | 60 |
| `--clients` | `-c` | Number of clients to generate                                    | 4 |
| `--queues` | `-q` | Number of service queues                                         | 2 |
| `--arrival-interval` | | Client arrival time interval (min max)                           | 2 30 |
| `--service-interval` | | Client service time interval (min max)                           | 2 4 |
| `--policy` | `-p` | Queue selection strategy (SHORTEST_QUEUE (q), SHORTEST_TIME (t)) | SHORTEST_QUEUE |

## Examples

### Basic Usage
```bash
run.app.bat
```
Runs the simulation with the GUI.

### Custom Configuration
```bash
run.app.bat -t 120 -c 10 -q 3
```
Runs the simulation for 120 seconds with 10 clients and 3 queues.

### Detailed Configuration
```bash
run.app.bat --time 90 --clients 15 --queues 4 --arrival-interval 1 10 --service-interval 3 8 --policy t
```
Runs the simulation for 90 seconds with 15 clients and 4 queues.
- Clients arrive between 1-10 time units
- Service takes between 3-8 time units per client
- Uses the shortest service time strategy for queue selection

# Logs

Each run will have it's own log in a file named by the following rule:

        *STRATEGY*/T*SIMULATION_TIME*_C*CLIENT_COUNT*_Q*QUEUE_COUNT*_A*ARRIVAL_INTERVAL*_S*SERVICE_INTERVAL*_*UNIX_TIMESTAMP*.log

**Note** the values between '*' are just placeholder for the actual values the simulation was ran with