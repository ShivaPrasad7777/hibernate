package com.example.shipment_model.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.example.shipment_model.model.Shipment;

import jakarta.persistence.EntityManager;

@Repository
public class ShipmentRepo {
	
	private SessionFactory sf=new Configuration().configure().buildSessionFactory();

	public Shipment getShipmentByTn(String trackNo) {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Shipment ship= session.createNativeQuery("select * from Shipment where trackNo = :trackNo",Shipment.class).setParameter("trackNo", trackNo).uniqueResult();
		tr.commit();
		return ship;
		

	}

	public String deleteShip(Integer shipId) {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Shipment ship=session.get(Shipment.class, shipId);
		if(ship != null) {
			session.delete(ship);
			tr.commit();
			return "deleted";
		}else {
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public String addShip(Shipment ship) {
		// TODO Auto-generated method stub
		try {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(ship);
		tr.commit();
		return "added";
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Shipment> getShipment() {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		List<Shipment> list=session.createNativeQuery("SELECT * FROM Shipment",Shipment.class).getResultList();
		tr.commit();
		return list;
	}

	public String addMulShip(List<Shipment> ship) {
		// TODO Auto-generated method stub
		try {
			
			Session session=sf.openSession();
			Transaction tr=session.beginTransaction();
			for(Shipment ships : ship) {
			session.saveOrUpdate(ships);
			}
			tr.commit();
			return "added";
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		
	}
	
	
	
	

}
