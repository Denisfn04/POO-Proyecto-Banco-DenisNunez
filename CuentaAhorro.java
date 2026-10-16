/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentabancaria;


public class CuentaAhorro extends CuentaBancaria {

    public double tasaInteresAnual;

    private int retirosRealizadosMes;
    private double comisionPorExceso = 20.0;

    public CuentaAhorro(String numeroCuenta, String titular,
            double saldoInicial, double tasaInteresAnual) {

        super(numeroCuenta, titular, saldoInicial);

        this.tasaInteresAnual = tasaInteresAnual;
        this.retirosRealizadosMes = 0;
    }

    public void retirarConComision(double monto) {

        if (retirosRealizadosMes >= 3) {

            double montoTotal = monto + comisionPorExceso;

            if (retirar(montoTotal)) {
                retirosRealizadosMes++;

                System.out.println("Comision cobrada: L. "
                        + comisionPorExceso);
            }

        } else {

            if (retirar(monto)) {
                retirosRealizadosMes++;
            }
        }
    }

    public void aplicarInteresMensual() {

        double interes = (getSaldo()
                * (tasaInteresAnual / 100)) / 12;

        depositar(interes);

        System.out.println("Interes mensual: L. " + interes);
    }
}

