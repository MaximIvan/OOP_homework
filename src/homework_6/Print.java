package homework_6;

public class Print {
    User user;

    public Print (User user) {this.user = user;}

    public void report(){
        System.out.println("Report for user: " + user.getName());
    }
}

