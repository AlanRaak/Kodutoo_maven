package hello;

public class Greeter {
    public String sayHello(String name) {
        Counter counter = new Counter();
        int length = counter.nameLength(name);

        if (length < 5){
            return "Tere lühikee: " + name;
        }else{
            return "Tere pikk: " + name;
        }
    }
}