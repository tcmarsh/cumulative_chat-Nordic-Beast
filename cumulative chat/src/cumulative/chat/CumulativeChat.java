package cumulative.chat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CumulativeChat {
    
    //Arraylist for all the students in the chatroom
    ArrayList<Student> allStudents = new ArrayList<>();
    
    //Hashset to make sure there are no duplicates
    HashSet<Student> studentTable = new HashSet<>();
    
    //Arraylist of Groups that the Group class can return to
    ArrayList<Group> pairs;
    
    //Iterates through allStudents and adds all the students to the HashSet
    public void GroupUp() {
        Student s1;
        Student s2;
        
        RunHash();
        
        //Iterates over the studentTable hash set, and puts pairs into group objects
        Iterator<Student> hIterator = studentTable.iterator();
        while(hIterator.hasNext()){
            s1 = hIterator.next();
            if(hIterator.hasNext()){
                s2 = hIterator.next();
                pairs.add(new Group(s1,s2));
            }
        }
        
    }
    
    //Puts all the names of students on the ArrayList into a HashSet, to prevent duplicates.
    private void RunHash() {
        Iterator<Student> iterator = allStudents.iterator();
        while(iterator.hasNext()){
            studentTable.add(iterator.next());
        }
    }
    
    //Adds students to the ArrayList
    public void add(Student s){
        allStudents.add(s);
    }

    public static void main(String[] args) {
        CumulativeChat chat = new CumulativeChat();

        chat.add(new Student("Austin", "Forsling", 80));
        chat.add(new Student("Justin", "Behunin", 77));
        chat.add(new Student("Kenyon", "Brown", 92));
        chat.add(new Student("Nicholas", "Goldberg", 52));
        chat.GroupUp();
    }

    
}
