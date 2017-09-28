package cumulative.chat;

import java.util.ArrayList;

public class Group {
    //ArrayList that contains the pair of student objects
    ArrayList<Student> pair = new ArrayList<>();
    Student s1;
    Student s2;
    
    //Groups pairs of students into one "chat room"
    public Group(Student first, Student second){
        s1 = first;
        s2 = second;
        pair.add(s1);
        pair.add(s2);
    }
}
