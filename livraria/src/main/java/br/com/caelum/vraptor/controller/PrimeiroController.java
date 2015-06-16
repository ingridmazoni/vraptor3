package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class PrimeiroController {

    @Inject private Result result;

    @Get("/home")
    public void home() {
        result.include("mensagem", "Olá, VRaptor 4!");
    }
}