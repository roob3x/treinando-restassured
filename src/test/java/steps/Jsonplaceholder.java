package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import utils.RestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jsonplaceholder {

    String url = "";
    String endpoint = "";

    Map<String, Object> json = new HashMap<>();
    List<Map<String, Object>> listClientes = new ArrayList<Map<String, Object>>();
    Map<String, Object> cliente = new HashMap<>();
    Map<String, Object> clienteDois = new HashMap<>();
    RestUtils restUtils = new RestUtils();

    @Dado("que acesso a url {string} com o endpoint {string}")
    public void queAcessoAUrlComOEndpoint(String url, String endpoint) {
        // Write code here that turns the phrase above into concrete actions
       this.url = url;
       this.endpoint = endpoint;
    }

    @Quando("preencho campo {string} com {string} no objeto json")
    public void preenchoCampoComNoObjetoJson(String key, String value) {
        // Write code here that turns the phrase above into concrete actions
        json.put(key, value);

    }

    @Quando("preencho o campo {string} com {string} no objeto cliente")
    public void preenchoOCampoComNoObjetoCliente(String key, String value) {
        cliente.put(key, value);
    }

    @Quando("preencho o campo {string} com {string} no objeto clienteDois")
    public void preenchoOCampoComNoObjetoClienteDois(String key, String value) {
        clienteDois.put(key, value);
    }
    @Quando("adiciono o objeto  cliente na lista clientes")
    public void adicionoOObjetoClienteNaListaClientes() {
        // Write code here that turns the phrase above into concrete actions
        listClientes.add(cliente);
    }

    @Quando("adiciono o objeto clienteDois na lista clientes")
    public void adicionoOObjetoClienteDoisNaListaClientes() {
        listClientes.add(clienteDois);
    }

    @Quando("adiciono o campo {string} com lista clientes no objeto json")
    public void adicionoOCampoComListaClientesNoObjetoJson(String string) {
        json.put("cliente", listClientes);
    }

    @Quando("realizo a requisicao post")
    public void realizoARequisicaoPost() {
        restUtils.post(url, endpoint, json);

    }

    @Entao("valido que o campo {string} recebo o valor {string}")
    public void validoQueOCampoReceboOValor(String key, String value) {
        Assert.assertEquals(value,restUtils.key(key));
    }


}
