import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // implement here your program that uses the TelevisionProgram class

        ArrayList<TelevisionProgram> programs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Retrieve television programs' info
        while (true) {
            // Program name
            System.out.print("Name: ");
            String programName = scanner.nextLine();
            if (programName.isEmpty()) {
                System.out.println();
                break;
            }
            // Program duration
            int programDuration = 0;
            while (programDuration == 0) {
                System.out.print("Duration: ");
                programDuration = Integer.parseInt(scanner.nextLine());
                if (programDuration <= 0) {
                    System.out.println("Invalid program duration, please try again");
                }
            }
            // Add new program to list
            programs.add(new TelevisionProgram(programName, programDuration));
        }

        // Ask for program's max duration
        System.out.print("Program's maximum duration?");
        int maxDuration = Integer.parseInt(scanner.nextLine());
        for (TelevisionProgram program : programs) {
            if (program.getDuration() <= maxDuration) {
                System.out.println(program);
            }
        }
    }
}
