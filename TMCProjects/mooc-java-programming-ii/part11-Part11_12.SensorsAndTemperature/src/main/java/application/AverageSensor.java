package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private List<Sensor> sensorList;
    private List<Integer> readingsList;

    public AverageSensor() {
        this.sensorList = new ArrayList<>();
        this.readingsList = new ArrayList<>();
    }
    public void addSensor(Sensor toAdd) {
        this.sensorList.add(toAdd);
    }
    @Override
    public boolean isOn() {
        return !this.sensorList.parallelStream().anyMatch(sensor -> !sensor.isOn());
    }

    @Override
    public void setOn() {
        this.sensorList.stream()
                .forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        this.sensorList.stream()
                .forEach(sensor -> sensor.setOff());

    }

    @Override
    public int read() throws IllegalStateException{
        if (!this.isOn() || this.sensorList.isEmpty()) {
            throw new IllegalStateException("No sensors active or empty sensors list.");
        }
        int average = (int) this.sensorList.stream()
                .mapToInt(sensor -> sensor.read())
                .average().getAsDouble();

        this.readingsList.add(average);
        return average;
    }

    public List<Integer> readings() {
        return this.readingsList;
    }
}
