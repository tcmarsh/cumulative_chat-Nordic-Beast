package cumulative.chat;

import java.util.ArrayList;

public class Student {

    String fName = new String();
    String lName = new String();
    int score;
    ArrayList<String> responses = new ArrayList<>();

    public Student(String first, String last, int inScore) {
        fName = first;
        lName = last;
        score = inScore;

    }
    
    public String Name(){
        return this.fName + " " + this.lName;
    }

}
