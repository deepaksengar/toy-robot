# toy-robot

[![Build Status](https://travis-ci.org/deepaksengar/toy-robot.svg?branch=master)](https://travis-ci.org/deepaksengar/toy-robot)

The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5x5. Toy robot accepts PLACE, MOVE, LEFT, RIGHT and REPORT command. It must be Placed first, then only it can execute further commands.

Execution Instruction:
---------------------
	Use toy-robot jar to execute this application.
    
    1) java -jar toy-robot.jar
        User will have provide inputs.
    2) java -jar toy-robot.jar /path/txt-file-with-commands
        This will execute all commands from file.
		

Design
------

   1) Model :
  
      Robot :
        This class implements IRobot interface, which provides API to do tasks (execute commands) and get current status of toy robot. This robot will be placed on a surface and will hold position on that surface.

      Status :
        Enum to represent different statues of Robot.

      Coordinate : 
        This class represents coordinates in x-axis and y-axis.

      Direction :
        Holds enum for all 4 Directions.

      Position :
        This class provies Coordinates and Direction of Object.

      Surface :
        This class provides boundary for Robot.

      Tasks package :
        This provides enum of Task which can be currently executed by Robot. Command interface provides API to execute robot tasks. It has multiple task classes which implements Command interface.
 
 
   2) Builder Classes :
    
    Surface Builder :
      This defines boundry for Robot.
      
    RobotBuilder : 
      This provides robot object which is in IDLE status initially and moved to RUNNING status after receiving PLACE command.
      
    Task Builder :
      This provides executable commands to Robot, and ignores wrong commands.
      
    3) Error Utility : 
        This has custom exception classes.
        
        
    4) Executor Class :
      RobotExecutor
        This is entry point for Application.
        
        


      
      
