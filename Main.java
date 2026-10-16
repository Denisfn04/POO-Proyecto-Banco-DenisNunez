/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentabancaria;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== CUENTA BANCARIA ===");

        CuentaBancaria miCuenta = new CuentaBancaria(
                "001", "Maria Lopez", 2000
        );

        // miCuenta.saldo = 50000;
        // Da error porque saldo es private.

        System.out.println("Titular: " + miCuenta.titular);
        System.out.println("Numero: " + miCuenta.numeroCuenta);

        miCuenta.depositar(500);
        miCuenta.retirar(200);
        miCuenta.mostrarDatos();


        System.out.println("\n=== CUENTA DE AHORRO ===");

        CuentaAhorro ahorro = new CuentaAhorro(
                "002", "Carlos Perez", 3000, 5
        );

        ahorro.retirarConComision(100);
        ahorro.retirarConComision(100);
        ahorro.retirarConComision(100);
        ahorro.retirarConComision(100);

        ahorro.aplicarInteresMensual();

        System.out.println("Saldo final de ahorro: L. "
                + ahorro.getSaldo());


        System.out.println("\n=== CUENTA CORRIENTE ===");

        CuentaCorriente corriente = new CuentaCorriente(
                "003", "Ana Martinez", 1000,
                "Empresa ABC", 5000
        );

        corriente.retirarConSobregiro(3500);

        System.out.println("Saldo actual: L. "
                + corriente.getSaldo());

        System.out.println("Sobregiro utilizado: L. "
                + corriente.getSobregiroUtilizado());

        corriente.pagarSobregiro(1000);

        System.out.println("Saldo final: L. "
                + corriente.getSaldo());

        System.out.println("Deuda final: L. "
                + corriente.getSobregiroUtilizado());
    }
}
