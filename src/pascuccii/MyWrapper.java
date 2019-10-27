package pascuccii;

import pascuccii.exceptions.MyException;

public class MyWrapper {
    private MyClass myClass;

    public MyWrapper(MyClass myClass) {
        this.myClass = myClass;
    }

    public void invoke(int method) {
        boolean was = false;
        if (method == 1) {
            try {
                myClass.firstMethod();
            } catch (MyException e) {
                was = true;
                e.printStackTrace();
            } finally {
                if (!was)
                    System.out.println("no exceptions");
                System.out.println("hello");
            }
        }
        if (method == 2)
            myClass.secondMethod();
    }

    public void set(Object ob) {
        if (ob instanceof String)
            myClass.setName((String) ob);
        else if (ob instanceof Integer)
            myClass.setIntValue((Integer) ob);
        else throw new RuntimeException();
    }
}
