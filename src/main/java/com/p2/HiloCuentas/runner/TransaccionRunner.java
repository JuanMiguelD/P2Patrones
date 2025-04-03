package com.p2.HiloCuentas.runner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.p2.HiloCuentas.Repositories.CuentasRepository;
import com.p2.HiloCuentas.services.TransaccionService;

@Component
public class TransaccionRunner implements CommandLineRunner{
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
        System.out.println("iniciando ejecucion de hilos");
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        for(int i=0; i < 400; i++){
            executorService.submit(() ->{
                try {
                    transaccionService.transferir("abc", "", 50);
                    System.out.println("Transaccion exitosa");
                } catch (Exception e) {
                    System.out.println("Error en la transferencia");
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
        System.out.println("todos los hilos han finalizado ");
    }

}
