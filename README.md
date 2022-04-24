# MazeStack

This taks have as a main goal to go through a maze that is givin by a .txt file, where the computer needs to find the open spaces until the way out. 
The entrance of the maze is given by the letter "E" and the exit as the letter "S" (the open space is a blank space in the .txt file line " ").

Example of a Maze:
![image](https://user-images.githubusercontent.com/86858785/165000443-bfbbe609-5928-4023-b2a8-9af0c9edd73a.png)

The way the computer goes through the maze is "simples". It first identify it as a array, and goes by position (like: (1,1) and (1,2), considering line and columns).
When the computer finds the entrance "E", it start searching for open spaces considering the following order: Up, Right, Down, Left.
If the computer find a place where it gets blocked, it will go back one position, condider that space as "blocked", and tries to find another path to go.

![Blocked](https://user-images.githubusercontent.com/86858785/165000749-ed347ffb-c86d-4046-b4f9-997e7cc07e26.png)

This repository have some maze examples ("CustomMaze.txt" - out/production/Maze/CustomMaze.txt), 
                                        ("ExercicieMaze.txt" - out/production/Maze/ExercicieMaze.txt), 
                                        ("SimpleMaze.txt" - out/production/Maze/SimpleMaze.txt);

To run it, you just need to specify the path for the .txt of your maze in the variable "path" in Main class

![paths](https://user-images.githubusercontent.com/86858785/165000970-9f1a889b-9cf6-4c22-8a04-cdeac7997461.png)

The positions are stored in a stack and if everything runs as expected (computer finding the "S"), 
the program will print out the stack with all the positions it had to go through to solve tha maze.

By the end you shold have somethig like this:

![image](https://user-images.githubusercontent.com/86858785/165001013-94de661d-dc05-471c-ab80-66e6313d1b86.png)

We can see the "direction" that the computer is going, as well as the position it is in and if it found the exit "S" or not.
