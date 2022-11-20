package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ClassroomTest {

    @Test
    public void getStudentsTest(){
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student("Leon", "Hunter", examScoresList);

        String expected = expected = "[Student Name: Leon Hunter\n> Average Score: 125\n> Exam Scores:\n" +
                "\tExam 1 -> 100\n\tExam 2 -> 150\n\tExam 3 -> 250\n\tExam 4 -> 0]";

        classroom.addStudent(student);
        Student[] students = classroom.getStudents();
        String actual = Arrays.toString(students);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudentTest(){
        // This test does not have an Assert Equals, manually check string output for results.
        // String null expected on second line
        // String with exam scores of Leon Hunter expected after.
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student("Leon", "Hunter", examScoresList);

        // When
        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then

        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void getAverageExamScoreTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        ArrayList<Double> s1ScoresList = new ArrayList<>(List.of(s1Scores));
        Double[] s2Scores = { 225.0, 25.0 };
        ArrayList<Double> s2ScoresList = new ArrayList<>(List.of(s2Scores));

        Student s1 = new Student("student", "one", s1ScoresList);

        Student s2 = new Student("student", "two", s2ScoresList);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);
        double expected = 125.0;
        // When
        double actual = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void removeStudentTest(){
        // This test does not have an Assert Equals, manually check string output for results.
        // Expected output is "null" at the end of the string output
        // : Given
        Double[] s1Scores = { 1.0, 0.0 };
        ArrayList<Double> s1ScoresList = new ArrayList<>(List.of(s1Scores));
        Double[] s2Scores = { 2.0, 0.0 };
        ArrayList<Double> s2ScoresList = new ArrayList<>(List.of(s2Scores));
        Double[] s3Scores = { 3.0, 0.0 };
        ArrayList<Double> s3ScoresList = new ArrayList<>(List.of(s3Scores));
        Double[] s4Scores = { 4.0, 0.0 };
        ArrayList<Double> s4ScoresList = new ArrayList<>(List.of(s4Scores));
        Double[] s5Scores = { 5.0, 0.0 };
        ArrayList<Double> s5ScoresList = new ArrayList<>(List.of(s5Scores));

        Student s1 = new Student("student", "one", s1ScoresList);
        Student s2 = new Student("student", "two", s2ScoresList);
        Student s3 = new Student("student", "three", s3ScoresList);
        Student s4 = new Student("student", "four", s4ScoresList);
        Student s5 = new Student("student", "five", s5ScoresList);

        Student[] students = {s1,s2, s3, s4, s5};
        Classroom classroom = new Classroom(students);

        // When
        classroom.removeStudent("student", "two");

        Student[] actual = classroom.getStudents();
        String removed = Arrays.toString(actual);

        System.out.println(removed);
        Student[] expected = { s1, s3, s4, s5, null};

        // Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest(){
        Double[] s1Scores = { 150.0, 150.0 };
        ArrayList<Double> s1ScoresList = new ArrayList<>(List.of(s1Scores));
        Double[] s2Scores = { 225.0, 25.0 };
        ArrayList<Double> s2ScoresList = new ArrayList<>(List.of(s2Scores));
        Double[] s3Scores = { 175.0, 150.0 };
        ArrayList<Double> s3ScoresList = new ArrayList<>(List.of(s3Scores));
        Double[] s4Scores = { 225.0, 25.0 };
        ArrayList<Double> s4ScoresList = new ArrayList<>(List.of(s4Scores));


        Student s1 = new Student("student", "one", s1ScoresList);
        Student s2 = new Student("student", "two", s2ScoresList);
        Student s3 = new Student("student", "three", s3ScoresList);
        Student s4 = new Student("student", "four", s4ScoresList);

        Student[] students = {s1, s2, s3, s4};
        Classroom classroom = new Classroom(students);

        classroom.getStudentsByScore();

        Student[] actual = classroom.getStudents();
        String scoreSort = Arrays.toString(actual);
        Student[] expected = {s3, s1, s2, s4};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getGradeBookTest1(){
        Double[] s1Scores = { 100.0, 70.0 };
        ArrayList<Double> s1ScoresList = new ArrayList<>(List.of(s1Scores));
        Double[] s2Scores = { 80.0, 75.0 };
        ArrayList<Double> s2ScoresList = new ArrayList<>(List.of(s2Scores));
        Double[] s3Scores = { 95.0, 85.0 };
        ArrayList<Double> s3ScoresList = new ArrayList<>(List.of(s3Scores));
        Double[] s4Scores = { 100.0, 100.0 };
        ArrayList<Double> s4ScoresList = new ArrayList<>(List.of(s4Scores));
        Double[] s5Scores = { 50.0, 75.0 };
        ArrayList<Double> s5ScoresList = new ArrayList<>(List.of(s5Scores));
        Double[] s6Scores = { 75.0, 75.0 };
        ArrayList<Double> s6ScoresList = new ArrayList<>(List.of(s6Scores));
        Double[] s7Scores = { 100.0, 75.0 };
        ArrayList<Double> s7ScoresList = new ArrayList<>(List.of(s7Scores));
        Double[] s8Scores = { 95.0, 75.0 };
        ArrayList<Double> s8ScoresList = new ArrayList<>(List.of(s8Scores));
        Double[] s9Scores = { 75.0, 85.0 };
        ArrayList<Double> s9ScoresList = new ArrayList<>(List.of(s9Scores));
        Double[] s10Scores = { 95.0, 85.0 };
        ArrayList<Double> s10ScoresList = new ArrayList<>(List.of(s10Scores));


        Student s1 = new Student("student", "one", s1ScoresList);
        Student s2 = new Student("student", "two", s2ScoresList);
        Student s3 = new Student("student", "three", s3ScoresList);
        Student s4 = new Student("student", "four", s4ScoresList);
        Student s5 = new Student("student", "five", s5ScoresList);
        Student s6 = new Student("student", "six", s6ScoresList);
        Student s7 = new Student("student", "seven", s7ScoresList);
        Student s8 = new Student("student", "eight", s8ScoresList);
        Student s9 = new Student("student", "nine", s9ScoresList);
        Student s10 = new Student("student", "ten", s10ScoresList);

        Student[] students = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
        Classroom classroom = new Classroom(students);

        HashMap<Student, String> gB = classroom.getGradeBook();

        String expected = "A";
        String actual = gB.get(s4);

        Assert.assertEquals(expected,actual);
    }

}
