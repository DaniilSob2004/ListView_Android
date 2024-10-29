package com.example.listview.utils;

import com.example.listview.R;

import java.util.Random;

public class TestUtils {
    private static final Random RAND = new Random();
    private static final int MIN_INT = 1;
    private static final int MAX_INT = 100_000_000;

    private static final String[] FIRST_NAMES = {
            "Daniil", "Bob", "Thomas", "Robert", "Andrey",
            "Max", "Tom", "Anna", "Ksenia", "Daniel"
    };
    private static final String[] LAST_NAMES = {
            "Sobolev", "Johnson", "Williams", "Brown", "Jones",
            "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"
    };
    private static final String[] COUNTRIES = {
            "Ukraine", "United States", "Canada", "Germany", "France",
            "Spain", "Italy", "Australia", "Brazil", "Japan"
    };
    private static final String[] CITIES = {
            "Kyiv", "Washington, D.C.", "Toronto", "Berlin", "Paris",
            "Madrid", "Rome", "Sydney", "Rio de Janeiro", "Tokyo"
    };
    private static final int[] AVATARS = {
            R.drawable.user1, R.drawable.user2, R.drawable.user3, R.drawable.user4, R.drawable.user5
    };


    public static String getRandomFirstName() {
        return FIRST_NAMES[RAND.nextInt(FIRST_NAMES.length)];
    }

    public static String getRandomLastName() {
        return LAST_NAMES[RAND.nextInt(LAST_NAMES.length)];
    }

    public static String getRandomCountry() {
        return COUNTRIES[RAND.nextInt(COUNTRIES.length)];
    }

    public static String getRandomCity() {
        return CITIES[RAND.nextInt(CITIES.length)];
    }

    public static int getRandomAvatar() {
        return AVATARS[RAND.nextInt(AVATARS.length)];
    }


    public static int getRandomInteger() {
        return getRandomInteger(MIN_INT, MAX_INT);
    }

    public static int getRandomInteger(int min) {
        return getRandomInteger(min, MAX_INT);
    }

    public static int getRandomInteger(final int min, final int max) {
        return RAND.nextInt((max - min) + 1) + min;
    }
}
