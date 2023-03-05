package homework_6;

public class Main {
    public static void main(String[] args){
        User user = new User("Bob");
        Persister persister = new Persister(user);
        Print report = new Print(user);
        persister.save();
        report.report();
    }
}

