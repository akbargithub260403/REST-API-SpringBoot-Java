package com.SpringBootRESTAPI;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BarangController {
	
	@Autowired
	public BarangServices services;
	
	@GetMapping("/Barang")
	public List<Barang> list(){
		return services.listAll();
	}
	
	@GetMapping("/Barang/{ID}")
	public ResponseEntity<Barang> get(@PathVariable Integer ID) {
		try {
			
			Barang barang = services.get(ID);
			
			return new ResponseEntity<Barang>(barang , HttpStatus.OK);
			
		}catch(NoSuchElementException e) {
			
			return new ResponseEntity<Barang>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/InsertBarang")
	public void add(@RequestBody Barang barang) {
		services.save(barang);
	}
	
	@PutMapping("/UpdateBarang/{ID}")
	public ResponseEntity<?> update(@RequestBody Barang barang , @PathVariable Integer ID){
		try {
			
			Barang produkSama 	= services.get(ID);
			services.save(barang);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException ERROR) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/DeleteBarang/{ID}")
	public void delete(@PathVariable Integer ID) {
		services.delete(ID);
	}
	
	
	
}
