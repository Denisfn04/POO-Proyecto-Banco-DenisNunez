
package com.mycompany.cuentabancaria;

/**
 *
 * @author ADMIN 2
 */


public class CuentaCorriente extends CuentaBancaria {

    public String nombreEmpresa;

    private double limiteSobregiro;
    private double sobregiroUtilizado;

    public CuentaCorriente(String numeroCuenta, String titular,
            double saldoInicial, String nombreEmpresa,
            double limiteSobregiro) {

        super(numeroCuenta, titular, saldoInicial);

        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return sobregiroUtilizado;
    }

    public void retirarConSobregiro(double monto) {

        if (monto <= 0) {
            System.out.println("Error: monto invalido.");
        } else if (getSaldo() >= monto) {

            retirar(monto);

        } else {

            double creditoNecesario = monto - getSaldo();
            double comision = creditoNecesario * 0.03;
            double deudaTotal = creditoNecesario + comision;

            if (deudaTotal <= limiteSobregiro - sobregiroUtilizado) {

                double saldoDisponible = getSaldo();

                if (saldoDisponible > 0) {
                    retirar(saldoDisponible);
                }

                sobregiroUtilizado = sobregiroUtilizado + deudaTotal;

                System.out.println("Retiro con sobregiro realizado.");
                System.out.println("Credito utilizado: L. "
                        + creditoNecesario);
                System.out.println("Cargo del 3%: L. " + comision);

            } else {
                System.out.println("Error: limite de sobregiro excedido.");
            }
        }
    }

    public void pagarSobregiro(double monto) {

        if (monto <= 0) {
            System.out.println("Error: monto invalido.");
        } else if (sobregiroUtilizado == 0) {

            depositar(monto);

        } else {

            if (monto >= sobregiroUtilizado) {

                double sobrante = monto - sobregiroUtilizado;

                sobregiroUtilizado = 0;

                if (sobrante > 0) {
                    depositar(sobrante);
                }

            } else {

                sobregiroUtilizado = sobregiroUtilizado - monto;
            }

            System.out.println("Pago de sobregiro realizado.");
            System.out.println("Deuda pendiente: L. "
                    + sobregiroUtilizado);
        }
    }
}
