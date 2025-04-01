package com.p2.HiloCuentas.services;

import com.p2.HiloCuentas.Repositories.CuentasRepository;
import com.p2.HiloCuentas.Repositories.TransaccionRepository;
import com.p2.HiloCuentas.classes.Cuenta;
import com.p2.HiloCuentas.classes.Transaccion;

import jakarta.transaction.Transactional;

public class TransaccionService {

   private final CuentasRepository  cuentasRepository;
   private final TransaccionRepository transaccionRepository;

    public TransaccionService(CuentasRepository curepo, TransaccionRepository trarepo){
        this.cuentasRepository = curepo;
        this.transaccionRepository = trarepo;

    }

    @Transactional
    public synchronized void transferir(String origen, String destino, int monto){
        Cuenta cuentaOrigen = cuentasRepository.findCuentaById(origen);
        Cuenta cuentaDestino = cuentasRepository.findCuentaById(destino);

        if(cuentaOrigen.getMonto() > monto){
            cuentaOrigen.setMonto(cuentaOrigen.getMonto() - monto);
            cuentaDestino.setMonto(cuentaDestino.getMonto() + monto);

            cuentasRepository.save(cuentaOrigen);
            cuentasRepository.save(cuentaDestino);

            Transaccion transaccion = new Transaccion(origen,destino,monto);
            transaccionRepository.save(transaccion);

        }
    }
}
