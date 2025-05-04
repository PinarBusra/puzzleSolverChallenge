# Puzzle Solver

This project is a backtracking-based puzzle solver implemented in Java.

Given:
- a board of integers,
- a list of visual puzzle pieces (e.g., `"XX", "X.,.X"`),
- and a target depth value,

The goal is to place all the pieces (in order) on the board in such a way that **every cell on the board becomes 0**, using modulo arithmetic for wrapping.

---

## 🧠 Logic Overview

- Each `X` in a piece increases the corresponding board cell by 1 (modulo depth).
- Each `.` leaves the board cell unchanged.
- Pieces must be placed **in the given order**.
- The algorithm uses **depth-first backtracking** to explore possible placements.

---

## 📥 Input Format

The input is read from `data/input.txt` in the following format:

### Example:

      2 
      100,101,011
      ..X,XXX,X.. X,X,X .X,XX XX.,.X.,.XX XX,X. XX .XX,XX.


## 📤 Output Format
Results are written to data/output.txt.

### Example:
- If a solution is found:

      0,0 0,0 1,0 0,0 0,0 0,2 0,1

- If not:

      No solution
## ▶️ How to Run
Assuming you are using Maven:

    mvn compile <br>
    java -cp target/classes com.example.puzzleSolver.PuzzleSolverApplication

### 💡 Run in IntelliJ IDEA
You can also run the application directly in IntelliJ IDEA without using the terminal:

- Steps: <br>
   - Open the project in IntelliJ IDEA.
   - Navigate to: src/main/java/com/example/puzzleSolver/PuzzleSolverApplication.java
   - Open PuzzleSolverApplication.java and locate the main method:
   - Click the green ▶️ run icon to the left of the method.



## ⚠️ Performance Notes
This solver works reliably for small and medium-sized inputs.
However, for larger boards and complex piece arrangements, it may take a long time due to the nature of recursive backtracking.

I have explored and attempted several optimizations, including:

- Dynamic programming with memoization

- Pruning strategies

- Bitmasking and board hashing

- Constraint solving libraries (e.g., Choco Solver)

- Alternative search strategies like Monte Carlo Tree Search

Despite these efforts, due to the strict constraints (ordered piece placement, modulo logic), no approach consistently outperformed the basic backtracking for all inputs.

**🛠** Although the current implementation meets the requirements, I explored several optimization strategies to go beyond, as explained above.

## ✅ Technologies
   - Java 17
   - Maven
   - lombok


## 📁 Project Structure

project-root/ <br>
├── README.md <br>
├── pom.xml <br>
├── mvnw <br>
├── mvnw.cmd <br>
├── .gitignore <br>
├── .gitattributes <br>
├── data/ <br>
│   ├── input.txt <br>
│   └── output.txt <br>
├── src/ <br>
│   └── main/ <br>
│      └── java/ <br>
│           └── com/ <br>
│               └── example/ <br>
│                   └── puzzleSolver/ <br>
│                       ├── PuzzleSolverApplication.java <br>
│                       ├── io/ <br>
│                       │   ├── InputReader.java <br>
│                       │   └── OutputWriter.java <br>
│                       ├── model/ <br>
│                       │   ├── Piece.java <br>
│                       │   ├── PuzzleRequest.java <br>
│                       │   └── PuzzleResponse.java <br>
│                       └── service/ <br>
│                           └── PuzzleSolverService.java <br>


 ## 👤 Author
Pınar Göl <br>
Software Engineer <br>
Prepared for coding assessment purposes


