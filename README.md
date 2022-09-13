# 🐍🐍Snake and Ladders Game using JavaFX🪜🪜
This is a Snake and Ladders Game made using JavaFX. It can be played between two individuals and the first one to reach the 100th square wins.
The game is made using the concepts of **Object Oriented Progamming**, **Multithreading** and **GUI**.

## The Team 🙂
- Vibhor Agarwal, CS Undergraduate at IIIT Delhi
- Pritish Poswal, CS Undergraduate at IIIT Delhi
## How to Deploy the Game
-First clone this repository
-Setup the JavaFX in the local system.
-Open the project folder in `IntellIj Idea`
-Go to the Project Structure and JavaFX lib folder in the libraries

![image](https://user-images.githubusercontent.com/76804249/189909359-4002db5a-77b4-4573-9e7e-3cb9047397e3.png)

-Now go to `Edit Configuration` under the `Run` tab.
-In the VM Options add the following

```
--module-path
"C:\Program Files\JavaFX\lib"
--add-modules
javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.media,javafx.swing
```

![image](https://user-images.githubusercontent.com/76804249/189909802-6e0f7791-87ca-4ef5-8fff-87ee48d98d0e.png)

- The game can be run from Run Button in Main class in application package

## Demo of the Game
The game has most features that we can expect. It has a custom Snake and Ladders logo in windows taskbar and a custom header title.

### Welcome Menu
The main menu of the game is present below
- We have and Info and Credits screen as well. There is an animation for switching between different buttons.

![image](https://user-images.githubusercontent.com/76804249/189911301-c62a3de6-e4c4-46fa-8484-5b6e7612c190.png)

- We can now start the game from start button

### Main Game Screen
-Here we have a dice animation which simulates the dice roll. This involves multithreading for efficient resource use.

![image](https://user-images.githubusercontent.com/76804249/189912594-d4e43fcf-d6cc-43ef-9ea5-5bea209ad330.png = 300x300)

We have snake bite and ladder climbing animations as well. The ladders are made using co-ordinate geometry lines using slopes.

### Winning Screen

-The game has a winning which shows who has won the game.

![image](https://user-images.githubusercontent.com/76804249/189914274-af5fdd70-8e67-4dc8-b4b2-05899cb76d9b.png)

### UML Diagram of the Game 🧪
The following UML will help to identify the class, class relationships and other implementation details of the code.
[UML Diagram Link](https://drive.google.com/file/d/1gw4pRi-TyierjPJFh6QBQbIWLzZCo5Vs/view?usp=sharing)

![image](https://user-images.githubusercontent.com/76804249/189914639-344dc8ec-4a59-4723-a368-02f7d7d628ac.png)

## To Do ✅
Feel free to fork the repository and customise the game to your liking.
You can also try the items in the below checklist
- Implement the piece color and player name picker.
- Make the piece follow the snakes body while going down.
- Implement music in the game.

