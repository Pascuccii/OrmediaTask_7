package pascuccii.exceptions;

public class AnotherException1 extends MyException {
    @Override
    public void printStackTrace() {
        System.out.println("exception 1");
    }
}
