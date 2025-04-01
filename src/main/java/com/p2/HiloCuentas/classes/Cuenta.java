package com.p2.HiloCuentas.classes;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Cuenta{

    @Id
    private String id;
    private int monto;
    
    public Cuenta(String id, int monto){
        this.id = id;
        this.monto = monto;
    }

    public String getId(){
        return (this.id);
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
}
