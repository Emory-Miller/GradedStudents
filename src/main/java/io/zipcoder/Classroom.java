package io.zipcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Classroom {

    private Student[] students;


    private Comparator<Student> nameComparator = Comparator.comparing(o -> o.getFirstName());

    private Comparator<Student> scoreComprarator = (o1, o2) -> (int) (o2.getAverageExamScore() - o1.getAverageExamScore());

    private HashMap<Student, String> gradeBook = new HashMap<>();

    public Classroom() {
        students = new Student[30];
    }

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(int maxNumberOfStudents, Student[] Students) {

    }

    public Student[] getStudents() {
        return this.students;
    }

    public double getAverageExamScore() {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < this.students.length; i++) {
            while (this.students[i] != null) {
                count++;
                sum += this.students[i].getAverageExamScore();
                break;
            }
        }
        return sum / count;
    }

    public void removeStudent(String firstName, String lastName) {
        int count = 0;
        int temp = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName().equals(firstName) &&
                    students[i].getLastName().equals(lastName)) {
                students[i] = null;
                temp = i;
                count = i;
            }
        }

        boolean sorted = false;
        Student swap;
        while (!sorted) {
            sorted = true;
            for (int j = 0; j < students.length - 1; j++) {
                if (students[j] == null) {
                    swap = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = swap;
                    sorted = false;
                }
            }
        }
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public void sortStudentsByName() {
        Arrays.sort(students, nameComparator);
    }

    public void sortStudentsByScores() {
        sortStudentsByName();
        Arrays.sort(students, scoreComprarator);
    }

    public Student[] getStudentsByScore() {
        sortStudentsByScores();
        return students;
    }

    public HashMap<Student, String> getGradeBook() {
        this.students = getStudentsByScore();

        for (int i = 0; i < students.length; i++) {
            double percentile = 0;
            double rank = students.length - (i + 1);
            percentile = (rank / students.length) * 100.0;
            if (percentile >= 90) {
                gradeBook.put(students[i], "A");
            } else if (percentile <= 89 && percentile >= 71) {
                gradeBook.put(students[i], "B");
            } else if (percentile <= 70 && percentile >= 50) {
                gradeBook.put(students[i], "C");
            } else if (percentile <= 49 && percentile >= 11) {
                gradeBook.put(students[i], "D");
            } else {
                gradeBook.put(students[i], "F");
            }
        }
        return gradeBook;
    }
}
