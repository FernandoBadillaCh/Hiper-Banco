package org.example;

import java.util.Date;

public class Transacciones {

    private int numerodetransaccion;
    private TipoTransaccion tipotransaccion;
    private static int numerotransaccion = 10000;
    private double monto;
    private Date fecha;
    private String detalle;

    //*******************************************************************Contructor*******************************************************************//
    public Transacciones(TipoTransaccion tipotransaccion, double monto, String detalle) {
        this.tipotransaccion = tipotransaccion;
        this.numerodetransaccion = Transacciones.numerotransaccion++;
        this.monto = monto;
        this.fecha = new java.sql.Date(System.currentTimeMillis());
        this.detalle = detalle;
    }

    public Transacciones(TipoTransaccion tipotransaccion, double monto, String detalle, int numerotransaccion) {
        this.tipotransaccion = tipotransaccion;
        this.numerodetransaccion = numerotransaccion;
        this.monto = monto;
        this.fecha = new java.sql.Date(System.currentTimeMillis());
        this.detalle = detalle;
    }


    //*******************************************************************Setters and Getters*******************************************************************//
    public TipoTransaccion getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(TipoTransaccion tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public void setNumerodetransaccion(int numerotransaccion) {
        this.numerodetransaccion = numerotransaccion;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getNumerodetransaccion() {
        return numerodetransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    //*******************************************************************Metodos*******************************************************************//
}
