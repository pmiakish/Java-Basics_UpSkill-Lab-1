package com.epam.cycles;

public class CyclesTaskE {

    private static final int  ASCII_LENGTH = 255;

    public static void main(String[] args) {
        System.out.println("Mapping table of symbols and their numerical representations:");
        for (int i = 0; i <= ASCII_LENGTH; i++) {
            System.out.printf("%03d - %s%n", i, (char) i);
        }
    }
}