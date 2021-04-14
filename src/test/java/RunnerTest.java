import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.RestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunnerTest {
    RestUtils restUtils = new RestUtils();

    @Test
    public void realizarGet() {

        restUtils.get("https://viacep.com.br/ws/", "54410470/json/");
        //String logradouro = response.getBody().jsonPath().get("logradouro");
        String logradouro = restUtils.key("logradouro");
        Assert.assertEquals("Rua Aracatu", logradouro);

    }

    @Test
    public void realizarPost() {
        String json = "{\"titulo:\": \"testeServicos\",\"cliente\": [{\"nome\": \"roberto\",\"idade\": \"28\"},{\"nome\": \"kelly\",\"idade\": \"33\" } ]}";
        restUtils.post("https://jsonplaceholder.typicode.com/","/posts",json);
        Assert.assertEquals("roberto",restUtils.key("cliente[0].nome"));
      //  for (String nome: restUtils.keyList("cliente")
        //     ) {
          //  System.out.println(nome);
        //}
        //https://jsonplaceholder.typicode.com/todos/1
    }

    @Test
    public void realizarPostMap() {
        Map<String, Object> json = new HashMap<>();
        List<Map<String, Object>> listClientes = new ArrayList<Map<String,Object>>();
        Map<String, Object> cliente = new HashMap<>();
        Map<String, Object> clienteDois = new HashMap<>();
        cliente.put("nome","roberto");
        cliente.put("idade","29");
        clienteDois.put("nome","kelly");
        clienteDois.put("idade","33");
        listClientes.add(cliente);
        listClientes.add(clienteDois);
        json.put("titulo","testeServicos");
        json.put("cliente",listClientes);

        restUtils.post("https://jsonplaceholder.typicode.com/","/posts",json);
        Assert.assertEquals("roberto",restUtils.key("cliente[0].nome"));
        Assert.assertEquals("kelly",restUtils.key("cliente[1].nome"));

        //https://jsonplaceholder.typicode.com/todos/1
    }

}
