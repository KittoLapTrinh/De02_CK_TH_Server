package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import entity.Position;

public interface PositionDao extends Remote {
	public boolean add(Position position) throws RemoteException;
	public boolean update(Position position) throws RemoteException;
	public boolean updateName(String id, String newName) throws RemoteException;
	public boolean delete(String id) throws RemoteException;
	public Position findById(String id) throws RemoteException;
	public List<Position> findAll() throws RemoteException;
	public List<Position> findByName(String name) throws RemoteException; //Tim tuong doi
	public Position findByName2(String name) throws RemoteException; //Tim tuyet doi
	List<Position> listPositions(String name, double salaryFrom, double salaryTo) throws RemoteException;
}
