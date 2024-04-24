package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import dao.CandidateDao;
import dao.PositionDao;
import dao.impl.CandidateImpl;
import dao.impl.PositionImpl;
import entity.Position;



public class Server {
	private static final String URL = "rmi://TAMNHU:1545/";

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			PositionDao positionDao = new PositionImpl(); // Java Remote object
			CandidateDao candidateDao = new CandidateImpl(); // Java Remote object

			LocateRegistry.createRegistry(1545);
			context.bind(URL + "position", positionDao);
			context.bind(URL + "candidateDao", candidateDao);

			
			System.out.println("Server is running...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
