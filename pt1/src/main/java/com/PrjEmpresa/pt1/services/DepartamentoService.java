package com.PrjEmpresa.pt1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.PrjEmpresa.pt1.entities.Departamento;
import com.PrjEmpresa.pt1.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
		
	private final DepartamentoRepository departamentoRepository;
		
		public DepartamentoService(DepartamentoRepository departamentoRepository) {
			this.departamentoRepository = departamentoRepository;
		}

		public Departamento savedepartamento(Departamento departamento) {
			return departamentoRepository.save(departamento);
		}
		
		public  List<Departamento> getAlldepartamento() {
			return departamentoRepository.findAll();
		}

		public Departamento getdepartamentoById(Long depcodigo) {
			return departamentoRepository.findById(depcodigo).orElse(null);
		}

		public void deletedepartamento(Long depcodigo) {
			departamentoRepository.deleteById(depcodigo);
		}

		public Departamento updatedepartamento(Long depcodigo, Departamento novodepartamento) {
			Optional<Departamento> departamentoOptional = departamentoRepository.findById(depcodigo);
			if (departamentoOptional.isPresent()) {
				Departamento departamentoExistente = departamentoOptional.get();
				departamentoExistente.setDepnome(novodepartamento.getDepnome());
				return departamentoRepository.save(departamentoExistente);
			} else {
				return null;
			}
		}

	}
