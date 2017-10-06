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
    // "pairs" isn't parameterized
    ArrayList<Group> pairs = new ArrayList<>();

    //Iterates through allStudents and adds all the students to the HashSet
    public void GroupUp() {
        Student s1;
        Student s2;

        RunHash();

        //Iterates over the studentTable hash set, and puts pairs into group objects
        //If there are an odd number of objects in the hashset, it ignores the final one.
        Iterator<Student> hIterator = studentTable.iterator();
        while (hIterator.hasNext()) {
            s1 = hIterator.next();
            if (hIterator.hasNext()) {
                s2 = hIterator.next();
                pairs.add(new Group(s1, s2));
            }
        }
        //Sort the pairs by first name
        Collections.sort(pairs, new Comparator<Group>() {
            @Override
            public int compare(Group g1, Group g2) {
                return g1.s1.Name().compareTo(g2.s1.Name());
            }
        });
        output();
    }

    //Puts all the names of students on the ArrayList into a HashSet, to prevent duplicates.
    private void RunHash() {
        // (most things you may think you need to build have probably already been implemented)
        studentTable.addAll(allStudents);
    }

    //Outputs the strings in the array lists of the pairs, to make a conversation.
    private void output() {
        Group pair;
        Iterator<Group> gIter = pairs.iterator();
        while (gIter.hasNext()) {
            pair = gIter.next();
            for (int i = 0; i < pair.s1.responses.size(); i++) {
                System.out.print(pair.s1.Name() + ": ");
                System.out.println(pair.s1.responses.get(i));
                System.out.print(pair.s2.Name() + ": ");
                System.out.println(pair.s2.responses.get(i));
            }
            System.out.println();
        }
    }

    //Adds students to the ArrayList
    public void add(Student s) {
        allStudents.add(s);
    }

    public static void main(String[] args) {
        CumulativeChat chat = new CumulativeChat();

        /* this setup takes up a lot more space, but it allows the hashset
         * to ignore duplicates, because the other version made a new Student,
         * so even if the data was the same, it was allowed into the hashset.
         */
        Student aForsling = new Student("Austin", "Forsling", 80);
        Student jBehunin = new Student("Justin", "Behunin", 77);
        Student kBrown = new Student("Kenyon", "Brown", 92);
        Student nGoldberg = new Student("Nicholas", "Goldberg", 52);
        Student tHoyer = new Student("Tyler", "Hoyer", 26);
        Student sJulien = new Student("Steven", "Julien", 32);
        Student jMirabile = new Student("Jonathan", "Mirabile", 68);
        Student cNash = new Student("Christopher", "Nash", 100);
        chat.add(aForsling);
        chat.add(jBehunin);
        chat.add(kBrown);
        chat.add(nGoldberg);
        chat.add(tHoyer);
        chat.add(sJulien);
        chat.add(jMirabile);
        chat.add(cNash);

        chat.GroupUp();
    }
}
