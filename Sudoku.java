import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sudoku { // public class and so must have the same name as java file
    
    class Tile extends JButton { // tile inherits all the properties of the JButton class
        int r; // Row index of the tile
        int c; // Column index of the tile

        Tile(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    int boardWidth = 600; // Set the width of the Sudoku board window
    int boardHeight = 650; // Set the height of the Sudoku board window

    // double for loop iterates through each string, then through each character and makes a button for each character
    String[] puzzle = {
        "--74916-5",
        "2---6-3-9",
        "-----7-1-",
        "-586----4",
        "--3----9-",
        "--62--187",
        "9-4-7---2",
        "67-83----",
        "81--45---"
    };

    String[] solution = {
        "387491625",
        "241568379",
        "569327418",
        "758619234",
        "123784596",
        "496253187",
        "934176852",
        "675832941",
        "812945763"
    };

    JFrame frame = new JFrame("Sudoku"); // JFrame is a built-in class in Swing library that opens a new window with a title
    JLabel textLabel = new JLabel(); // Label to show text (e.g., error count)
    JPanel textPanel = new JPanel(); // Panel to hold the label
    JPanel boardPanel = new JPanel(); // Panel to hold the Sudoku grid
    JPanel buttonsPanel = new JPanel(); // Panel to hold the number buttons (0-9)
    JButton numSelected = null; // Button for the selected number
    int errors = 0; // Counter for errors made by the user

    Sudoku () {
        //frame.setVisible(true); // Method apart of the JFrame class to make window visible (not minimized)
        frame.setSize(boardWidth,boardHeight); // Method apart of the JFrame class to fix the size of the window to set # of pixels
        frame.setResizable(false); // Prevent resizing of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when window is closed
        frame.setLocationRelativeTo(null); // Centers the window to the screen
        frame.setLayout(new BorderLayout()); // Splits the panel into NESW at the edges, and center is the space in between

        textLabel.setFont(new Font("Arial", Font.BOLD,30)); // Set font for the text label
        textLabel.setHorizontalAlignment(JLabel.CENTER); // Align text to the center
        textLabel.setText("Sudoku: 0"); // Display initial error count

        textPanel.add(textLabel); // Add the label to the text panel
        frame.add(textPanel, BorderLayout.NORTH); // Ensure textPanel is placed on the north side of the window

        boardPanel.setLayout(new GridLayout(9,9)); // Splits panel into a 9x9 grid
        setUpTiles(); // Sets up the tiles on the board
        frame.add(boardPanel, BorderLayout.CENTER); // Adds the boardPanel to the center of the window
        
        buttonsPanel.setLayout(new GridLayout(1,9)); // Splits panel into a 1x9 grid for number buttons
        setUpButtons(); // Sets up the number buttons
        frame.add(buttonsPanel, BorderLayout.SOUTH); // Adds the buttonsPanel to the south side of the window

        frame.setVisible(true); // Wait until all components are added before making the frame visible
    }

    void setUpTiles() {
        for(int r = 0; r < 9; r++) { // Iterate through rows
            for(int c = 0; c < 9; c++) { // Iterate through columns
                Tile tile = new Tile(r,c); // Passing in row and column parameters into new instance of the Tile class
                char tileChar = puzzle[r].charAt(c); // Makes a new character by taking row of string and extracting the character at each column
                if(tileChar != '-') { // If the tile is not empty
                    tile.setFont(new Font("Arial", Font.BOLD, 20)); // Set font for filled tiles
                    tile.setText(String.valueOf(tileChar)); // Set the tile's text to the puzzle character
                    tile.setBackground(Color.lightGray); // Set the background to light gray
                }
                else { // If the tile is empty
                    tile.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font for empty tiles
                    tile.setBackground(Color.white); // Set the background to white
                }
                
                // Border styling based on tile position (for visual clarity)
                if((r == 2 && c == 2) || (r == 2 && c == 5) || (r == 5 && c == 2) || (r == 5 && c == 5))
                    tile.setBorder(BorderFactory.createMatteBorder(1,1,5,5,Color.black));
                else if(r == 2 || r == 5) {
                    tile.setBorder(BorderFactory.createMatteBorder(1,1,5,1,Color.black));
                } else if (c == 2 || c == 5) {
                    tile.setBorder(BorderFactory.createMatteBorder(1,1,1,5,Color.black));
                } else {
                    tile.setBorder(BorderFactory.createLineBorder(Color.black));
                }

                tile.setFocusable(false); // Removes small black box around each character
                boardPanel.add(tile); // Adds the tile to the board

                // Action listener for each tile when clicked
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Tile tile = (Tile) e.getSource(); // Get the Tile object that triggered the event
                        int r = tile.r; // Row of the clicked tile
                        int c = tile.c; // Column of the clicked tile

                        if(numSelected != null) {
                            if (!tile.getText().equals("")) { // Don't let the user click on a tile that's already filled
                                return;
                            }

                            String numSelectedText = numSelected.getText(); // Get the text of the selected number button
                            String tileSolution = String.valueOf(solution[r].charAt(c)); // Correct solution for the current tile

                            if (tileSolution.equals(numSelectedText)) { // Correct string comparison
                                tile.setText(numSelectedText); // Set the tile to the selected number
                            } else {
                                errors += 1; // Increment errors if the solution is wrong
                                textLabel.setText("Sudoku: " + String.valueOf(errors)); // Update error count
                            }
                        }
                    }
                }); // End of actionPerformed method
            } // End of column loop
        } // End of row loop
    }

    void setUpButtons() {
        for(int i = 0; i < 10; i++) { // Loop through numbers 0-9
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.BOLD, 20)); // Set font for the number buttons
            button.setText(String.valueOf(i)); // Set text to the number
            button.setFocusable(false); // Remove the focus box from around the button
            button.setBackground(Color.white); // Set background color to white
            buttonsPanel.add(button); // Add the button to the buttonsPanel

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    if(numSelected != null)
                        numSelected.setBackground(Color.white);
                    numSelected = button;
                    numSelected.setBackground(Color.lightGray);

                }
            });

        } // End of loop for creating number buttons
    }

    public static void main(String[] args) {
        new Sudoku(); // Create a new instance of the Sudoku game
    }
}
