package com.conversor;

public class Principal {
    public static void main(String[] args) {

        ApiConsulta api = new ApiConsulta();
        Conversor conversor = new Conversor(api);
        MenuConversor menu = new MenuConversor(conversor);

        menu.iniciar();
        }
    }
