package com.choucair.app.userinterface;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UILogin {

    public static final Target USERNAME_TXT = Target.the("Campo de texto username").located(AppiumBy.id("com.experitest.ExperiBank:id/usernameTextField"));

    public static final Target PASSWORD_TXT= Target.the("Campo de texto para el password").located(AppiumBy.id("com.experitest.ExperiBank:id/passwordTextField"));

    public static final Target LOGIN_BTN= Target.the("Botón para ingresar").located(AppiumBy.id("com.experitest.ExperiBank:id/loginButton"));

    public static final Target TEXT_ALERT= Target.the("Texto del home").located(AppiumBy.id("android:id/button1"));

    public static final Target LOGIN_SUCCESSFULL_TXT= Target.the("Logeo Exitoso").located(By.xpath("//*[@text='Your balance is: 100,00$']"));

}
