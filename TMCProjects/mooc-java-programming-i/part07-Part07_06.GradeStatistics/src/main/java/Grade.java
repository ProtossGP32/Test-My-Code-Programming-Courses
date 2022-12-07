import java.util.ArrayList;

public class Grade {
    private ArrayList<Integer> points;

    public Grade() {
        this.points = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.points.isEmpty();
    }

    public void addPoints(int points) {
        if (points >= 0 && points <= 100) {
            this.points.add(points);
        }
    }

    public int pointsListSize() {
        return this.points.size();
    }
    public static double truncateDecimal(double value, int decimalPoint) {
        value *= Math.pow(10, decimalPoint);
        value = Math.floor(value);
        value /= Math.pow(10, decimalPoint);

        return value;
    }

    public double averagePoints() {
        if (this.isEmpty()) {
            return -1.0;
        }
        int sumOfPoints = 0;
        for (int point : this.points) {
            sumOfPoints += point;
        }

        return (double) sumOfPoints / this.pointsListSize();
    }

    public double averagePassingPoints() {
        if (this.isEmpty()) {
            return 0.0;
        }
        int sumOfPassingPoints = 0;
        int numberOfPassingPoints = 0;
        for (int point : this.points) {
            if (point >= 50) {
                sumOfPassingPoints += point;
                ++numberOfPassingPoints;
            }
        }

        if (numberOfPassingPoints == 0) {
            return 0.0;
        }
        return (double) sumOfPassingPoints / numberOfPassingPoints;
    }

    public double passPercentage() {
        if (this.isEmpty()) {
            return -1;
        }
        int numberOfPassing = 0;
        for (int point : this.points) {
            if (point >= 50) {
                ++numberOfPassing;
            }
        }

        return 100 * (double) numberOfPassing / this.pointsListSize();
    }

    public String toString() {
        String returnString = "[";
        for (int i = 0;  i < this.pointsListSize(); i++) {
            if (i < this.pointsListSize() - 1) {
                returnString += this.points.get(i) + ", ";
            } else {
                returnString += this.points.get(i) + "]";
            }
        }
        return returnString;
    }

    public String gradeDistribution() {
        // Initialize an empty list of grades
        String[] gradesList = {"", "", "", "", "", ""};
        int grade = -1;
        for (int number : this.points) {
            if (number < 50) {
                grade = 0;
            } else if (number < 60) {
                grade = 1;
            } else if (number < 70) {
                grade = 2;
            } else if (number < 80) {
                grade = 3;
            } else if (number < 90) {
                grade = 4;
            } else {
                grade = 5;
            }
            // Add the grade to the grades list
            gradesList[grade] += "*";
        }

        // Print the grades distribution
         return printGrade(gradesList);
    }

    public static String printGrade(String[] gradesList) {
        String gradesString = "";
        for (int i = gradesList.length; i > 0; i--) {
            gradesString += (i - 1) + ": " + gradesList[i - 1];
            if (i > 1) {
                gradesString += "\n";
            }
        }
        return gradesString;
    }
}
