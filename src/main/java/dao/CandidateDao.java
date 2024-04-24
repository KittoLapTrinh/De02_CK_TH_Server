package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import entity.Candidate;
import entity.Position;

public interface CandidateDao extends Remote {
	Map<Candidate, Long> listCandidatesByCompanies() throws RemoteException;
	Map<Candidate, Position> listCandidatesWithLongestWorking() throws RemoteException;

}
