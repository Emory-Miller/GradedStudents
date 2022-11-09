package io.zipcoder;

import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, ArrayList<Double> examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void getExamScores() {
        System.out.println(examScores);
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double examScore) {
        examScores.add(examNumber, examScore);
    }

    public void getAverageExamScore(){
        double sumExamScore = 0.0;
        for (double value : examScores){
            sumExamScore += value;
        }
        System.out.println(sumExamScore/examScores.size());
    }

}
