package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CandidateDao;
import entity.Candidate;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class CandidateImpl extends UnicastRemoteObject implements CandidateDao {
	
	private EntityManager em;
	
	public CandidateImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Map<Candidate, Long> listCandidatesByCompanies() throws RemoteException {
		 Map<Candidate, Long> candidateCompanyCountMap = new HashMap<>();
		    List<Candidate> candidates = em.createQuery("SELECT c FROM Candidate c", Candidate.class)
		                                   .getResultList();
		    for (Candidate candidate : candidates) {
		        long companyCount = em.createQuery("SELECT COUNT(DISTINCT e.companyname) FROM Experience e WHERE e.candidate = :candidate", Long.class)
		                              .setParameter("candidate", candidate)
		                              .getSingleResult();
		        candidateCompanyCountMap.put(candidate, companyCount);
		    }
		    return candidateCompanyCountMap;
	}


	@Override
	public Map<Candidate, Position> listCandidatesWithLongestWorking() throws RemoteException {
	    Map<Candidate, Position> candidatePositionMap = new HashMap<>();
	    List<Candidate> candidates = em.createQuery("SELECT DISTINCT e.candidate FROM Experience e", Candidate.class)
	                                   .getResultList();
	    for (Candidate candidate : candidates) {
	        Position longestWorkingPosition = em.createQuery("SELECT e.position FROM Experience e WHERE e.candidate = :candidate ORDER BY e.toDate - e.fromDate DESC", Position.class)
	                                           .setParameter("candidate", candidate)
	                                           .setMaxResults(1)
	                                           .getSingleResult();
	        candidatePositionMap.put(candidate, longestWorkingPosition);
	    }
	    return candidatePositionMap;
	}

}
