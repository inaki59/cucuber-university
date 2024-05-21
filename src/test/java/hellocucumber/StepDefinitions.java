package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.DayOfWeek;
import java.time.LocalDate;

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
     static String obtenerDiaSemanaActualEnIngles() {
        LocalDate hoy = LocalDate.now();
        DayOfWeek diaSemana = hoy.getDayOfWeek();
        String diaSemanaIngles;
        switch (diaSemana) {
            case MONDAY:
                diaSemanaIngles = "Monday";
                break;
            case TUESDAY:
                diaSemanaIngles = "Tuesday";
                break;
            case WEDNESDAY:
                diaSemanaIngles = "Wednesday";
                break;
            case THURSDAY:
                diaSemanaIngles = "Thursday";
                break;
            case FRIDAY:
                diaSemanaIngles = "Friday";
                break;
            case SATURDAY:
                diaSemanaIngles = "Saturday";
                break;
            case SUNDAY:
                diaSemanaIngles = "Sunday";
                break;
            default:
                diaSemanaIngles = "Día de la semana desconocido";
        }

        return diaSemanaIngles;
    }


}

public class StepDefinitions {

    private String today;
    private String actualAnswer;
    private String toRealDay;
    private String dayEspected;
    private Boolean same;
    @Given("{string} is {string}")
    public void isSameDays( String today) {
        this.today = today;
    }
    /*saturday*/

    @Given("today is {string}")
    public void todayIs(String todayEspected) {
        this.dayEspected = todayEspected;
    }

    @When("I ask whether its Friday yet")
    public void i_ask_whether_it_s_friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }
    @When("compare days")
    public void compareDays() {
        toRealDay= IsItFriday.obtenerDiaSemanaActualEnIngles();
    }


    @Then("I should be told realdays {string}")
    public void iShouldBeToldRealdays(String arg0) {
      assertEquals(toRealDay,dayEspected);
    }


    @Then("I should be told {string}")
    public void i_should_be_told(String expectAnswer) {
        assertEquals(expectAnswer, actualAnswer);
    }
}
