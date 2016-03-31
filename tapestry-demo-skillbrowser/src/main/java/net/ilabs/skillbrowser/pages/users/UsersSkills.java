package net.ilabs.skillbrowser.pages.users;
 
import java.util.ArrayList;
import java.util.List;
 


import net.ilabs.skillbrowser.domain.model.Skill;
import net.ilabs.skillbrowser.domain.model.User;
import net.ilabs.skillbrowser.service.SkillManager;
import net.ilabs.skillbrowser.service.UserManager;
 


import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
 
public class UsersSkills {
 
	@Inject
	@Service("userManager")
	private UserManager userManager;
 
	@Inject
	@Service("skillManager")
	private SkillManager skillManager;
 
	@Inject
	private Block addSkillsBlock;
 
	@Component
	private Zone userSkillsZone;
 
	@Property
	private User user;
 
	@Property
	private Skill skill;
 
	public Block getAddSkillsBlock() {
		return addSkillsBlock;
	}
 
	public Zone getUserSkillsZone() {
		return userSkillsZone;
	}
 
	public List<Skill> getSkills() {
		return skillManager.findAll();
	}
 
	public List<Skill> getUserSkills() {
		return new ArrayList<Skill>(user.getSkills());
	}
 
	public void onActivate(Integer id) {
		user = userManager.findById(id);
	}
 
	public Integer onPassivate() {
		return user.getUserId();
	}
 
	public Block onActionFromAddSkills() {
		return addSkillsBlock;
	}
 
	public void onActionFromHideSkills() {
	}
 
	public Zone onActionFromAddSkill(Integer skillId) {
		user.addSkill(skillManager.findById(skillId));
		userManager.persist(user);
		return userSkillsZone;
	}
	
	/*
	public Zone onActionFromDeleteSkill(Integer skillId) {
		return onActionFromDeleteUserSkill(skillId);
	}*/
	
	public Zone onActionFromDeleteUserSkill(Integer skillId) {
		user.removeSkill(skillManager.findById(skillId));
		userManager.persist(user);
		return userSkillsZone;
	}
}