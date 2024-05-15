
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerIF extends Remote {
	ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException;
	ArrayList<Course> getAllCourseData() throws RemoteException;
	boolean registerInsuranceProduct(String string) throws RemoteException;
}
