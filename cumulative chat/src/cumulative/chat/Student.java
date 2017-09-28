package cumulative.chat;

import java.util.ArrayList;

public class Student {

    //Important variables
    String fName = new String();
    String lName = new String();
    int score;
    ArrayList<String> responses = new ArrayList<>();

    public Student(String first, String last, int inScore) {
        fName = first;
        lName = last;
        score = inScore;

    }
    
    //returns the full name of the student
    public String Name(){
        return this.fName + " " + this.lName;
    }

}
