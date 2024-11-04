package com.example.shipment_model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shipment_model.model.Message;
import com.example.shipment_model.model.Shipment;
import com.example.shipment_model.service.ShipmentService;

@RestController
public class ShipmentController {
	
	@Autowired
	private ShipmentService shipService;
	
	@GetMapping("/shipment")
	public ResponseEntity<?> getShipment(){
		List<Shipment> ship=shipService.getShipment();
		if(ship != null) {
			return ResponseEntity.ok(ship);
		}
		else {
			Message msg=new Message();
			msg.setMessage("could not able to fetch list of shipment records");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		}
	}
	
	
	
	@GetMapping("/shipment/{trackNo}")
	public ResponseEntity<Shipment> getShipmentByTn(@PathVariable String trackNo){
		Shipment ship=shipService.getShipmentByTn(trackNo);
		if(ship != null) {
			return ResponseEntity.ok(ship);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("shipment/{shipId}")
	public ResponseEntity<String> deleteShip(@PathVariable Integer shipId){
		String res=shipService.deleteShip(shipId);
		if(res != null) {
			return ResponseEntity.ok("The requested "+shipId+" got deleted");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not deleted");
		}
	}
	
	@PostMapping("/addShip")
	public ResponseEntity<String> addShip(@RequestBody Shipment ship){
		String shipment=shipService.addShip(ship);
		if(shipment != null) {
			return ResponseEntity.ok("The requested record added");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not deleted");
		}	
	}
	
	@PutMapping("/updateShip")
	public ResponseEntity<String> updateShip(@RequestBody Shipment ship){
		String shipment=shipService.updateShip(ship);
		if(shipment != null) {
			return ResponseEntity.ok("The requested record updated");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not updated");
		}	
	}
	
	@PostMapping("/addMulShip")
	public ResponseEntity<String> addMulShip(@RequestBody List<Shipment> ship){
		String shipment=shipService.addMulShip(ship);
		if(shipment != null) {
			return ResponseEntity.ok("The requested records got added");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not added");
		}	
	}
	
	@PostMapping
	public ResponseEntity<?> modifyTnSi(String trackNo,int shipId){
		Shipment ship=new Shipment();
		ship.setTrackNo(trackNo);
		ship.setShipId(shipId);
		String res=shipService.modifyTnSi(ship);
		return ResponseEntity.ok("changed");
	}
	
	

}
