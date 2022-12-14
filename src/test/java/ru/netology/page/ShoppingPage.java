package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ShoppingPage {
    private SelenideElement cardNumber = $("input[placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $("input[placeholder='08']");
    private SelenideElement year = $("input[placeholder='22']");

    private SelenideElement name = $x("//*[text()='Владелец']/following-sibling::span/input");

    private SelenideElement cvv = $("input[placeholder='999']");
    private SelenideElement continueButton = $x("//*[text()='Продолжить']");
    private SelenideElement notification = $(".notification__content");
    private SelenideElement errorMessage = $(".input__sub");

    public void sendForm(DataHelper.CardInfo info) {
        cardNumber.setValue(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        name.setValue(info.getOwner());
        cvv.setValue(info.getCvv());
        continueButton.click();
    }
    public void getConfirmation(){
        notification
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Операция одобрена Банком."));
    }

    public void getError(){
        notification
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }

    public void getNotificationWrongValidityPeriod(){
        errorMessage
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Неверно указан срок действия карты"));
    }

    public void getNotificationWrongValidityPeriodInPast(){
        errorMessage
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Истёк срок действия карты"));
    }

    public void getNotificationWrongName(){
        errorMessage
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Неверный формат ввода. Укажите данные как на карте"));
    }
}