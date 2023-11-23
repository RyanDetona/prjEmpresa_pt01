package com.PrjEmpresa.pt1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PrjEmpresa.pt1.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	
}
