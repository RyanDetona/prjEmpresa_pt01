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

import com.PrjEmpresa.pt1.entities.Departamento;
import com.PrjEmpresa.pt1.services.DepartamentoService;


@RestController
@RequestMapping("/departamento")
public class DepartamentoControler {
		
		private DepartamentoService service;

		public DepartamentoControler(DepartamentoService service) {
			this.service = service;
		}

		@PostMapping
		public Departamento createDepartamento(@RequestBody Departamento departamento) {
			return service.savedepartamento(departamento);
		}
		
		@GetMapping("/home")
				public String paginalnicial () {
				return "index";
	}

		@GetMapping("/{id}")
		public ResponseEntity<Departamento> getDepartamento(@PathVariable Long id) {
			Departamento departamento = service.getdepartamentoById(id);
			if (departamento != null) {
				return ResponseEntity.ok(departamento);
			} else {
				return ResponseEntity.notFound().build();
			}

		}

		@DeleteMapping("/{id}")
		public void deleteProduto(@PathVariable Long id) {
			service.deletedepartamento(id);
		}
		

		@GetMapping
		public ResponseEntity<List<Departamento>> getAllDepartamentos(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Departamento> departamentos = service.getAlldepartamento();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(departamentos);
		}

		@PutMapping("/{id}")
		public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
			return service.updatedepartamento(id, departamento);
		}

	}
