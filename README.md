# SIMPLE EXCEPTION HANDLER GAME

This project is a small game application that generates random exceptions which the player must correctly identify.

When an error appears, the player can click on it and choose the correct exception type from three possible options.  
Selecting the correct answer increases the score, while a wrong choice ends the game and resets the score.

The project demonstrates the use of the Builder Design Pattern to dynamically generate different types of errors.

# STRUCTURE 

**mainFile** - it's the start engine for the game.
**Prima_interfata** - initial GUI screen where the game starts.
**Game** - Main gameplay interface.
**Vector2Int** - it's an utility class representing 2D coordinates (position and size).
**Enemy** - this class is designed to initialize the Enemy (the error) using the Vector2Int class and other characteristics; 
also it contains a function that helps to identify the position of the mouse and 2 functions for setting and getting the corect exceptions.
**EnemyBuilder** - this is the creation of the Enemy and the demonstration of the particularity of Builder Design Pattern that says that we don't have a need for a lot of constructors to create an object;
also it provides with a special function that will generate the exception type random.
**EnemyDirector** - it's the builder for an object of type Enemy that would help us to identify on the game.
**EnemyPanel** - this class provides the generation time of the enemy, the design of it, where the enemy will be placed (random place) on the interface and the score panel.
**ExceptionHandler** - it makes a verification for every selected Exception. 
**ExceptionSelector** - Dialog windows that has the role to let the user (when he clicks on the enemy) to choose which Exception thinks is correct.

# CONCEPTS USED

- Object-Oriented Programming (OOP)
- Builder Design Pattern
- GUI development
- Inheritance
- Polymorphism
- Exception Handling

# What have I learned ? 

! How the concept of Builder Design Pattern works.
! How to structure a multi-class GUI application.


