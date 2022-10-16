package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CreditBuy {
    private SelenideElement heading = $$(".heading").find(Condition.exactText("Купить в кредит"));
    private SelenideElement cardNumber = $("input[placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $("input[placeholder='08']");
    private SelenideElement year = $("input[placeholder='22']");

    private SelenideElement name = $x("//*[text()='Владелец']/following-sibling::span/input");

    private SelenideElement cvv = $("input[placeholder='999']");
    private SelenideElement continueButton = $x("//*[text()='Продолжить']");
    private SelenideElement notification = $(".notification__content");
    private SelenideElement errorNotification = $(withText("Ошибка! Банк отказал в проведении операции."));

    public void putCardData(DataHelper.CardInfo info) {
        cardNumber.setValue(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        name.setValue(info.getOwner());
        cvv.setValue(info.getCvv());
        continueButton.click();


    }
}