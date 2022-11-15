package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentTest {

    @Test
    public void constructorTest(){
        Student student = new Student("Emory", "Miller", new ArrayList<>());

        String expectedFirstName = "Emory";
        String expectedLastName = "Miller";

        String actualFirstName = student.getFirstName();
        String actualLastName = student.getLastName();

        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void getExamScoresTest(){
        // This test should print out an exam score to test this. No Assert.assertEquals
        // : Given
    String firstName = "Leon";
    String lastName = "Hunter";
    Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
    ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
    Student student = new Student(firstName, lastName, examScoresList);

    // When
    String output = student.getExamScores();

    // Then
    System.out.println(output);
    }

    @Test
    public void addExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);
        String expected = "Exam Scores:\n\tExam 1 -> 100";

        // When
        student.addExamScore(100.0);
        String actual = student.getExamScores();

        // Then
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setExamScores(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);
        String expected = "Exam Scores:\n\tExam 1 -> 150";

// When
        student.setExamScore(0, 150.0);
        String actual = student.getExamScores();

// Then
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);
        double expected = 125.0;
        // When
        double actual = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void toStringTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);
        String expected = "Student Name: Leon Hunter\n> Average Score: 125\n> Exam Scores:\n" +
                "\tExam 1 -> 100\n\tExam 2 -> 150\n\tExam 3 -> 250\n\tExam 4 -> 0";

        // When
        String actual = student.toString();

        // Then
        System.out.println(actual);

        Assert.assertEquals(expected,actual);
    }
}