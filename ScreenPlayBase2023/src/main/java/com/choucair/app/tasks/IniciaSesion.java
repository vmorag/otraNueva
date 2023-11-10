package com.choucair.app.tasks;

import com.choucair.app.models.LoginModel;
import com.choucair.moviles.libreria.interactions.choucair.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.choucair.app.userinterface.UILogin.*;

public class IniciaSesion implements Task {

    LoginModel loginData;

    public IniciaSesion(LoginModel loginData) {
        this.loginData = loginData;
    }

    public static IniciaSesion correctamente (LoginModel loginData){
        return Tasks.instrumented(IniciaSesion.class, loginData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Tap.siElElementoEsVisible(TEXT_ALERT),
                Enter.theValue(loginData.getUsuario()).into(USERNAME_TXT),
                Enter.theValue(loginData.getContrasena()).into(PASSWORD_TXT),
                Click.on(LOGIN_BTN)
        );
    }
}