package api.exeptions;

public class TransactionAlreadyProcessedException extends RuntimeException{
    public TransactionAlreadyProcessedException(String message) {
        super(message);
    }
}
