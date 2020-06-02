package br.com.tt.petshop.util;

import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class CpfValidator {

    private static final Pattern CPF_COM_MASCARA =
            Pattern.compile("\\d{3}.\\d{3}.\\d{3}-\\d{2}");

    /**
     * 00011122233 - valido sem formatação
     * 000.111.222-3x3 - valido com formatação
     * 000.1111.22-33 - invalido (por causa da máscara inválida)
     */
    public boolean verificaSeCpfValido(String cpf){

        boolean valido = false;

        // Quantidade de dígitos
        if(cpf.length() == 11 && cpf.matches("\\d*")){
            valido = true;

            // Formatação (se houver)
        }if(cpf.length() == 14 && CPF_COM_MASCARA.matcher(cpf).matches()){
            valido = true;
        }

        //Se não cair em nenhum true, é inválido!
        return valido;
    }




}
