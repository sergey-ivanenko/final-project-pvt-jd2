package finalProject.service;

import finalProject.dao.AdminDao;
import finalProject.model.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends UserAbstractService<Admin, AdminDao> {
	
	public AdminService(AdminDao adminDao) {
		super(adminDao);
	}
}
