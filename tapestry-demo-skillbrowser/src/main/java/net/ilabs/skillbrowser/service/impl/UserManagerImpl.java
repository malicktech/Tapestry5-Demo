package net.ilabs.skillbrowser.service.impl;
 
import java.util.List;

import net.ilabs.skillbrowser.domain.dao.UserDao;
import net.ilabs.skillbrowser.domain.model.User;
import net.ilabs.skillbrowser.service.UserManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
@Service("userManager")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserManagerImpl implements UserManager {
 
	@SuppressWarnings("unused")
	private final Log log = LogFactory.getLog(this.getClass());
 
	@Autowired
	private UserDao userDao;
 
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<User> findAll() {
		return userDao.findAll();
	}
 
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public User findByFullname(String fullname) {
		return userDao.findByFullname(fullname);
	}
 
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public User findById(Integer id) {
		return userDao.findById(id);
	}
 
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public User findByLogin(String login) {
		return userDao.findByLogin(login);
	}
 
	/**
	 * {@inheritDoc}
	 */
	public User merge(User detachedUser) {
		return userDao.merge(detachedUser);
	}
 
	/**
	 * {@inheritDoc}
	 */
	public void persist(User transientUser) {
		userDao.persist(merge(transientUser));
	}
 
	/**
	 * {@inheritDoc}
	 */
	public void remove(User persistentUser) {
		userDao.remove(merge(persistentUser));
	}
 
	/**
	 * {@inheritDoc}
	 */
	public void remove(Integer userId) {
		userDao.remove(userId);
	}
 
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<User> search(String searchString) {
		return userDao.search(searchString);
	}
 
}