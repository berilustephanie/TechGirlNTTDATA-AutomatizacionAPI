package org.example.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class OrderStep {

    private static final String baseUrl = "https://petstore.swagger.io/v2/";


    @Step("Crear una orden {0} en PetStore")
    public void crearOrden(int id, int petId, int quantity){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": \""+id+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \""+"2024-08-27T06:17:34.786Z"+"\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log()
                .all()
                .post(baseUrl+"store/order")
                .then()
                .log()
                .all();
    }

    @Step("Obtener una orden en PetStore")
    public void obtenerOrden(int id){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .get(baseUrl+"store/order/"+id)
                .then()
                .log()
                .all();
    }

    public void validarStatus(String status) {
        restAssuredThat(response -> response.body("'status'", equalTo(status)));
        System.out.println("status: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
}
