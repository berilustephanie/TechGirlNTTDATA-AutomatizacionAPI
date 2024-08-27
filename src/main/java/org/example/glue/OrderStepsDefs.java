package org.example.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.example.steps.OrderStep;

public class OrderStepsDefs {

    @Steps
    OrderStep orderStep;

    @When("Creo la orden con el id {int}, petId {int}, quantity {int}")
    public void crearOrden(Integer id, Integer petId, Integer quantity){
        orderStep.crearOrden(id, petId, quantity);
    }

    @When("Obtengo la orden con el id {int}")
    public void obtenerOrden(Integer id){
        orderStep.obtenerOrden(id);
    }

    @Then("el código de respuesta es {int}")
    public void codigoRespuesta(int statucCode){
        orderStep.validarCodigoRespuesta(statucCode);
    }

    @And("el status es {string}")
    public void status(String status){
        orderStep.validarStatus(status);
    }
}
