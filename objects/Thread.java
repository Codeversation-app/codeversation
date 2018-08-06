package objects;

public class Thread {
    int threadID;
    int featured;
    int OP;
    String title;
    Thread(int ID, String title, int OriginalID, String content, int userID){
        this.OP = OriginalID;
        this.title = title;
        this.threadID = ID;

        //Add this post to the postdb
        new Post(content, userID, OriginalID);

        //Add this thread to the postdb
    }
}
