package cumulative.chat;

import java.util.ArrayList;

public class Group {
    //ArrayList that contains the pair of student objects
    // "pair" is a variable that's not used for anything, and serves only to be a possible issue for later maintenance.
    private ArrayList<Student> pair = new ArrayList<>();
    private Student s1;
    private Student s2;
    
    //Groups pairs of students into one "chat room"
    public Group(Student first, Student second){
        s1 = first;
        s2 = second;
        addResponses();
        pair.add(s1);
        pair.add(s2);
    }

    private void addResponses() {
        // You are reaching into an instance variable of another class.
        // In any object oriented language this is an incredibly bad idea for multiple reasons - not least of which is that you can't verify inputs if anybody can alter variables any way they want to.
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
