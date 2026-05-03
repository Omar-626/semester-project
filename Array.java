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

    // Insert method: (Time complexity: O(n) → linear search to then position + shifting elements)
    //                (Space complexity: O(1) → no extra space used; operates in-place with a few variables)
    void insert(String name, int id, double grade){

        if(isFull()){
            System.out.println("Array is full, Couldn't insert more students");
            return;
        }

        Student newStudent = new Student(name, id, grade);

        for(int i = 0; i < numOfStudents; i++){
            comparisons++;
            if(newStudent.getId() < array[i].getId()){
                for(int j = numOfStudents - 1; j >= i; j--){
                    comparisons++;
                    array[j + 1] = array[j];
                    swaps++;
                }
                array[i] = newStudent;
                numOfStudents++;
                return;
            }
        }

        array[numOfStudents] = newStudent;
        numOfStudents++;
    }

    // Insert overloading:

    void insert(Student newStudent){
        insert(newStudent.getName(), newStudent.getId(), newStudent.getGrade());
    }


    // Find method: (Time complexity: O(log n) → recursive binary search)
    //              (Space complexity: O(log n) → due to the recursion call stack in binary search)

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

    // Delete method: (Time complexity: O(n) → binary search then shifting elements)
    //                (Space complexity: O(1) → removal is done in-place without additional memory)

    Student delete(int idTarget){

        int indexToDelete = find(idTarget);

        if(indexToDelete != -1){
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

    // Display students data: (Time complexity: O(n) → full traversal of array)
    //                        (Space complexity: O(1) → only uses a loop variable; no extra memory allocated)

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
