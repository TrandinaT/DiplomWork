package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.*;

public class PaymentTest {
    @BeforeEach
    void tearDown() {
        cleanDatabase();
    }

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
        purchasePage.getError();
    }

    @Test
    void incorrectCardNumberReceived() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTicket();
        var cardInfo = DataHelper.getIncorrectCardNumber();
        purchasePage.sendForm(cardInfo);
        purchasePage.getError();
    }

    @Test
    void theWrongMonthWasEntered() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTicket();
        var cardInfo = DataHelper.getWrongMonth();
        purchasePage.sendForm(cardInfo);
        purchasePage.getNotificationWrongValidityPeriod();
    }

    @Test
    void incorrectYearEntered() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTicket();
        var cardInfo = DataHelper.getWrongYear();
        purchasePage.sendForm(cardInfo);
        purchasePage.getNotificationWrongValidityPeriodInPast();
    }

    @Test
    void successfulPurchaseAndPreservationOfTheDatabase() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTicket();
        var cardInfo = DataHelper.getValidUser();
        purchasePage.sendForm(cardInfo);
        String expected = getOrderID();
        String actual = getTransactionID();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void acquisitionAndRetentionOfConfirmedStatus() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTicket();
        var cardInfo = DataHelper.getValidUser();
        purchasePage.sendForm(cardInfo);

        String expected = "APPROVED";
        String actual = getStatus();

        Assertions.assertEquals(expected, actual);
    }
}
