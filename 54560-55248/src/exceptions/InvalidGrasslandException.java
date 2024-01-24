package exceptions;

public class InvalidGrasslandException extends Exception {
    public InvalidGrasslandException(String message) {
        super(message);
    }

    public InvalidGrasslandException() {
        super();
    }
}
