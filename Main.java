package Project;

public class Main {
    public static void main(String[] args){


        Array students = new Array(10);


        students.insert("Omar", 11, 89);
        students.insert("Amr", 23, 68);
        students.insert("Nedal", 48, 79);
        students.insert("Mahmoud", 62, 92);
        students.insert("Ali", 3, 58);
        students.insert("Abdo", 3999, 74);

        Student s1 = new Student("Musa", 486, 47);
        Student s2 = new Student("Isa", 946, 70);
        Student s3 = new Student("Hany", 791, 81);

        students.insert(s1);
        students.insert(s2);
        students.insert(s3);

        System.out.println("Display:");
        students.display();
        System.out.println("//////////");

        System.out.println("Find:");

        System.out.println("Index of student with ID: " + "486" + " is " + students.find(486));
        System.out.println("Index of student with ID: " + "418" + " is " + students.find(418));
        System.out.println("//////////");

        System.out.println("Delete:");
        System.out.println("Number of students before delete: " + students.getNumOfStudents());
        System.out.println("////////////");

        students.delete(3);
        students.delete(486);
        students.delete(946);
        students.delete(791);
        students.delete(386); // Not existed ID
        System.out.println("Display after delete:");
        students.display();

        System.out.println("////////////");
        System.out.println("Number of students after delete: " + students.getNumOfStudents());
        System.out.println("////////////");


    }
}
