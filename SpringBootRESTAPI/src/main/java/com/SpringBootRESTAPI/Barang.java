package com.SpringBootRESTAPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Barang {
	
	private Integer ID;
	private String nama;
	private float harga;

	public Barang() {
		
	}

	public Barang(Integer iD, String nama, float harga) {
		ID = iD;
		this.nama = nama;
		this.harga = harga;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public float getHarga() {
		return harga;
	}

	public void setHarga(float harga) {
		this.harga = harga;
	}
}
