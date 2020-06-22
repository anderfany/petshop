package br.com.tt.petshop.cliente;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component// ou @Service
public class CreditoRestTemplateClient {

    private final String URL_SERVICO_CREDITO = "https://imersao-credito-api.herokuapp.com";

    private final RestTemplate restTemplate;

    public CreditoRestTemplateClient(RestTemplate restTemplate,
                                     @Value("{app.servicos.url}") String creditoUrl){
        this.restTemplate = restTemplate;
    }
    /*
       Retorno esperado: {"situacao":"NEGATIVADO","pontos":-679}
    */
    public CreditoDto consultaSituacao(String cpf) {
        String url = String.format("%s/credito/%s", URL_SERVICO_CREDITO, cpf);
        return restTemplate.getForObject(url, CreditoDto.class);
    }
}
