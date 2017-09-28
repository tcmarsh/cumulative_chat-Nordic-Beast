package cumulative.chat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CumulativeChat {
    
    //Arraylist for all the students in the chatroom
    ArrayList<Student> allStudents = new ArrayList<>();
    
    //Hashset to make sure there are no duplicates
    HashSet<Student> studentTable = new HashSet<>();
    
    //Iterates through allStudents and adds all the students to the HashSet
    public void GroupUp() {
        Student student;
        Iterator<Student> iterator = allStudents.iterator();
        while(iterator.hasNext()){
            student = iterator.next();
            System.out.println(student.Name());
        }
        
    }
    
    //Adds students to the ArrayList
    public void add(Student s){
        allStudents.add(s);
    }

    public static void main(String[] args) {
        CumulativeChat chat = new CumulativeChat();
        
//        Student aForsling = new Student("Austin", "Forsling", 80);
//        Student jBehunin = new Student("Justin", "Behunin", 77);
//        Student kBrown = new Student("Kenyon", "Brown", 92);
        chat.add(new Student("Austin", "Forsling", 80));
        chat.add(new Student("Justin", "Behunin", 77));
        chat.add(new Student("Kenyon", "Brown", 92));
        chat.add(new Student("Nicholas", "Goldberg", 52));
        chat.GroupUp();
//        System.out.println(aForsling.Name());
//        System.out.println(jBehunin.Name());
//        System.out.println(kBrown.Name());
    }
}
