package ru.netology.delivery;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = {"Брянск", "Воронеж", "Москва", "Тамбов", "Санкт-Петербург", "Мурманск",
                "Великий Новгород", "Нижний Новгород", "Пенза", "Екатеринбург", "Тюмень", "Барнаул", "Новосибирск",
                "Владивосток", "Хабаровск", "Анадырь", "Майкоп", "Астрахань", "Волгоград", "Краснодар", "Ростов-на-Дону"};
        Random rand = new Random();

        return cities[rand.nextInt(cities.length)];
    }

    public static String generateName(){
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }
    public static String generatePhone(){
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }
    public static class Registration {
        private Registration(){
        }
        public static UserInfo generateUser(String locale){
            String city = generateCity();
            String name = generateName();
            String phone = generatePhone();
            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }
    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}