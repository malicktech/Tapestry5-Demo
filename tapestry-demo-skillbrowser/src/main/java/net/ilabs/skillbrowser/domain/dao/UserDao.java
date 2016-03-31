package net.ilabs.skillbrowser.domain.dao;
 
import java.util.List;
 
import net.ilabs.skillbrowser.domain.model.User;
 
/**
 * DAO for domain model class User.
 * 
 * @see net.ilabs.skillbrowser.domain.model.User
 * @author loic.frering
 */
public interface UserDao {
 
	/**
	 * Persist a User entity in the database
	 * 
	 * @param transientUser
	 */
	public void persist(User transientUser);
 
	/**
	 * Remove a persisted User from the database
	 * 
	 * @param persistentUser
	 */
	public void remove(User persistentUser);
 
	/**
	 * Remove a persisted User from the database
	 * 
	 * @param userId
	 */
	public void remove(Integer userId);
 
	/**
	 * Update a User in the database
	 * 
	 * @param detachedUser
	 * @return merged User
	 */
	public User merge(User detachedUser);
 
	/**
	 * Find a User by id
	 * 
	 * @param id
	 * @return the found User
	 */
	public User findById(Integer id);
 
	/**
	 * Find a User by login
	 * 
	 * @param login
	 * @return the found User
	 */
	public User findByLogin(String login);
 
	/**
	 * Find a User by fullname
	 * 
	 * @param fullname
	 * @return the found User
	 */
	public User findByFullname(String fullname);
 
	/**
	 * Find a User by his fullname
	 * 
	 * @return the found User
	 */
	public List<User> findAll();
 
	/**
	 * Search Users
	 * 
	 * @param searchString
	 * @return the found Users
	 */
	public List<User> search(String searchString);
 
}