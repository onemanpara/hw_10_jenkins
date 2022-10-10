package com.demoqa.tests;

import com.demoqa.pages.RegistrationForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationFormTest extends TestBase {

    RegistrationForm registrationForm = new RegistrationForm();

    @DisplayName("Registration Form Test")
    @Test
    void formTest() {
        step("Fill the form fields", () -> {
            registrationForm.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setNumber(number)
                    .setBirthDate(day, month, year)
                    .setSubject(subject)
                    .setHobbies(hobbie)
                    .setPicture(imgPath)
                    .setAddress(address)
                    .setLocation(state, city)
                    .clickSubmit();
        });

        step("Check result", () -> {
            registrationForm.checkResult("Student Name", (firstName + " " + lastName))
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", number)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobbie)
                    .checkResult("Picture", "test.jpg")
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);
        });
    }
}
