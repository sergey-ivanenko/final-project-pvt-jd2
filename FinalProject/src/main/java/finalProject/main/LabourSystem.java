package finalProject.main;

import finalProject.dao.UserDao;
import finalProject.dao.UserDaoImpl;
import finalProject.model.Client;
import finalProject.model.User;
import java.util.List;

public class LabourSystem {
	private List<User> users;
	private List workerRequests;
	private List employerRequests;
	private User currentUser;
	
	public static void main( String[] args ) {
        System.out.println( "Hello, final progect!" );
		User user = new Client("s", "f", "fg");
		System.out.println(user.getName());
		System.out.println(user);
		UserDao userDao = new UserDaoImpl();
		userDao.add(user);
		
		User fUser = userDao.findUser("d", "fg");
		System.out.println(fUser);
    }
	
	private void addUser(String name, String login, String password, String repeation, int type) {
		
	}
	
	private User findUser(String login, String password) {
		return null;
	}
	
	private void save(){}
	private void load(){}
	private void clearWorkerRequests(Client worker){}
	private void processRequests() {
		// takeResult класса Client вызывается тут,
		// чтобы сообщить пользователю об удовлетворении заявки 
	}
}