class Solution {
    public String tictactoe(int[][] moves) {
           // Create a 3x3 grid to represent the Tic-Tac-Toe board
        int[][] grid = new int[3][3];
        int player = 1; // Player A starts with 1, Player B starts with -1
        
        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];
            
            // Mark the current player's move on the grid
            grid[row][col] = player;
            
            // Check if the current player wins after this move
            if (checkWinner(grid, row, col, player)) {
                return player == 1 ? "A" : "B";
            }
            
            // Switch to the other player for the next move
            player *= -1;
        }
        
        // Check if the game is a draw or pending
        if (moves.length == 9) {
            return "Draw"; // All moves are made, and no winner, so it's a draw
        } else {
            return "Pending"; // Game is still ongoing
        }
    }
    
    // Helper function to check if the current player wins after a move
    private boolean checkWinner(int[][] grid, int row, int col, int player) {
        // Check the current row, column, and diagonals for the player's moves
        return (grid[row][0] == player && grid[row][1] == player && grid[row][2] == player) ||
               (grid[0][col] == player && grid[1][col] == player && grid[2][col] == player) ||
               (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) ||
               (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player);
    }
        
    }
