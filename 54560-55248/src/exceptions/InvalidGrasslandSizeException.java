package exceptions;
public class InvalidGrasslandSizeException extends InvalidGrasslandException {
    public InvalidGrasslandSizeException(String message) {
        super(message);
    }

    public InvalidGrasslandSizeException() {
        super();
    }

}
