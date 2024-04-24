package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.PositionDao;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PositionImpl extends UnicastRemoteObject implements PositionDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public PositionImpl() throws RemoteException{
		em = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
	}
	
	@Override
	public boolean add(Position position) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(position);
			tx.commit();
			return true;
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();	
		}
		return false;
	}
	
	@Override
	public boolean update(Position position) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			em.merge(position);
			
			tx.commit();
			
			return true;
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean updateName(String id, String newName) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Position position = em.find(Position.class, id);
			if(position != null) {
				position.setName(newName);
				tx.commit();
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean delete(String id) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Position position = em.find(Position.class, id);
			em.remove(position);
			
			tx.commit();
			
			return true;
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Position findById(String id) throws RemoteException {
		return em.find(Position.class, id);
	}

	@Override
	public List<Position> findAll() throws RemoteException{
		return em.createNamedQuery("Position.findAll", Position.class).getResultList();
	}

	



	@Override
	public List<Position> findByName(String name) throws RemoteException {
		return em.createQuery("SELECT p FROM Position p WHERE p.name LIKE :name", Position.class)
				.setParameter("name", "%"+name+"%")
				.getResultList();
	}


	@Override
	public Position findByName2(String name) throws RemoteException {
		return em.createQuery("select p from Position p where p.name = :name", Position.class)
				.setParameter("name", name)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
	
	}
	
	
	@Override
	public List<Position> listPositions(String name, double salaryFrom, double salaryTo) throws RemoteException {
	    return em.createQuery("SELECT p FROM Position p WHERE p.name "
	    		+ "LIKE :name AND p.salary BETWEEN :salaryFrom AND :salaryTo ORDER BY p.name", Position.class)
	            .setParameter("name", "%" + name + "%")
	            .setParameter("salaryFrom", salaryFrom)
	            .setParameter("salaryTo", salaryTo)
	            .getResultList();
	}




}
