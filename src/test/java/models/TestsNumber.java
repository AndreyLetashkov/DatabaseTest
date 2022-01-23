package models;

import lombok.Data;

@Data
public class TestsNumber {
    private int count;
    private String test;

    @Override
    public String toString() {
        return "|" + test + "\t| "+ count + "|";
    }
}