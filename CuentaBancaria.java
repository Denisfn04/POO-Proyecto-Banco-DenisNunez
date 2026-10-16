

package com.mycompany.cuentabancaria;

public class CuentaBancaria {

    public String numeroCuenta;
    public String titular;

    private double saldo;
    private int totalTransacciones;

    public CuentaBancaria(String numeroCuenta, String titular,
            double saldoInicial) {

        this.numeroCuenta = numeroCuenta;
        this.titular = titular;

        if (saldoInicial < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }

        totalTransacciones = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getTotalTransacciones() {
        return totalTransacciones;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo = saldo + monto;
            totalTransacciones++;
            System.out.println("Deposito realizado correctamente.");
        } else {
            System.out.println("Error: monto invalido.");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo = saldo - monto;
            totalTransacciones++;
            System.out.println("Retiro realizado correctamente.");
            return true;
        } else {
            System.out.println("Error: saldo insuficiente o monto invalido.");
            return false;
        }
    }

    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Saldo: L. " + saldo);
        System.out.println("Total de transacciones: "
                + totalTransacciones);
    }

    public static void main(String[] args) {

        System.out.println("=== CUENTA BANCARIA ===");

        CuentaBancaria miCuenta = new CuentaBancaria(
                "001", "Maria Lopez", 2000
        );

        // miCuenta.saldo = 50000;
        // Da error porque saldo es privado.

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
