package pascuccii.exceptions;

public class AnotherException2 extends MyException {
    @Override
    public void printStackTrace() {
        System.out.println("exception 2");
    }
}
