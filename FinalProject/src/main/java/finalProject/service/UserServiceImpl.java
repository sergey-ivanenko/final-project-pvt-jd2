package finalProject.service;

import finalProject.dao.RoleDao;
import finalProject.dao.UserDao;
import finalProject.model.Role;
import finalProject.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserServiceImpl implements UserService {
	
	private final UserDao dao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public void add(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleDao.getOne(1));
		user.setRoles(roles);
		dao.add(user);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User findByLogin(String login) {
		return dao.findByLogin(login);
	}

	@Override
	public void update(User user) {
		dao.update(user);
	}

	@Override
	public void delete(User user) {
		dao.delete(user);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> getAll() {
		return dao.getAll();
	}
}