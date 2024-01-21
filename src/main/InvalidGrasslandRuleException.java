package main;

public class InvalidGrasslandRuleException extends Exception {
   public InvalidGrasslandRuleException(String message) {
       super(message);
   }

   public InvalidGrasslandRuleException() {
        super();
   }
}