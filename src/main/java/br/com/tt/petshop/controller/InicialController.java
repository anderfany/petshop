package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class InicialController {



    @RequestMapping("/admin")
    public String getPaginaInicial(){

        return "pagina_inicial";
    }




}
