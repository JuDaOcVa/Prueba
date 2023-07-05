package com.example.prueba.services.Impl;

import com.example.prueba.dto.Numerofelizdto;
import com.example.prueba.services.PruebaServices;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PruebasServicesImpl implements PruebaServices {

    @Override
    public String consultar(String numeros) {
        String[] sbNumeros = numeros.split(",");
        ArrayList<Numerofelizdto> numbers = new ArrayList<>();

        for (int j = 0; j < sbNumeros.length; j++) {
            Numerofelizdto numerofelizdto=new Numerofelizdto();
            int numero = Integer.parseInt(sbNumeros[j]);
            System.out.println("AGH"+numero);
            int nuNumeroOriginal = numero;
            String sbNumero;
            boolean bandera = false;
            int suma = 0;
            int contador = 0;
            do {
                contador++;
                bandera = false;
                sbNumero = String.valueOf(numero);
                System.out.println("SBAGH"+sbNumero);
                char[] digitos = sbNumero.toCharArray();
                suma = 0;
                int val;
                for (int i = 0; i < digitos.length; i++) {
                    val = Integer.parseInt(String.valueOf(digitos[i]));
                    System.out.println("VAL"+val);
                    suma += (Math.pow(val, 2));
                }
                System.out.println("sumatotalpornumero====>");
                System.out.println(suma);

                if (suma == 1) {
                    numerofelizdto.setNumber(String.valueOf(nuNumeroOriginal));
                    numerofelizdto.setIsHappy(true);
                    numbers.add(numerofelizdto);
                    bandera = true;
                } else if (suma == nuNumeroOriginal || contador == 8) {
                    numerofelizdto.setNumber(String.valueOf(nuNumeroOriginal));
                    numerofelizdto.setIsHappy(false);
                    numbers.add(numerofelizdto);
                    bandera = true;
                } else {
                    bandera = false;
                    numero = suma;
                }

                System.out.println("numero======>");
                System.out.println(numero);
            } while (bandera == false || contador > 8);
        }
        return numbers.toString();
    }
}
