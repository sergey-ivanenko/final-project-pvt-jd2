package finalProject.main;

import finalProject.dao.AdminDao;
import finalProject.dao.UserDao;
import finalProject.dao.ClientDao;
import finalProject.model.Admin;
import finalProject.model.Client;
import finalProject.model.Request;
import finalProject.model.Type;
import finalProject.model.User;
import finalProject.service.AdminService;
import finalProject.service.ClientService;
import finalProject.service.RequestService;
import finalProject.service.UserAbstractService;
import finalProject.service.UserService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LabourSystem {

	private static List<User> users;
	private List workerRequests;
	private List employerRequests;
	private User currentUser;

	public static void main(String[] args) {
		System.out.println("Hello, final progect!");

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		Client client1 = new Client("client1", "login_client1", "password_client1");
		Client client2 = new Client("client2", "login_client2", "password_client2");
		Client client3 = new Client("client3", "login_client3", "password_client3");

		Admin admin = context.getBean(Admin.class);

		Request request1 = new Request(client1, "Junior Java developer", 450, 40, Type.WORKER);
		Request request2 = new Request(client2, "Junior Java developer", 500, 40, Type.EMPLOYER);
		Request request3 = new Request(client1, "Middle Android developer", 1500, 38, Type.WORKER);
		Request request4 = new Request(client2, "QA", 1500, 38, Type.EMPLOYER);
		Request request5 = new Request(client3, "Senior Java developer", 2500, 40, Type.WORKER);

		client1.getRequests().add(request1);
		client1.getRequests().add(request3);
		client2.getRequests().add(request2);
		client2.getRequests().add(request4);
		client3.getRequests().add(request5);

		for (String s : context.getBeanDefinitionNames()) {
			System.out.println(s);
		}

		//UserDao clientDao = context.getBean(ClientDao.class);
		UserService clientService = context.getBean("clientService", UserService.class);
		//UserDao adminDao = context.getBean(AdminDao.class);
		UserService adminService = context.getBean("adminService", UserService.class);
		clientService.add(client1);
		clientService.add(client2);
		clientService.add(client3);

		System.out.println(client1);
		System.out.println(client2);
		System.out.println(client3);

		adminService.add(admin);
		User fUser = clientService.findUser("f", "fg");
		System.out.println(fUser);

		//User fAdmin = adminService.findUser("Login", "Password");
		//System.out.println(fAdmin);
		//adminDao.delete(fAdmin);
		users = clientService.getAll();
		for (User user : users) {
			System.out.println(user);
		}

		//RequestDao requestDao = context.getBean(RequestDao.class);
		//Request request = requestDao.findRequest(1);
		RequestService requestService = context.getBean(RequestService.class);
		Request request = requestService.findRequest(1);
		System.out.println(request);
		request.setJob("Middle Android developer");
		request.setPayment(1700);
		//requestDao.update(request);
		requestService.update(request);
		System.out.println(request);
	}

	private void addUser(String name, String login, String password, String repeation, Type type) {

	}

	private User findUser(String login, String password) {
		return null;
	}

	private void save() {
	}

	private void load() {
	}

	private void clearWorkerRequests(Client worker) {
	}

	private void processRequests() {
		// takeResult() класса Client вызывается тут,
		// чтобы сообщить пользователю об удовлетворении заявки 
	}
}
