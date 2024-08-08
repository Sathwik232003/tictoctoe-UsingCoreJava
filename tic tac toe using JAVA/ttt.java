import java.util.Scanner;

class ttt {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("<====TIC TOC TOE GAME PLAY===>\n");

        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        boolean gameOver = false;
        char player = 'X';
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name of Player A : ");
        String playerA = scanner.nextLine();
        System.out.print("\nEnter Name of Player B : ");
        String playerB = scanner.nextLine();

        System.out.println("\n** " + playerA.toUpperCase() + ", PLEASE START THE GAME(WITH YOUR SYMBOL 'X') **");

        while (!gameOver) {
            printBoard(board);
            if (player == 'X') {
                System.out.print(playerA.substring(0, 1).toUpperCase() + playerA.substring(1) + "'s, turn : ");
            } else {
                System.out.print(playerB.substring(0, 1).toUpperCase() + playerB.substring(1) + "'s, turn : ");
            }

            int row = scanner.nextInt();
            int col = scanner.nextInt();
            // System.out.println();

            if (board[row][col] == ' ') {
                board[row][col] = player; // place the element
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println();
                    if (player == 'X') {
                        System.out.println(playerA.toUpperCase() + " Won the Game..!!!");
                    } else {
                        System.out.println(playerB.toUpperCase() + " Won the Game..!!!");
                    }
                } else if (isBoardFull(board)) {
                    System.out.println("The game is a draw!!!");
                    System.out.println("====RESTART THE GAME====\n");
                    reasign(board);
                }
                // Shifting Players//
                else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again!");
            }
        }

        printBoard(board);

    }

    public static boolean haveWon(char[][] board, char player) {
        // check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // check for col
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            System.out.println("----+---+----");
            System.out.print("| ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
        System.out.println("----+---+----\n");
    }

    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void reasign(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
    }
}
