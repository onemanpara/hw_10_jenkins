package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.GeolocationComponent;
import com.demoqa.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private GeolocationComponent geolocationComponent = new GeolocationComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbieInput = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            pictureInput = $("#uploadPicture");

    public RegistrationForm openPage() {
        open("/automation-practice-form")
        ;

        return this;
    }

    public RegistrationForm setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationForm setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationForm setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationForm setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationForm setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationForm setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationForm setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationForm setHobbies(String value) {
        hobbieInput.$(byText(value)).click();

        return this;
    }

    public RegistrationForm setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationForm setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationForm setLocation(String state, String city) {
        $("#state").scrollIntoView(true);
        geolocationComponent.setGeolocation(state, city);

        return this;
    }

    public RegistrationForm clickSubmit() {
        $("#submit").click();

        return this;
    }

    public RegistrationForm checkResult(String key, String info) {
        resultTableComponent.resultIsVisible(key, info);

        return this;
    }

}
