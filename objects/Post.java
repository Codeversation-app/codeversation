package objects;

import java.util.Date;

public class Post{
    int ID;
    int threadID;
    int userID;
    String content;
    int score;
    long date;
    Post(String content, int userID, int ID){
        this.content  = content;
        this.ID = ID;
        this.userID = userID;
        this.score = 0;
        this.date = new Date().getTime();
        //Add this Post to the postdb
    }
}