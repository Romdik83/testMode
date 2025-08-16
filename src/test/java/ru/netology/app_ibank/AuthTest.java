package ru.netology.app_ibank;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @BeforeEach
    void setUpEach() {
        open("http://localhost:9999");
    }

    @Test
    void shouldLogin() {
        val user = DataGenerator.Registration.registerUser("en-US", "active");
        $("span[data-test-id='login'] input").setValue(user.getLogin());
        $("span[data-test-id='password'] input").setValue(user.getPassword());
        $("button[data-test-id='action-login']").click();
        $("body div#root h2").shouldHave(text("Личный кабинет"));
    }


}
