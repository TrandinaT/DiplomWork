package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class StartPage {

    private SelenideElement buy = $x("//*[text()='Купить']");
    private SelenideElement buyCredit = $x("//*[text()='Купить в кредит']");

    public ShoppingPage getTicket(){
        buy.click();
        return new ShoppingPage();
    }

    public ShoppingPage getTicketOnCredit(){
        buyCredit.click();
        return new ShoppingPage();
    }
}