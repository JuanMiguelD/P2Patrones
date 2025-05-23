package com.p2.HiloCuentas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2.HiloCuentas.classes.Cuenta;

public interface CuentasRepository extends JpaRepository<Cuenta, Integer> {
    Cuenta findCuentaById(Integer id);
    Cuenta findCuentaByNombre(String nombre);
}
