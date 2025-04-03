package com.p2.HiloCuentas.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    private Integer origen;
    private Integer destino;
    private int monto;

    public Transaccion(Integer origen, Integer destino, int monto){
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    public Transaccion(){}

    public Integer getDestino() {
        return destino;
    }

    public Integer getId() {
        return id;
    }

    public int getMonto() {
        return monto;
    }

    public Integer getOrigen() {
        return origen;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    
}
