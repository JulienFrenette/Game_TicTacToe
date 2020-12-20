import java.util.Scanner;

public class Game {

    private static char[][] board = new char[3][3];
    private static final char player1 = 'X';
    private static final char player2 = 'O';

    public static void main(String[] args) {
        initializeBoard();
        while (true) {
            printBoard();
            askUserInput();
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
        return row == -1 && column == -1 || board[row][column] == ' ';
    }

    public static int getRow(String choice) {
        return Character.getNumericValue(choice.charAt(0));
    }

    public static int getColumn(String choice) {
        return Character.getNumericValue(choice.charAt(1));
    }

    public static void askUserInput() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        int row = -1;
        int column = -1;

        System.out.print("Your turn : ");

        do {
            choice = scanner.nextLine();

            if (isValidChoice(choice)) {

                row = getRow(choice);
                column = getColumn(choice);

                if (spaceIsFree(row, column)) {
                    placePiece(player1, row, column);
                } else {
                    System.out.print("\nThe space is already taken.\n\n" +
                            "Try again : ");
                }
            } else {
                System.out.print("\nYou must enter 2 digits. The first " +
                        "indicates the row and the second the column on which " +
                        "you want to play.\n\nTry again : ");
            }
        } while (!isValidChoice(choice) || !spaceIsFree(row, column));
    }

    private static boolean isValidChoice(String choice) {
        return choice.chars()
                .mapToObj(c -> (char) c)
                .allMatch(Game::isValidDigit)
                || choice.length() == 2;
    }

    private static boolean isValidDigit(char c) {
        return c >= '0' && c <= '2';
    }
}