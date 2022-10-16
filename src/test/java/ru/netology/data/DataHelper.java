package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataHelper {

    private DataHelper(){
    }

    private static Faker faker = new Faker(new Locale("en"));

    @Value
    public static class CardInfo{
        String cardNumber;
        String month;
        String year;
        String owner;
        String cvv;
    }

    private static String getValidMonth(){
        List<String> months = new ArrayList<>();
        months.add("01");
        months.add("02");
        months.add("03");
        months.add("04");
        months.add("05");
        months.add("06");
        months.add("07");
        months.add("08");
        months.add("09");
        months.add("10");
        months.add("11");
        months.add("12");

        Random random = new Random();
        String month = months.get(random.nextInt(months.size()));
        return month;
    }

    private static String getInvalidMonth(){
        return String.valueOf(faker.random().nextInt(13,99));
    }

    private static String getValidYear(){
        return String.valueOf(faker.random().nextInt(22,77));
    }

    private static String getInvalidYear(){
        return String.valueOf(faker.random().nextInt(01,21));
    }

    private static String getValidName(){
        return faker.name().name();
    }

    private static String getInvalidName(){
        return faker.internet().password();
    }

    private static String getCVV(){
        return faker.number().digits(3);
    }

    public static CardInfo getValidUser(){
        return new CardInfo("1111 2222 3333 4444",getValidMonth(),getValidYear(),getValidName(),getCVV());
    }

    public static CardInfo getInvalidUser(){
        return new CardInfo("5555 6666 7777 8888",getValidMonth(),getValidYear(),getValidName(),getCVV());
    }
}
