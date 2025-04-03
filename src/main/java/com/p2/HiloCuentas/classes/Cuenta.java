package com.p2.HiloCuentas.classes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre; 
    @Column(nullable = false)
    private int monto;
    
    public Cuenta(Integer id, String nombre, int monto) {
        this.id = id;
        this.nombre=nombre;
        this.monto = monto;
    }
    public Cuenta() {}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId(){
        return (this.id);
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
}
