package io.zipcoder;

import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, ArrayList<Double> examScores){  //Double[] ????
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    @Override
    public String toString(){
        return String.format("Student Name: %s %s\n> Average Score: %s\n> %s",
                this.firstName, this.lastName, (int) this.getAverageExamScore(), this.getExamScores());
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

    public String getExamScores() {
        StringBuilder examScores = new StringBuilder("Exam Scores:");
        for (int i = 0; i < this.examScores.size(); i++){
                examScores.append("\n\tExam ").append(i + 1).append(" -> ").append(String.format("%.0f",this.examScores.get(i)));
        }
        return examScores.toString();
    }

    public void setExamScore(int examNumber, double newScore){
        this.examScores.set(examNumber, newScore);
    }

    public void addExamScore(double examScore){
        this.examScores.add(examScore);
    }

    public int getNumberOfExamsTake(){ // returns total number
        return examScores.size();
    }

    public double getAverageExamScore(){
        double sumExamScore = 0.0;
        for (double value : this.examScores){
            sumExamScore += value;
        }
        return sumExamScore/this.examScores.size();
    }

}
