# Java Sudoku Game

A simple desktop-based **Sudoku puzzle game** implemented using Java Swing. It provides a 9x9 Sudoku board with a partially filled puzzle. Users can select numbers and attempt to solve the puzzle. The app keeps track of incorrect inputs and provides visual feedback.

---

## 📖 Introduction

This project is a **graphical Sudoku game** developed in Java using the **Swing** framework. It demonstrates basic GUI development principles including event handling, layout management, and custom UI component creation.

---

## ✨ Features

- Interactive 9x9 Sudoku grid
- Pre-loaded puzzle and solution
- User input through a set of number buttons (0–9)
- Error counter with real-time display
- Visual highlighting of selected numbers
- Colored tiles and borders for better UI clarity
- Lightweight and easy to run locally

---

## 💾 Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IDE or terminal with Java compilation capability

### Steps

1. Clone the repository or download the source code:
   ```bash
   git clone https://github.com/your-username/java-sudoku.git
   ```

2. Navigate to the project folder:
   ```bash
   cd java-sudoku
   ```

3. Compile the Java file:
   ```bash
   javac Sudoku.java
   ```

4. Run the program:
   ```bash
   java Sudoku
   ```

---

## 🚀 Usage

1. Launch the program. A 9x9 Sudoku grid will appear.
2. The grid contains pre-filled numbers (gray tiles) and empty spaces (white tiles).
3. Select a number (0–9) from the bottom number bar.
4. Click on an empty tile to fill in the selected number.
5. If the number is correct, it will appear in the tile.
6. If incorrect, the error counter will increment.

---

## 🧱 Project Structure

```
Sudoku.java         // Main game logic and GUI code
```

**Classes and Components:**

- `Sudoku`: Main class and entry point
- `Tile`: Inner class extending `JButton`, representing each cell on the board
- `JFrame`: Top-level container
- `JPanel`: Layout containers for board, number buttons, and status text
- `JLabel`: Displays the error counter

---

## ⚙️ Configuration

There is no external configuration file. However, you can modify the following directly in the source code:

- **Puzzle & Solution:**
  Change the `puzzle` and `solution` arrays to load a different Sudoku challenge.
- **Board Size:**
  Modify `boardWidth` and `boardHeight` to resize the game window.

---

## 📦 Dependencies

This project uses **standard Java libraries** only:

- `javax.swing.*`
- `java.awt.*`
- `java.awt.event.*`

No third-party dependencies required.

---

## 🧪 Examples

![Sudoku GUI Screenshot](screenshot.png)

- **Gray tiles**: Pre-filled, not editable
- **White tiles**: Editable
- **Bottom panel**: Clickable number buttons (0-9)
- **Error Counter**: Shown at the top center

---

## 🛠️ Troubleshooting

| Issue                         | Solution                                           |
|------------------------------|----------------------------------------------------|
| Window does not open         | Ensure `main` method is present and correct       |
| Compilation error            | Check if JDK is installed and environment is set  |
| UI elements misaligned       | Make sure you did not modify layout setup         |
| Error count doesn't update   | Ensure number button is selected before clicking  |

---

## ✅ To Do / Future Improvements

- Add difficulty selection (Easy/Medium/Hard)
- Add timer and scoring system
- Allow loading puzzles from files
- Add option to check for mistakes without penalty
- Include a “Reset” or “Hint” button

---

## 🔮 Future Updates

**Sudoku 2.0** is currently in planning and development stages! Here’s what you can look forward to:

- 🧠 **Random Puzzle Generation**: The next version will be able to dynamically generate unique Sudoku puzzles at runtime, offering endless gameplay without hardcoding puzzle arrays.
- 🎚️ **Difficulty Levels**: Easy, Medium, and Hard puzzles will be generated with appropriate logic and constraints.
- 💾 **Save and Load Games**: Players will be able to save their progress and continue later.
- 📈 **Game Statistics**: Track your solve times, accuracy, and error count history.
- 🔁 **Hint System**: Get hints for individual cells without revealing the entire solution.
- 🧪 **Unit Testing & Modular Code**: Future-proofing the codebase with better testing and modular design.

Stay tuned for more updates as Sudoku 2.0 evolves!

---

