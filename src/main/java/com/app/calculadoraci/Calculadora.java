package com.app.calculadoraci;

public class Calculadora {

    private Double valor1;
    private Double valor2;

    public Double getValor1() {
        return valor1;
    }

    public Double getValor2() {
        return valor2;
    }

    public Calculadora(Double valor1, Double valor2) {
        if (valor1 == null || valor2 == null) {
            throw new CalculadoraException("Os valores não podem ser nulos");
        }
        if (valor1 < 0 || valor2 < 0) {
            throw new CalculadoraException("Os valores devem ser maiores que zero");
        }
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public Double soma() {
        return valor1 + valor2;
    }

}
