package com.example.shipment_model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipment_model.model.Shipment;
import com.example.shipment_model.repo.ShipmentRepo;

@Service
public class ShipmentService {
	@Autowired
	private ShipmentRepo shipRepo;

	public Shipment getShipmentByTn(String trackNo) {
		// TODO Auto-generated method stub
		return shipRepo.getShipmentByTn(trackNo);
	}

	public String deleteShip(Integer shipId) {
		// TODO Auto-generated method stub
		return shipRepo.deleteShip(shipId);
	}

	public String addShip(Shipment ship) {
		// TODO Auto-generated method stub
		return shipRepo.addShip(ship);
	}

	public String updateShip(Shipment ship) {
		// TODO Auto-generated method stub
		return shipRepo.addShip(ship);
	}

	public List<Shipment> getShipment() {
		// TODO Auto-generated method stub
		return shipRepo.getShipment();
	}

	public String addMulShip(List<Shipment> ship) {
		// TODO Auto-generated method stub
		return shipRepo.addMulShip(ship);
	}

}
