package com.app.calculadoraci;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class CalculadoraTest {


    @Test
    void calculadora_DeveCriarCalculadora(){
        var valor1 = 45.0;
        var valor2 = 5.6;

        var calculadora = new Calculadora(valor1, valor2);
        
        assertEquals(valor1, calculadora.getValor1());
        assertEquals(valor2, calculadora.getValor2());
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0", "2.0, 5.0", "3, 9"})
    void soma_deveSomarCorretamenteOsValores(double valor1, double valor2){
        var calculadora = new Calculadora(valor1, valor2);
        
        var resultadoDaSoma = calculadora.soma();

        assertEquals(valor1+valor2, resultadoDaSoma);
    }

    @ParameterizedTest
    @CsvSource({"1.0, -1", "-1.0, 0", "-1.0, -2.0"})
    void calculadora_aoCriarUmaCalculadoraOsValoresDevemSerMaioresQueZero(double valor1, double valor2) {
        assertThrows(CalculadoraException.class,  ()-> new Calculadora(valor1, valor2));
    }

    @ParameterizedTest
    @MethodSource("validandoCenarioNulos")
     void calculadora_aoCriarUmaCalculadoraOsValoresNaoDevemSerNulos(Double valor1, Double valor2) {
        assertThrows(CalculadoraException.class, () -> new Calculadora(valor1, valor2));
    }

    private static Stream<Arguments> validandoCenarioNulos() {
        return Stream.of(
            Arguments.of(null, 1.0),
            Arguments.of(1.0, null),
            Arguments.of(null, null)
        );
    }

}
