package io.zipcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    @Test
    public void constructorTest(){
        String firstName = "Emory";
        String lastName = "Miller";
        ArrayList<Double> examScores = new ArrayList<>();
        double[] examScoresArray = {95, 100, 95, 100};
        examScores = Arrays.asList(examScoresArray).toArray();
    }
}