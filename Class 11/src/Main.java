import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("John", 21);
        Student s2 = new Student("Bob", 23);
        Student s3 = new Student("Lisa", 19);
        Student s4 = new Student("Lisa", 21);

        Set<Student> set = new TreeSet<>();

        set.add(s1);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);

        for (Student s : set)
            System.out.println(s);

    }
}