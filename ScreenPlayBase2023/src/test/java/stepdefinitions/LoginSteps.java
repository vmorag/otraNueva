package stepdefinitions;

import com.choucair.app.tasks.AbreLaApp;
import com.choucair.app.models.LoginModel;
import com.choucair.app.questions.LoginQuestion;
import com.choucair.app.tasks.IniciaSesion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginSteps {

    @Before
    public void setStage()
    {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que (.*) desea abrir la aplicacion eribank$")
    public void queDeseaabrirlaaplicacioneribank(String actor) {

        theActorCalled(actor).wasAbleTo(AbreLaApp.eribank());
    }

    @When("^se ingresan credenciales correctamente$")
    public void seIngresanCredencialesCorrectamente(DataTable data) {
        theActorInTheSpotlight().attemptsTo(IniciaSesion.correctamente(LoginModel.setData(data).get(0)));
    }

    @Then("^podremos visualizar la pantalla de home y ver nuestro balance (.*)$")
    public void podremosvisualizarlapantalladehomeyvernuestrobalance$(String mensaje) {
        theActorInTheSpotlight().should(seeThat(LoginQuestion.verifiedLogin(mensaje)));
    }
}