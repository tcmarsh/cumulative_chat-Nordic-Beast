package cumulative.chat;

public class CumulativeChat {

    public static void main(String[] args) {
        Student aForsling = new Student("Austin","Forsling",80);
        Student jBehunin = new Student("Justin","Behunin",77);
        Student kBrown = new Student("Kenyon","Brown",92);
        System.out.println(aForsling.Name());
        System.out.println(jBehunin.Name());
        System.out.println(kBrown.Name());
    }
}
