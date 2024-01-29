package entity;

import org.example.entity.GradingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {

    // Score : 95%, Présence : 90 => Note: A
    @Test
    void getGradeTest1() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(90);

        char grade = gradingCalculator.getGrade();
        Assertions.assertEquals('A', grade);
    }

    // Score : 85%, Présence : 90 => Note: B
    @Test
    void getGradeTest2() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(85);
        gradingCalculator.setAttendancePercentage(90);

        char grade = gradingCalculator.getGrade();
        Assertions.assertEquals('B', grade);
    }

    // Score : 65%, Présence : 90 => Note: C
    @Test
    void getGradeTest3() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(90);

        char grade = gradingCalculator.getGrade();
        Assertions.assertEquals('C', grade);
    }

    // Score : 95%, Présence : 65 => Note: B
    @Test
    void getGradeTest4() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(65);

        char grade = gradingCalculator.getGrade();
        Assertions.assertEquals('B', grade);
    }

    // Score : 95%, Présence : 55 => Note: F
    @Test
    void getGradeTest5() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(55);

        char grade = gradingCalculator.getGrade();
        Assertions.assertEquals('F', grade);
    }

    // Score : 65%, Présence : 55 => Note: F
    @Test
    void getGradeTest6() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(55);

        char grade = gradingCalculator.getGrade();
        Assertions.assertEquals('F', grade);
    }

    // Score : 50%, Présence : 90 => Note: F
    @Test
    void getGradeTest7() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(50);
        gradingCalculator.setAttendancePercentage(90);

        char grade = gradingCalculator.getGrade();
        Assertions.assertEquals('F', grade);
    }


}
