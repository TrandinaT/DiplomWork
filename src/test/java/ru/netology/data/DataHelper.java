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

    public static String getValidMonth(int month) {
        String value;
        switch (month) {
            case 0:
                value = "";
                break;
            case 1:
                value = String.valueOf(faker.number().numberBetween(10, 12));
                break;
            case 2:
                value = "15";
                break;
            case 3:
                value = "month";
                break;
            default:
                value = "00";
                break;
        }
        return value;
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
        return new CardInfo("1111 2222 3333 4444",getValidMonth(1),getValidYear(),getValidName(),getCVV());
    }

    public static CardInfo getInvalidUser(){
        return new CardInfo("5555 6666 7777 8888",getInvalidMonth(),getInvalidYear(),getInvalidName(),getCVV());
    }
    public static CardInfo getIncorrectCardNumber(){
        return new CardInfo("1111 2222 3333 4445",getValidMonth(6),getValidYear(),getValidName(),getCVV());
    }

    public static CardInfo getWrongMonth(){
        return new CardInfo("1111 2222 3333 4444",getInvalidMonth(),getValidYear(),getValidName(),getCVV());
    }

    public static CardInfo getWrongYear(){
        return new CardInfo("1111 2222 3333 4444",getValidMonth(12),getInvalidYear(),getValidName(),getCVV());
    }
}
