package com.PrjEmpresa.pt1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.PrjEmpresa.pt1.entities.Funcionario;
import com.PrjEmpresa.pt1.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
		
	private final FuncionarioRepository funcionarioRepository;
		
		public FuncionarioService(FuncionarioRepository funcionarioRepository) {
			this.funcionarioRepository = funcionarioRepository;
		}

		public Funcionario savefuncionario(Funcionario funcionario) {
			return funcionarioRepository.save(funcionario);
		}
		
		public  List<Funcionario> getAllfuncionario() {
			return funcionarioRepository.findAll();
		}

		public Funcionario getfuncionarioById(Long funcodigo) {
			return funcionarioRepository.findById(funcodigo).orElse(null);
		}

		public void deletefuncionario(Long funcodigo) {
			funcionarioRepository.deleteById(funcodigo);
		}

		public Funcionario updatefuncionario(Long funcodigo, Funcionario novofuncionario) {
			Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funcodigo);
			if (funcionarioOptional.isPresent()) {
				Funcionario funcionarioExistente = funcionarioOptional.get();
				funcionarioExistente.setFunnome(novofuncionario.getFunnome());
				return funcionarioRepository.save(funcionarioExistente);
			} else {
				return null;
			}
		}

	}