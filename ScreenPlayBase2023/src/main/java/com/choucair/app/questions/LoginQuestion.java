package com.choucair.app.questions;

import com.choucair.app.userinterface.UILogin;
import com.choucair.moviles.libreria.interactions.choucair.TakeScreenshot;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class LoginQuestion implements Question <Boolean> {

    String mensaje;

    public LoginQuestion(String mensaje) {
        this.mensaje = mensaje;
    }

    public static LoginQuestion verifiedLogin(String mensaje) {
        return new LoginQuestion(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(UILogin.LOGIN_SUCCESSFULL_TXT, WebElementStateMatchers.isPresent()).forNoMoreThan(2).seconds(),
                TakeScreenshot.asEvidence()
        );
        return mensaje.equals(Text.of(UILogin.LOGIN_SUCCESSFULL_TXT).answeredBy(actor));
    }
}
