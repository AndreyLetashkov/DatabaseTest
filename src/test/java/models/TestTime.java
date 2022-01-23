package models;

import lombok.Data;

@Data
public class TestTime {
    private String projectName;
    private String testName;
    private int minWorkingTime;

    @Override
    public String toString() {
        return "|" + projectName + " | "+ testName + "|" + minWorkingTime + "|";
    }
}