package cumulative.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

public class CumulativeChat {
    
    //Arraylist for all the students in the chatroom
    ArrayList<Student> allStudents = new ArrayList<>();
    
    //Hashset to make sure there are no duplicates
    HashSet<Student> studentTable = new HashSet<>();
    
    //Arraylist of Groups that the Group class can return to
    ArrayList<Group> pairs = new ArrayList();
    
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
                //System.out.println("made it past first pair");
            }
        }
        //Sort the pairs by first name
        Collections.sort(pairs, new Comparator<Group>(){
            @Override
            public int compare(Group g1, Group g2){
                return g1.s1.Name().compareTo(g2.s1.Name());
            }
        });
        
        output();
    }
    
    //Puts all the names of students on the ArrayList into a HashSet, to prevent duplicates.
    private void RunHash() {
        Iterator<Student> iterator = allStudents.iterator();
        while(iterator.hasNext()){
            studentTable.add(iterator.next());
        }
    }
    
    private void output(){
        Iterator<Group> gIter = pairs.iterator();
        while(gIter.hasNext()){
            System.out.println(gIter.next().s1.Name());
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
