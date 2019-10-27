package pascuccii;

import pascuccii.exceptions.*;

import java.util.Objects;
import java.util.Random;

public class MyClass {
    private int intValue;
    private String name;

    public MyClass() {
    }

    public MyClass(int intValue, String name) {
        this.intValue = intValue;
        this.name = name;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void firstMethod() throws MyException{
        throw (new Random().nextBoolean()) ? new AnotherException1() : new AnotherException2();
    }

    public void secondMethod() throws MyRuntimeExceptionA {
        MyRuntimeExceptionA exp = new MyRuntimeExceptionA();
        if (name == null || intValue <= 0)
            exp = new MyRuntimeExceptionA();
        if (name == null && intValue > 100)
            exp = new MyRuntimeExceptionB();
        if (name == null && (intValue >= 1 && intValue <= 100))
            exp = new MyRuntimeExceptionC();
        if (name != null && (intValue < 1 || intValue > 100))
            exp = new MyRuntimeExceptionD();
        throw exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return intValue == myClass.intValue &&
                Objects.equals(name, myClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intValue, name);
    }
}
