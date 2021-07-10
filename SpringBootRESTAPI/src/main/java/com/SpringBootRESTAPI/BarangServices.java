package com.SpringBootRESTAPI;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarangServices {
	
	
	@Autowired
	private BarangRepository repo;
	
	public List<Barang> listAll(){
		return repo.findAll();
	}
	
	public void save(Barang barang) {
		repo.save(barang);
	}
	
	public Barang get(Integer ID) {
		return repo.findById(ID).get();
	}
	
	public void delete(Integer ID) {
		repo.deleteById(ID);
	}
}
