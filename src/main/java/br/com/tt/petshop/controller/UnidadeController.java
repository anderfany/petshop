package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.dto.UnidadeEntradaDto;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class UnidadeController {

    private UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {

        this.unidadeService = unidadeService;
    }

    @RequestMapping("/admin/unidade/lista")
    public String getUnidadeLista(Model model) {

        List<UnidadeDto> unidades = unidadeService.listarUnidades();
        model.addAttribute("unidades", unidades);

        return "unidade_lista";
    }

    @RequestMapping("/admin/unidade/cadastro")
    public String getPaginaCadastro(){

        return "unidade_cadastro";
    }

    @RequestMapping("/admin/unidade/acaoCadastrar")
    public ModelAndView acaoCadastrar(@RequestParam("nome")     String nome,
                                      @RequestParam("endereco") String endereco) {

        UnidadeEntradaDto unidadeDto = new UnidadeEntradaDto(nome, endereco);
        unidadeService.criarUnidade(unidadeDto);

        return new ModelAndView("unidade_cadastro");
    }

}
