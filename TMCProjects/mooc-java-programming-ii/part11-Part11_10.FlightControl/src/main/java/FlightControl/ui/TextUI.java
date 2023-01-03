package FlightControl.ui;

import FlightControl.domain.Airplane;
import FlightControl.logic.FlightControl;

import java.util.Scanner;

public class TextUI {

    private FlightControl flightControl;
    private Scanner scanner;

    public TextUI(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    public void start() {
        // Two parts:
        // Part 1: Asset control
        startAssetControl();
        System.out.println();
        // Part 2: Flight control
        startFlightControl();
        System.out.println();
    }

    private void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");

            System.out.print("> ");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    // Add an airplane (private method)
                    addAirplane();
                    break;
                case "2":
                    // Add a flight (private method)
                    addFlight();
                    break;
            }
            if (answer.equals("x")) {
                break;
            }

        }
    }

    // Private methods
    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.parseInt(this.scanner.nextLine());

        this.flightControl.addAirplane(id, capacity);
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        Airplane airplane = askForAirplane();
        System.out.print("Give the departure airport id: ");
        String departureID = this.scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destinationID = this.scanner.nextLine();

        this.flightControl.addFlight(airplane, departureID, destinationID);
    }

    private Airplane askForAirplane() {
        Airplane airplane = null;
        while (airplane == null) {
            String id = this.scanner.nextLine();
            airplane = flightControl.getAirplane(id);

            if (airplane == null) {
                System.out.println("No airplane with the id " + id + ".");
            }
        }

        return airplane;
    }

    private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");

            System.out.print("> ");
            String answer = this.scanner.nextLine();

            switch (answer) {
                case "1":
                    printAirplanes();
                    break;
                case "2":
                    printFlights();
                    break;
                case "3":
                    printAirplaneDetails();
                    break;
            }
            if (answer.equals("x")) {
                break;
            }

        }
    }

    private void printAirplanes() {
        flightControl.getAirplanes().stream()
                .forEach(airplane -> System.out.println(airplane));
    }

    private void printFlights() {
        flightControl.getFlights().stream()
                .forEach(flight -> System.out.println(flight + "\n"));
    }

    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        Airplane plane = askForAirplane();
        System.out.println(plane);
        System.out.println();
    }
}
