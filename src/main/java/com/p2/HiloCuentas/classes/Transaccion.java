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
    private Long id;

    private String origen;
    private String destino;
    private int monto;

    public Transaccion(String origen, String destino, int monto){
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    public String getDestino() {
        return destino;
    }

    public Long getId() {
        return id;
    }

    public int getMonto() {
        return monto;
    }

    public String getOrigen() {
        return origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    
}
