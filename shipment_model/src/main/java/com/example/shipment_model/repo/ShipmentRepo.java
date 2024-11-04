package com.example.shipment_model.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.example.shipment_model.model.Shipment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ShipmentRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	private SessionFactory sf=new Configuration().configure().buildSessionFactory();

	public Shipment getShipmentByTn(String trackNo) {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Shipment ship= session.createNativeQuery("select * from Shipment where trackNo = :trackNo",Shipment.class).setParameter("trackNo", trackNo).uniqueResult();
		tr.commit();
		return ship;
		

	}
//	@Transactional
//	public Shipment getShipmentByTn(String trackNo) {
//		return em.createQuery("from Shipment where trackNo = :trackNo",Shipment.class).setParameter("trackNo", trackNo).getSingleResult();
//	}


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
//	@Transactional
//	public String deleteShip(Integer shipId) {
//		
//			Shipment s=em.find(Shipment.class, shipId);
//			if(s != null) {
//				em.remove(s);
//				return "deleted";
//			}else {
//				return null;
//			}
//		
//		
//	}
	

	

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
	
//for ADD
//	@Transactional
//	public String addShip(Shipment ship) {
//		try {
//		em.persist(ship);
//		return "add";
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//for Update
//	@Transactional
//	public String addShip(Shipment ship) {
//		try {
//			em.merge(ship);
//			return "updated";
//		}catch(Exception e) {
//			return null;
//		}
//	}
	
	


	public List<Shipment> getShipment() {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		List<Shipment> list=session.createNativeQuery("SELECT * FROM Shipment",Shipment.class).getResultList();
		tr.commit();
		return list;
	}
//for getting all records
//	@Transactional
//	public List<Shipment> getShipment() {
//		return em.createQuery("from Shipment",Shipment.class).getResultList();
//	}

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


	public String modifyTnSi(Shipment ship) {
		// TODO Auto-generated method stub
		try{
			Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(ship); 
		return "Added";
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//for adding multiple records
//	@Transactional
//	public String addMulShip(List<Shipment> ship) {
//		for(Shipment ships:ship) {
//			em.persist(ships);
//			
//		}
//		return "added";
//	}

	
	
	
	

}
