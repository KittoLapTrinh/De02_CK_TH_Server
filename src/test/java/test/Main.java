package test;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.CandidateDao;
import dao.PositionDao;
import dao.impl.CandidateImpl;
import dao.impl.PositionImpl;
import entity.Candidate;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) throws RemoteException {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mssql");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
		tx.begin();
		tx.commit();
		
		PositionDao positionDao = new PositionImpl();
	    CandidateDao candidateDao = new CandidateImpl();
		////////////////////////////////////////////////////////
		
		
		
		// Them 1 Position
//		try {	
//			Position newPosition = new Position("P111", "Ensure the quality of our software products", "Join Calady Sumary", 25000, 5);
//			boolean success = positionDao.add(newPosition);
//			System.out.println(success ? "Them thanh cong" :"Them that bai");
//		}catch (Exception e) {
//			e.printStackTrace();
//		}    
		
		
		
	    ////////////////////////////////////////////////////
		// Xoa 1 Position theo ma
//		try {
//			String positionIdToDelete = "P111";
//			boolean success = positionDao.delete(positionIdToDelete);
//			System.out.println(success ? "Xoa thanh cong" : "Xoa that bai!");
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		/////////////////////////////////////////////////////////
		//Cap nhat 1 Position khi biet ma id
//		try {
//			Position positionToUpdate = positionDao.findById("P111");
//			if(positionDao != null) {
//				positionToUpdate.setDescription("Manage and support our network infrastructure");
//				positionToUpdate.setName("Kiet");
//				positionToUpdate.setNumber(2);
//				positionToUpdate.setSalary(30000);
//				boolean success = positionDao.update(positionToUpdate);
//				System.out.println(success ? "Cap nhat thanh cong" : "Cap nhat that bai!");
//			}else {
//				System.out.println("Khong tim thay ma ");
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		///////////////////////////////////////////////////////
		// Cap nhat name khi biet ma id
//		try {
//			String idToUpdate = "P111";
//			String newName = "Tuan Kiet";
//			boolean success = positionDao.updateName(idToUpdate, newName);
//			System.out.println(success ? "Cap nhat thanh cong" : "Cap nhat that bai");
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		////////////////////////////////////////////////////////
		
		//find name tuong doi
//		try {
//			String nameToSearch = "IT";
//			List<Position> positions = positionDao.findByName(nameToSearch);
//			System.out.println("Các vị trí có tên chứa \"" + nameToSearch + "\":");
//			for(Position position : positions) {
//				System.out.println(position.getName());
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	    
	    
	    /////////////////////////////////////////////
	    // Find name tuyet doi
	    try {
	    	String nameToSearch = "Tuan Kiet";
		    Position position = positionDao.findByName2(nameToSearch);
		    if(position != null) {
		    	System.out.println("Vi tri co ten \"" + nameToSearch + "\":");
		    	System.out.println("ID: " + position.getId());
                System.out.println("Description: " + position.getDescription());
                System.out.println("Salary: " + position.getSalary());
                System.out.println("Number: " + position.getNumber());
		    }else {
		    	System.out.println("Khong tim thay");
		    }
	    }catch (Exception e) {
	    	e.printStackTrace();
		}
	    
		
		
		///////////////////////////////////////////////////////
		
		
	    // Cau a
	    // Instantiate PositionDao and retrieve positions
//	    List<Position> positions = positionDao.listPositions("Software Engineer", 0, 20000);
//	    
//	    // Print the retrieved positions
//	    for (Position position : positions) {
//	        System.out.println(position);
//	    }
	    
	    
	    
	    /////////////////////////////////////////////////
	    //Cau b
	 // Test listCandidatesByCompanies()
//        System.out.println("Candidates by Companies:");
//        Map<Candidate, Long> candidatesByCompanies = candidateDao.listCandidatesByCompanies();
//        for (Map.Entry<Candidate, Long> entry : candidatesByCompanies.entrySet()) {
//            System.out.println(entry.getKey().getFullName() + ": " + entry.getValue() + " companies");
//        }
	    
	    
        
        ////////////////////////////////////////////
        //Cau c
	 // Test listCandidatesWithLongestWorking()
//	    CandidateDao candidateDao = new CandidateImpl();
//        System.out.println("\nCandidates with Longest Working:");
//        Map<Candidate, Position> candidatesWithLongestWorking = candidateDao.listCandidatesWithLongestWorking();
//        for (Map.Entry<Candidate, Position> entry : candidatesWithLongestWorking.entrySet()) {
//            System.out.println(entry.getKey().getFullName() + ": " + entry.getValue().getName());
//        }
	}


}
