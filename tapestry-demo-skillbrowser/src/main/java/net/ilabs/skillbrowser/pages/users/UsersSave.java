package net.ilabs.skillbrowser.pages.users;
 
import net.ilabs.skillbrowser.domain.model.User;
import net.ilabs.skillbrowser.service.UserManager;
 

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.dao.DataIntegrityViolationException;
 
public class UsersSave {
 
	@Inject
	private UserManager userManager;
 
	@Component(id = "add_user_form")
	private Form addUserForm;
 
	@Component
	private TextField userLogin;
 
	@Property
	private User user;
 
	public void onActivate() {
		user = new User();
	}
 
	public Boolean onActivate(Integer id) {
		user = userManager.findById(id);
		if(null == user) {
			return false;
		}
		return true;
	}
 
	public Integer onPassivate() {
		return (user != null) ? user.getUserId() : null;
	}
 
	public String onSuccess() {
		try {
			userManager.persist(user);
		} catch (DataIntegrityViolationException dive) {
			addUserForm.recordError(userLogin, dive.getMostSpecificCause().getMessage());
			return null;
		}
 
		return "users/UsersIndex";
	}
 
	// Necessary cause ValidationTrackers are stored into session and so record
	// errors would not be cleaned automatically
	void cleanupRender() {
		addUserForm.clearErrors();
	}
 
}