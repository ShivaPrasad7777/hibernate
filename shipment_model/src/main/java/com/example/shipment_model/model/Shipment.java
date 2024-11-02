package com.example.shipment_model.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shipment {
	@Id
	@Column(name = "shipId")
	private Integer shipId;
	private String trackNo;
	private String origin;
	private String destination;
	private String status;
	public Integer getShipId() {
		return shipId;
	}
	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}
	public String getTrackNo() {
		return trackNo;
	}
	public void setTrackNo(String trackNo) {
		this.trackNo = trackNo;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Shipment(Integer shipId, String trackNo, String origin, String destination, String status) {
		super();
		this.shipId = shipId;
		this.trackNo = trackNo;
		this.origin = origin;
		this.destination = destination;
		this.status = status;
	}
	public Shipment() {
		
	}
	

}
