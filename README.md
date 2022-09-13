## 🐍🐍Snake and Ladders Game using JavaFX🪜🪜
This is a Snake and Ladders Game made using JavaFX. It can be played between two individuals and the first one to reach the 100th square wins.
The game is made using the concepts of **Object Oriented Progamming**, **Multithreading** and **GUI**.

### How to Deploy the Game ###
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
