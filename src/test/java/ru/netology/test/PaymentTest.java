package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentTest {

    @Test
    void shouldSuccessPurchase(){
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTicket();
        var cardInfo = DataHelper.getValidUser();
        purchasePage.sendForm(cardInfo);
        purchasePage.getConfirmation();
    }
    @Test
    void shouldPayCredit(){
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTicketOnCredit();
        var cardInfo = DataHelper.getValidUser();
        purchasePage.sendForm(cardInfo);
        purchasePage.getConfirmation();
    }

    @Test
    void shouldFailPayment(){
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTicket();
        var cardInfo = DataHelper.getInvalidUser();
        purchasePage.sendForm(cardInfo);
        purchasePage.getConfirmation();
    }
}