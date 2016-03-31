package net.ilabs.skillbrowser.domain.dao.jpa;
 
import java.util.ArrayList;
import java.util.List;
 


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 


import net.ilabs.skillbrowser.domain.dao.UserDao;
import net.ilabs.skillbrowser.domain.model.User;
 


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
 
/**
 * DAO for domain model class User.
 * 
 * @see net.ilabs.skillbrowser.domain.model.User
 * @author loic.frering
 */
@Repository("userDao")
public class JpaUserDao implements UserDao {
 
	private static final Log log = LogFactory.getLog(JpaUserDao.class);
 
	@PersistenceContext
	private EntityManager entityManager;
 
	/**
	 * {@inheritDoc}
	 */
	public void persist(User transientUser) {
		log.debug("persisting User instance");
		try {
			entityManager.persist(transientUser);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
		}
	}
 
	/**
	 * {@inheritDoc}
	 */
	public void remove(User persistentUser) {
		log.debug("removing User instance");
		try {
			entityManager.remove(persistentUser);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
		}
	}
 
	/**
	 * {@inheritDoc}
	 */
	public void remove(Integer userId) {
		this.remove(this.findById(userId));
	}
 
	/**
	 * {@inheritDoc}
	 */
	public User merge(User detachedUser) {
		log.debug("merging User instance");
		try {
			User result = entityManager.merge(detachedUser);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			return null;
		}
	}
 
	/**
	 * {@inheritDoc}
	 */
	public User findById(Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = entityManager.find(User.class, id);
			log.debug("findById successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("findById failed", re);
			return null;
		}
	}
 
	/**
	 * {@inheritDoc}
	 */
	public User findByLogin(String login) {
		log.debug("getting User instance with login: " + login);
		try {
			Query query = entityManager.createQuery("select u from User u where u.login like :login");
			query.setParameter("login", login);
			User user = (User) query.getSingleResult();
			log.debug("findByLogin successful");
			return user;
		} catch (RuntimeException re) {
			log.error("findByLogin failed", re);
			return null;
		}
	}
 
	/**
	 * {@inheritDoc}
	 */
	public User findByFullname(String fullname) {
		log.debug("getting User instance with fullname: " + fullname);
		try {
			Query query = entityManager.createQuery("select u from User u where u.fullname like :fullname");
			query.setParameter("fullname", fullname);
			User user = (User) query.getSingleResult();
			log.debug("findByFullname successful");
			return user;
		} catch (RuntimeException re) {
			log.error("findByFullname failed", re);
			return null;
		}
	}
 
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		log.debug("getting all User instances");
		try {
			Query query = entityManager.createQuery("select u from User u");
			List<User> userList = (List<User>) query.getResultList();
			log.debug("findAll successful");
			return userList;
		} catch (RuntimeException re) {
			log.error("findAll failed", re);
			return new ArrayList<User>();
		}
	}
 
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<User> search(String searchString) {
		log.debug("Search User instances with search string: " + searchString);
		try {
			Query query = entityManager.createQuery("select u from User u where u.login like :searchString or u.fullname like :searchString");
			query.setParameter("searchString", searchString);
			List<User> userList = (List<User>) query.getResultList();
			log.debug("search successful");
			return userList;
		} catch (RuntimeException re) {
			log.error("search failed", re);
			return new ArrayList<User>();
		}
	}
 
}