package exceptions;

public class InvalidGrasslandPercentagesException extends InvalidGrasslandException {
    public InvalidGrasslandPercentagesException(String message) {
        super(message);
    }

    public InvalidGrasslandPercentagesException() {
        super();
    }
}
