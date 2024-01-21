package exceptions;

public class InvalidGrasslandRuleException extends InvalidGrasslandException {
   public InvalidGrasslandRuleException(String message) {
       super(message);
   }

   public InvalidGrasslandRuleException() {
        super();
   }
}