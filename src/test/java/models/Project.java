package models;

import lombok.Data;

@Data
public class Project {
    private String projectName;
    private String testName;
    private String startTime;

    @Override
    public String toString() {
        return "|" + projectName + " | \t" + testName + " |\t" + startTime + " |";
    }
}