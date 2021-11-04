package exceptions;

public class NegativeNumberException extends Exception {
    private static final long serialVersionUID = 6251672623081314676L;
    public NegativeNumberException() {

    }

    public NegativeNumberException(String s) {
        super(s);
    }
}
