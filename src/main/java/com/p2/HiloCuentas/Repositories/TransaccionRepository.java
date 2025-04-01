package com.p2.HiloCuentas.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.p2.HiloCuentas.classes.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
    
}
