import java.util.Scanner;

public class Game {

    public static final String SPACE_TAKEN_MSG = "\nThe space is already " +
            "taken.\n\nTry again : ";

    private static char[][] board = new char[3][3];
    private static final char player1 = 'X';
    private static final char player2 = 'O';

    public static void main(String[] args) {
        initializeBoard();
        while (true) {
            printBoard();
            playerTurn();
        }
    }

    public static void initializeBoard() {
        int row;
        int column;

        for (row = 0; row < 3; row++) {
            for (column = 0; column < 3; column++) {
                board[row][column] = ' ';
            }
        }
    }

    public static void printBoard() {
        System.out.printf("\n==============\n" +
                "| %c | %c | %c |\n" +
                "--------------\n" +
                "| %c | %c | %c |\n" +
                "--------------\n" +
                "| %c | %c | %c |\n" +
                "==============\n"
                ,board[0][0], board[0][1], board[0][2],
                board[1][0], board[1][1], board[1][2],
                board[2][0], board[2][1], board[2][2]);
    }

    public static void placePiece(char player, int row, int column) {
        if (spaceIsFree(row, column)) {
            board[row][column] = player;
        }
    }

    private static boolean spaceIsFree(int row, int column) {
        return board[row][column] == ' ';
    }

    public static void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        UserChoice choice;
        int row;
        int column;
        boolean placed = false;

        System.out.print("Your turn : ");

        while (!placed) {
            try {
                choice = new UserChoice(scanner.nextLine());

                if (choice != null) {

                    row = choice.getRow();
                    column = choice.getColumn();

                    if (spaceIsFree(row, column)) {
                        placePiece(player1, row, column);
                        placed = true;
                    } else {
                        System.out.print(SPACE_TAKEN_MSG);
                    }
                }
            } catch (ChoiceNotValidException e) {
                System.out.println(e.getMessage());
            }

        }
    }


}