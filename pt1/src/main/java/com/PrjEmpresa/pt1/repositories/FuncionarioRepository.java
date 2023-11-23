package com.PrjEmpresa.pt1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PrjEmpresa.pt1.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
}