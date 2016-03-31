package net.ilabs.skillbrowser.pages.users;
 
import java.util.List;

import net.ilabs.skillbrowser.domain.model.User;
import net.ilabs.skillbrowser.service.UserManager;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
 
public class UsersIndex {
 
	@Inject
	private UserManager userManager;
 
	@Property
	private User user;
 
	public List<User> getUserList() {
		return userManager.findAll();
	}
 
	public void onActionFromDeleteUser(Integer userId) {
		User user = userManager.findById(userId);
		userManager.remove(user);
	}
}