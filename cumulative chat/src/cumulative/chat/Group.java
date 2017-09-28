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
        addResponses();
        pair.add(s1);
        pair.add(s2);
    }

    private void addResponses() {
        s1.responses.add("Hello");
        s1.responses.add("How are you doing?");
        s1.responses.add("Doing well");
        s1.responses.add("What do you like to do?");
        s1.responses.add("Hey, me too!");
        s2.responses.add("Hey there");
        s2.responses.add("I'm good, how about you?");
        s2.responses.add("Good to hear");
        s2.responses.add("I enjoy programming");
        s2.responses.add("Awesome!");
    }
}
