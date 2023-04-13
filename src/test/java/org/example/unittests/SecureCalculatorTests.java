package org.example.unittests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * El nuevo becario se ha encargado de programar una nueva calculadora para nuestro sistema de cobro en caja.
 * Antes de desplegarla en producción, nos han pedido verificar que cumple unos mínimos de calidad.
 * Debemos comprobar el correcto funcionamiento de la "calculadora segura" que nos ha proporcionado.
 * En caso de detectar comportamiento erróneo, arreglalo y comprueba que el test funciona correctamente.
 * En concreto, es necesario verificar la siguiente funcionalidad:
 * - En caso de intento de división entre 0, debe tirar ArithmeticException.
 * - Debe protegerse contra Overflows de forma correcta: por ejemplo la multiplicacion de dos numeros positivos nunca puede dar un numero negativo. En caso de overflow, tirar ArithmeticException.
 * - Debe generar numeros aleatorios de forma correcta, en el limite pedido
 * - Debe detectar correctamente cuando un numero es par y cuando un numero es impar
 * - Debe emitir mensajes de log si ha sido configurada para ello.
 */
public class SecureCalculatorTests {

    /**
     * Verify calculator is successfully created
     */
    @Test
    public void smokeTest(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertNotNull(calculator);
    }
    @Test
    void multTest(){
        SecureCalculator calculator=new SecureCalculator();
        //long r1= calculator.multiply(1231431231,523424);
        Assertions.assertThrows(ArithmeticException.class, ()->calculator.multiply(1231431231,523424));
    }
    @Test
    void divideTest(){
        SecureCalculator calculator=new SecureCalculator();
        //Optional<Long> r=calculator.divide(10,5);
        //Assertions.assertDoesNotThrow(()->calculator.divide(10,5));
        Assertions.assertThrows(ArithmeticException.class, ()->calculator.divide(10,0));
        //Assertions.assertEquals(2, r.get());
    }
    @Test
    void evenTest(){
        SecureCalculator calculator=new SecureCalculator();
        boolean result=calculator.isEven(0);
        Assertions.assertTrue(result);
    }
    @Test
    void oddTest(){
        SecureCalculator calculator=new SecureCalculator();
        boolean result=calculator.isOdd(134324141);
        Assertions.assertTrue(result);
    }
    @Test
    void modulusTest(){
        SecureCalculator calculator=new SecureCalculator();
        Assertions.assertThrows(ArithmeticException.class, ()->calculator.mod(1,0));
        int r=calculator.mod(5,2);
        Assertions.assertEquals(1,r);
    }
    @Test
    void randomTest(){
        SecureCalculator calculator=new SecureCalculator();
        List <Integer> list=new ArrayList<>();
        for (int i=0; i<1000; i++){
            int randomN=calculator.getRandomNumber();
            list.add(randomN);
            System.out.println(randomN);
        }
        for (int n: list){
            Assertions.assertNotEquals(0,n);
        }

    }
}
