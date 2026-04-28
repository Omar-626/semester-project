package Project;

public class Main {
    public static void main(String[] args){
//        Student s1 = new Student("Omar", 11, 89);
//        Student s2 = new Student("Ali", 48, 79);
//        Student s3= new Student("Amr", 23, 68);
//        Student s4 = new Student("Mahmoud", 62, 92);
//
//
//        Student[] array = {s1, s2, s3, s4};
//
//        Array students = new Array(array);
//
//        students.insert("Nedal", 81, 72, 0, 4);

        Array students = new Array(10);

        students.insert("Amr", 23, 68);
        students.insert("Omar", 11, 89);
        students.insert("Ali", 48, 79);
        students.insert("Mahmoud", 62, 92);
        students.insert("Masud", 3, 58);
        students.insert("Abdo", 3999, 74);


        students.display();
        System.out.println("Num of students: " + students.getNumOfStudents());


        students.delete(3);
        students.delete(48);
        students.delete(11);



        System.out.println("");

        students.display();
        System.out.println("Num of students: " + students.getNumOfStudents());

        Student s1 = new Student("Musa", 486, 47);
        Student s2 = new Student("Isa", 946, 70);
        Student s3 = new Student("Hany", 791, 81);

        students.insert(s1);
        students.insert(s2);
        students.insert(s3);



//        students.insert("Musa", 486, 47);
//        students.insert("Isa", 946, 70);
//        students.insert("Hany", 791, 81);

        System.out.println("");

        students.display();
        System.out.println("Num of students: " + students.getNumOfStudents());





    }
}
