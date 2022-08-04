package com.cydeo.tests.day09_javafaker_testbase_driver;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerPractice {

    @Test
    public void test1() {

        //Creating Faker object to reach methods
        Faker faker = new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address() = " + faker.address());
        System.out.println("faker.address().cityName() = " + faker.address().cityName());
        //numerify() method will generate random numbers in the front we want to get
        System.out.println("faker.numerify(\"###-###-###\") = " + faker.numerify("###-###-###"));
        System.out.println("faker.numerify(\"111-###-###\") = " + faker.numerify("111-###-###"));
        System.out.println("faker.numerify(\"111-#####-###\") = " + faker.numerify("111-#####-###"));

        System.out.println("faker.letterify(\"????????\") = " + faker.letterify("????????"));
        System.out.println("faker.letterify(\"adfrerrrr-???xx???\") = " + faker.letterify("adfrerrrr-???xx???"));

        System.out.println("faker.bothify(\"##?##-11??A-222???-###-???\") = " + faker.bothify("##?##-11??A-222???-###-???"));

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Ali"));


    }

    @Test
    public void test2() {

        //Creating Faker object to reach methods another language
        Faker faker = new Faker(new Locale("tr"));
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address() = " + faker.address());
        System.out.println("faker.address().cityName() = " + faker.address().cityName());
        //numerify() method will generate random numbers in the front we want to get
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Ali"));


    }
}
