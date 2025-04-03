package com.p2.HiloCuentas.services;

import org.springframework.stereotype.Service;

import com.p2.HiloCuentas.Repositories.CuentasRepository;
import com.p2.HiloCuentas.Repositories.TransaccionRepository;
import com.p2.HiloCuentas.classes.Cuenta;
import com.p2.HiloCuentas.classes.Transaccion;

import jakarta.transaction.Transactional;


@Service
public class TransaccionService {

   private final CuentasRepository  cuentasRepository;
   private final TransaccionRepository transaccionRepository;

    public TransaccionService(CuentasRepository curepo, TransaccionRepository trarepo){
        this.cuentasRepository = curepo;
        this.transaccionRepository = trarepo;

    }

    @Transactional
    public synchronized void transferir(String origen, String destino, int monto){
        Cuenta cuentaOrigen = cuentasRepository.findCuentaByNombre(origen);
        Cuenta cuentaDestino = cuentasRepository.findCuentaByNombre(destino);

        if (cuentaOrigen == null || cuentaDestino == null) {
            throw new IllegalArgumentException("Una o ambas cuentas no existen.");
        }

        if(cuentaOrigen.getMonto() >= monto){
            cuentaOrigen.setMonto(cuentaOrigen.getMonto() - monto);
            cuentaDestino.setMonto(cuentaDestino.getMonto() + monto);

            cuentasRepository.save(cuentaOrigen);
            cuentasRepository.save(cuentaDestino);

            System.out.println("se ha realizado la transferencia");
            Transaccion transaccion = new Transaccion(cuentaOrigen.getId(),cuentaDestino.getId(),monto);
            transaccionRepository.save(transaccion);
        }else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

    }
}
