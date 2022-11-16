package io.zipcoder;

public class Classroom {

    private Student[] students;

    private int maxNumberOfStudents;

    public Classroom(){
            students = new Student[30];
    }

    public Classroom(int maxNumberOfStudents){
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students){
        this.students = students;
    }

    public Classroom(int maxNumberOfStudents, Student[] Students){

    }

    public Student[] getStudents(){
        return this.students;
    }

    public double getAverageExamScore(){
        int sum = 0;
        int count = 0;
        for (int i = 0 ; i < this.students.length ; i++){
            while(this.students[i] != null){
                count ++;
                sum += this.students[i].getAverageExamScore();
                break;
            }
        }
        return sum/count;
    }

    public void removeStudent(String firstName, String lastName) {
        int count = 0;
        int temp = 0;

        for (int i = 0 ; i < students.length ; i++){
            if (students[i].getFirstName().equals(firstName) &&
                    students[i].getLastName().equals(lastName)){
                students[i] = null;
                temp = i;
                count = i;
            }
        }

        boolean sorted = false;
        Student swap;
        while (!sorted){
            sorted = true;
            for(int j = 0 ; j <students.length -1 ; j++){
                if (students[j] == null){
                    swap = students[j];
                    students[j] = students[j +1];
                    students[j+1] = swap;
                    sorted = false;
                }
            }
        }

//        for (int j = temp + 1; j < students.length ; j++){
//            if (students[j] == null){
//                students[count] = students[j-1];
//                students[j-1] = null;
//            }
//        }
    }

    public void addStudent(Student student){
        for (int i = 0 ; i < students.length ; i++){
            if (students[i] == null){
                students[i] = student;
                break;
            }
        }
    }

    public void getStudentsByScore(){

    }
}
