public class UserChoice {

    public final static String CHOICE_NOT_VALID = "\nYou must enter 2 digits." +
            " The first indicates the row and the second the column on which " +
            "you want to play.\n\nTry again : ";

    private int row;
    private int column;

    public UserChoice(String choice) throws ChoiceNotValidException {
        if (choice == null) {
            throw new NullPointerException();
        }
        if (!isValidChoice(choice)) {
            throw new ChoiceNotValidException(CHOICE_NOT_VALID);
        }

        this.row =  Character.getNumericValue(choice.charAt(0));
        this.column = Character.getNumericValue(choice.charAt(1));
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    private static boolean isValidChoice(String choice) {
        return choice.chars()
                .mapToObj(c -> (char) c)
                .allMatch(UserChoice::isValidDigit)
                || choice.length() == 2;
    }

    private static boolean isValidDigit(char c) {
        return c >= '0' && c <= '2';
    }


}
