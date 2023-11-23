package com.PrjEmpresa.pt1.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PrjEmpresa.pt1.entities.Funcionario;
import com.PrjEmpresa.pt1.services.FuncionarioService;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioControler {
		
		private FuncionarioService service;

		public FuncionarioControler(FuncionarioService service) {
			this.service = service;
		}

		@PostMapping
		public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
			return service.savefuncionario(funcionario);
		}
		
		@GetMapping("/home")
				public String paginalnicial () {
				return "index";
	}

		@GetMapping("/{id}")
		public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long id) {
			Funcionario funcionario = service.getfuncionarioById(id);
			if (funcionario != null) {
				return ResponseEntity.ok(funcionario);
			} else {
				return ResponseEntity.notFound().build();
			}

		}

		@DeleteMapping("/{id}")
		public void deleteProduto(@PathVariable Long id) {
			service.deletefuncionario(id);
		}
		

		@GetMapping
		public ResponseEntity<List<Funcionario>> getAllFuncionarios(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Funcionario> funcionarios = service.getAllfuncionario();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(funcionarios);
		}

		@PutMapping("/{id}")
		public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
			return service.updatefuncionario(id, funcionario);
		}

	}
