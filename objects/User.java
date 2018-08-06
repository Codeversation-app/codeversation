package objects;

public class User {
    int Status;
    String username;
    String password;
    int ID;

    User(int ID,String username,String password){
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.Status=1;
        //Add this user to the userdb
    }
}
