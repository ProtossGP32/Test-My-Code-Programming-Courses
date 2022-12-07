import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GradeTest {

    private Grade grade;
    private Random randomInts;
    @Before
    public void initialize() {
        this.grade = new Grade();
        this.randomInts = new Random();
    }

    @Test
    public void newGradeIsEmpty() {
        assertTrue(this.grade.isEmpty());
    }

    @Test
    public void add10CorrectPointsIncreasesPointsList() {
        // Insert 10 random valid values
        int[] tenRandomIntegers = this.randomInts.ints(10, 0, 101).toArray();
        for (int i = 0; i < 10; i++) {
            this.grade.addPoints(tenRandomIntegers[i]);
            assertEquals(i + 1, this.grade.pointsListSize());
        }
    }

    @Test
    public void add10IncorrectPointsDoesNotIncreasePointsList() {
        // Insert 10 random invalid values < 0
        int[] tenRandomIntegers = this.randomInts.ints(10, -1000, 0).toArray();
        for (int i = 0; i < 10; i++) {
            this.grade.addPoints(tenRandomIntegers[i]);
            assertEquals(0, this.grade.pointsListSize());
        }
        // The same for values > 100
        tenRandomIntegers = this.randomInts.ints(10, 101, 1000).toArray();
        for (int i = 0; i < 10; i++) {
            this.grade.addPoints(tenRandomIntegers[i]);
            assertEquals(0, this.grade.pointsListSize());
        }
    }

    @Test
    public void averageTestWithCorrectPoints() {
        int[] randomIntegers = this.randomInts.ints(100000, 0, 101).toArray();
        // Calculate the expected average value
        double expectedAverage = Arrays.stream(randomIntegers).sum() / (double) randomIntegers.length;
        expectedAverage = this.grade.truncateDecimal(expectedAverage, 2);
        for (int points : randomIntegers) {
            this.grade.addPoints(points);
        }

        double currentAverage = this.grade.truncateDecimal(this.grade.averagePoints(), 2);
        assertEquals(expectedAverage, currentAverage, 0.01);
    }

    @Test
    public void averageTestWithInvalidPoints() {
        int[] randomIntegers = this.randomInts.ints(100000, -1000, 1000).toArray();
        // Calculate the expected average value, only taking into account valid points
        int validSum = 0;
        int validNumbers = 0;
        for (int value : randomIntegers) {
            if (0 <= value && value <= 100) {
                validSum += value;
                ++validNumbers;
            }
        }
        double expectedAverage = (double) validSum / validNumbers;
        expectedAverage = this.grade.truncateDecimal(expectedAverage, 2);

        // Calculate the current average value
        for (int points : randomIntegers) {
            this.grade.addPoints(points);
        }
        double currentAverage = this.grade.truncateDecimal(this.grade.averagePoints(), 2);

        assertEquals(expectedAverage, currentAverage, 0.01);
    }

    @Test
    public void averagePassingPointsTest() {
        int[] randomIntegers = this.randomInts.ints(100000, -1000, 1000).toArray();
        // Calculate the expected average value, only taking into account valid points
        int validSum = 0;
        int validNumbers = 0;
        for (int value : randomIntegers) {
            if (50 <= value && value <= 100) {
                validSum += value;
                ++validNumbers;
            }
        }
        double expectedAverage = (double) validSum / validNumbers;
        expectedAverage = this.grade.truncateDecimal(expectedAverage, 2);

        // Calculate the current average value
        for (int points : randomIntegers) {
            this.grade.addPoints(points);
        }
        double currentAverage = this.grade.truncateDecimal(this.grade.averagePassingPoints(), 2);

        assertEquals(expectedAverage, currentAverage, 0.01);
    }

    @Test
    public void passPercentageTestSimple() {
        int[] testIntegers = {0, 50, 75, -100, 99, 100, 25};
        // Calculate the expected average value, only taking into account valid points
        int passingNumbers = 0;
        int validNumbers = 0;
        for (int value : testIntegers) {
            if (0 <= value && value <= 100) {
                ++validNumbers;
                if (value >= 50) {
                    ++passingNumbers;
                }
            }
        }
        double expectedPassing = 100 * (double) passingNumbers / validNumbers;
        expectedPassing = this.grade.truncateDecimal(expectedPassing, 2);

        // Calculate the current average value
        for (int points : testIntegers) {
            this.grade.addPoints(points);
        }
        //System.out.println("Current grade: " + this.grade);
        double currentPassing = this.grade.truncateDecimal(this.grade.passPercentage(), 2);

        assertEquals(expectedPassing, currentPassing, 0.01);
    }

    @Test
    public void passPercentageTestWithRandomNumbers() {
        int[] randomIntegers = this.randomInts.ints(100000, -1000, 1000).toArray();
        // Calculate the expected average value, only taking into account valid points
        int passingNumbers = 0;
        int validNumbers = 0;
        for (int value : randomIntegers) {
            if (0 <= value && value <= 100) {
                ++validNumbers;
                if (value >= 50) {
                    ++passingNumbers;
                }
            }
        }
        double expectedPassing = 100 * (double) passingNumbers / validNumbers;
        expectedPassing = this.grade.truncateDecimal(expectedPassing, 2);

        // Calculate the current average value
        for (int points : randomIntegers) {
            this.grade.addPoints(points);
        }
        //System.out.println("Current grade: " + this.grade);
        double currentPassing = this.grade.truncateDecimal(this.grade.passPercentage(), 2);

        assertEquals(expectedPassing, currentPassing, 0.01);
    }

    @Test
    public void passPercentageTestWithNoOnePassing() {
        int[] randomIntegers = this.randomInts.ints(100000, 0, 50).toArray();

        // Calculate the current average value
        for (int points : randomIntegers) {
            this.grade.addPoints(points);
        }
        //System.out.println("Current grade: " + this.grade);
        double currentPassing = this.grade.truncateDecimal(this.grade.passPercentage(), 2);

        assertEquals(0.0, currentPassing, 0.01);
    }

    @Test
    public void gradeDistributionTestSimple() {
        int[] testPoints = {102, -2, 1, 33, 77, 99};
        String expectedGrades = "5: *\n4: \n3: *\n2: \n1: \n0: **";

        for (int number : testPoints) {
            this.grade.addPoints(number);
        }

        assertEquals(expectedGrades, this.grade.gradeDistribution());
    }
}
