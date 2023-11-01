public class NegativeBalanceException extends Exception {
    public NegativeBalanceException() {
        super("Negative Balance");
    }

    public NegativeBalanceException(String msg) {
        super(msg);
    }

}
