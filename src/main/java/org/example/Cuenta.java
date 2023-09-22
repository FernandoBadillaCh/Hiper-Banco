package org.example;

import java.util.Date;

public class Cuenta {

    private int numerodecuenta;
    private double saldo;
    private static int numerocuenta = 4710;
    private TipoCuenta tipo;
    private Transacciones[] movimientos;
    private Date fecha;

    //***********************************************************************Contructor***********************************************************************//
    public Cuenta(double saldo, TipoCuenta Tipo) {

        this.numerodecuenta = numerocuenta++;
        this.saldo = saldo;
        this.tipo = Tipo;
        this.movimientos = new Transacciones[50];
        this.fecha = new java.sql.Date(System.currentTimeMillis());

    }
    //*************************************************************************Metodos**************************************************************************//

    public int GetindexMovimientos() {
        for (int i = 0; i < 50; i++) {
            if (this.movimientos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void agregarTransaccion(Transacciones transaccion) {
        int index = GetindexMovimientos();
        this.movimientos[index] = transaccion;
    }

    public void RealizarCompraonline(Cuenta cuenta, String detalle, double monto) {

        Cuenta cuentaprovisional = cuenta;

        double montoanterior = cuentaprovisional.getSaldo();
        double montoactual = montoanterior - monto;
        cuentaprovisional.setSaldo(montoactual);

        Transacciones transaccion = new Transacciones(TipoTransaccion.Compra, monto, detalle);

        cuentaprovisional.agregarTransaccion(transaccion);

    }

    public void RealizarDepositoRetiro(Cuenta cuenta, TipoTransaccion tipo, double monto) {

        Cuenta cuentaprovisional = cuenta;

        String detalle = "";

        if (tipo == tipo.Deposito) {

            detalle = "Deposito";
            double montoanterior = cuentaprovisional.getSaldo();
            double montoactual = montoanterior + monto;

            cuentaprovisional.setSaldo(montoactual);

        }
        if (tipo == tipo.Retiro) {

            detalle = "Retiro";
            double montoanterior = cuentaprovisional.getSaldo();
            double montoactual = montoanterior - monto;
            cuentaprovisional.setSaldo(montoactual);
        }

        Transacciones transaccion = new Transacciones(tipo, monto, detalle);

        cuentaprovisional.agregarTransaccion(transaccion);

    }

    public void RealizarTranferencia(Cuenta cuentaorigen, Cuenta cuentadestino, double monto) {

        double saldoCorigen = cuentaorigen.getSaldo();
        double saldoCdestino = cuentadestino.getSaldo();
        double saldoNuevoOrigen = saldoCorigen - monto;
        double saldoNuevodestino = saldoCdestino + monto;

        cuentaorigen.setSaldo(saldoNuevoOrigen);
        cuentadestino.setSaldo(saldoNuevodestino);

        Transacciones transaccionorigen = new Transacciones(TipoTransaccion.Transferencia, monto, "Transferencia; Cuenta destino " + cuentadestino.getNumerodecuenta() + "   por un monto de $" + monto);
        int numerotransaccion = transaccionorigen.getNumerodetransaccion();
        Transacciones transacciondestino = new Transacciones(TipoTransaccion.Transferencia, monto, "Tranferencia: Cuenta  " + cuentaorigen.getNumerodecuenta() + "   te ha pasado $" + monto, numerotransaccion);

        cuentaorigen.agregarTransaccion(transaccionorigen);
        cuentadestino.agregarTransaccion(transacciondestino);
    }

    public String mostrarTodasLasTransacciones() {
        String resultado = "Movimientos\n";
        for (int i = 0; i < GetindexMovimientos(); i++) {
            resultado += "Número de transaccion: " + movimientos[i].getNumerodetransaccion()
                    + ", Monto: " + movimientos[i].getMonto()
                    + ", Fecha: " + movimientos[i].getFecha()
                    + ", Tipo: " + movimientos[i].getTipotransaccion()
                    + ", Detalle: " + movimientos[i].getDetalle() + "\n";
        }
        return resultado;
    }

    //*******************************************************************Setters and Getters*******************************************************************//
    public Transacciones[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Transacciones[] movimientos) {
        this.movimientos = movimientos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumerodecuenta() {
        return numerodecuenta;
    }

    public void setNumerodecuenta(int numerodecuenta) {
        this.numerodecuenta = numerodecuenta;
    }

    public TipoCuenta getTipo() {
        return tipo;
    }

    public void setTipo(TipoCuenta tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
