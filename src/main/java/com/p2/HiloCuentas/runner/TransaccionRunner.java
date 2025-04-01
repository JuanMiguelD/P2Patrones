package com.p2.HiloCuentas.runner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.p2.HiloCuentas.Repositories.CuentasRepository;
import com.p2.HiloCuentas.services.TransaccionService;

public class TransaccionRunner {
    private final CuentasRepository cuentasRepository;
    private final TransaccionService transaccionService;

    public TransaccionRunner(CuentasRepository curepo, TransaccionService traserv){
        this.cuentasRepository = curepo;
        this.transaccionService = traserv;
    }

    public void run(String... args) throws InterruptedException{
        ejecutarHilos();
    }

    public void ejecutarHilos() throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        for(int i=0; i < 30; i++){
            executorService.submit(() ->{
                try {
                    transaccionService.transferir("abc", "cbd", 5);
                } catch (Exception e) {
                    System.out.println("Error en la transferencia");
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
    }

    


}
