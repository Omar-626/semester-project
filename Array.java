package Project;

public class Array {
    private int numOfStudents = 0;
    private int maxSize;
    private Student[] array;
    private int comparisons = 0;
    private int swaps = 0;

    Array(int maxSize){
        if(maxSize <= 0){
            throw new IllegalArgumentException("Array size must be positive number");
        }
        this.maxSize = maxSize;
        array = new Student[maxSize];
    }

    boolean isEmpty(){
        return numOfStudents == 0;
    }

    boolean isFull(){
        return numOfStudents == maxSize;
    }

    // Insert method:

     private void insert(String name, int id, double grade, int low, int high){

        comparisons++;
         if(isEmpty()) {
             array[0] = new Student(name, id, grade);
             numOfStudents++;
             return;
         }

         comparisons++;
         if(isFull()) {
             System.out.println("Array is full, can't insert more students");
             return;
         }

        Student newStudent = new Student(name, id, grade);

         comparisons++;
        if(low > high){
            for(int i = numOfStudents - 1; i >= low; i--){
                comparisons++;
                array[i + 1] = array[i];
                swaps++;
            }

            array[low] = newStudent;
            numOfStudents++;
            return;
        }

        int mid = low + (high - low) / 2;

        comparisons++;
        if(id == array[mid].getId()){
            throw new IllegalArgumentException("Inserted ID already exists");
        }

        comparisons++;
        if(id > array[mid].getId()) {
            insert(name, id, grade, mid + 1, high);
            return;
        }

        insert(name, id, grade, low, mid - 1);
    }

    // Insert wrapper method:

    void insert(String name, int id, double grade){
        insert(name, id, grade, 0, numOfStudents - 1);
    }

    // Insert wrapper method:

    void insert(Student newStudent){
        insert(newStudent.getName(), newStudent.getId(), newStudent.getGrade(), 0, numOfStudents - 1);
    }

    // Find method:

    private int find(int idTarget, int low, int high){

        comparisons++;
        if(isEmpty()) {
            System.out.println("Array is empty");
            return -1;
        }

        comparisons++;
        if(low > high) {
            System.out.println("Could not find ID:" + idTarget);
            return -1;
        }

        int mid = low + (high - low) / 2;

        comparisons++;
        if(idTarget == array[mid].getId() )
            return mid;

        comparisons++;
        if(idTarget > array[mid].getId())
            return find(idTarget, mid + 1, high);

        return find(idTarget, low, mid - 1);
    }

    // Find wrapper method:

    int find(int idTarget){
        return find(idTarget, 0, numOfStudents - 1);
    }

    // Delete method:

    Student delete(int idTarget){

        if(find(idTarget) != -1){
            int indexToDelete = find(idTarget);
            Student deletedStudent = array[indexToDelete];
            for(int i = indexToDelete; i < numOfStudents - 1; i++){
                comparisons++;
                array[i] = array[i + 1];
                swaps++;
            }

            numOfStudents--;
            return deletedStudent;
        }
        return null;

    }

    // Display students data:

    void display(){
        for(int i = 0; i < numOfStudents; i++){
            System.out.println(array[i].toString());
        }
    }

    int getNumOfStudents() {
        return numOfStudents;
    }

    int getSwaps() {
        return swaps;
    }

    int getComparisons() {
        return comparisons;
    }
}
