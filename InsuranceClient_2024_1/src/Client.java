
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Client {

	public static void main(String[] args) throws NotBoundException, IOException {
		ServerIF server;
		BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			server = (ServerIF) Naming.lookup("Server");
			while (true) {
				printMenu();
				String sChoise = objReader.readLine().trim();
				switch (sChoise) {
				case "1":
					registerInsuranceProduct(server, objReader);
					break;
				case "2":
					showList(server.getAllCourseData());
					break;
				case "x":
					return;
				default:
					System.out.println("Invalid Choice !!!");
				}
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private static void registerInsuranceProduct(ServerIF server, BufferedReader objReader) throws IOException, RemoteException {
		System.out.println("-----Product Information-----");
		System.out.print("Insurance Name: "); String insuranceName = objReader.readLine().trim();
		System.out.print("Insurance Type: "); String insuranceType = objReader.readLine().trim();
		System.out.print("Term Periodt: "); String termPeriod = objReader.readLine().trim();
		
		if(server.registerInsuranceProduct(insuranceName+" "+insuranceType+" "+termPeriod+" ")) System.out.println("SUCESS");
		else System.out.println("FAIL");
	}


	private static void printMenu() {
		System.out.println("*********************** MENU***********************");
		System.out.println("1. Register Insurance Product");
		System.out.println("2. Product Approval");
		System.out.println("x. Exit");
	}

	private static void showList(ArrayList<?> datalist) throws RemoteException {
		String list = "";
		for (int i = 0; i < datalist.size(); i++) {
			list += datalist.get(i) + "\n";
		}
		System.out.println(list);
	}

}
