package pascuccii;

/*
1) Создайте собственное исключение MyRuntimeExceptionA,
наследуемое от RuntimeException. Затем MyRuntimeExceptionB
наследуемое от MyRuntimeExceptionA и далее: MyRuntimeExceptionC
наследуемое от MyRuntimeExceptionB. И затем MyRuntimeExceptionD
(соответственно от MyRuntimeExceptionC)

2) Создайте в том же пакете исключение MyException наследуемое от
 Exception и два других исключения AnotherException1 и AnotherException2
 наследуемые от MyException независимо друг от друга.

3) Создайте в том же пакете класс MyClass с полями типа инт
(поле intValue) и String (name).
Пропишите для класса геттеры и сеттеры, иквалс и хешкод.
Напишите в этом классе два метода:
 - public void firstMethod() – вызов этого метода в 50% случаев
 должен порождать одно из исключений: AnotherException1 или AnotherException2
- public void secondMethod() - - если при вызове этого метода
при значении имени (name) null или значение intValue меньше либо
 равно нулю должно бросаться исключение MyRuntimeExceptionA;
 если при вызове этого метода только имя null а intValue>100
 должно бросаться исключение MyRuntimeExceptionB, если же
 name==null&&(intValue в промежутке 1..100) должно бросаться
 исключение MyRuntimeExceptionC. Если же имя не равно null а
 intValue не находится в промежутке 1..100 должно броаться исключение MyRuntimeExceptionD


4) Создайте в том же пакете класс MyWrapper с единственным
полем – MyClass myClass. Поле должно быть инициализировано
объектом класса MyClass при создании экземпляра класса MyWrapper.

Создайте в этом классе один метод invoke(int method) которому
передаётся параметр method. Если method==1, то вызывается
myClass.firstMethod(), если method==2 то вызывается myClass.secondMethod.
Вызов firstMethod() должен быть обёрнут в блок трай/кэтч таким образом,
чтобы при возникновении исключения в консоль выводилось “exception 1”
или “exception 2” в зависимости от того, обрабатываем мы  AnotherException1
или, соответственно AnotherException2.Если же исключение не произошло, то
должно вывестись “no exceptions”.Вне зависимости от того, произошло
исключение или нет в конце должна быть выведена строка “hello”;

В том же классе напишите метод set(Object ob).
Реализация должна быть следующей: если на вход приходит объект String,
то происходит вызов myClass.setName(name) с этим  входящим параметром.
Если этот объект Integer, то происходит вызов myClass.setIntValue(intValue)
этим входящим параметром. Если объект любого другого типа или null то
должно бросаться исключение RuntimeException.

5) Создайте класс Starter   в том же пакете с методом мэйн.
В нём напишите:
MyWrapper wrapper = new MyWrapper()
и дальше вызывайте у него методы таким образом, чтобы получить в консоли ваши исключения.*/

public class Starter {
    public static void main(String[] args) {
        MyWrapper myWrapper = new MyWrapper(new MyClass(50,null));
        myWrapper.invoke(1);
        myWrapper.invoke(2);
        myWrapper.set(null);
    }
}
