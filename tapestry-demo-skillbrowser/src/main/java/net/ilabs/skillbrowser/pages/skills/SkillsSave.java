package net.ilabs.skillbrowser.pages.skills;
 
import net.ilabs.skillbrowser.domain.model.Skill;
import net.ilabs.skillbrowser.service.SkillManager;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.dao.DataIntegrityViolationException;
 
public class SkillsSave {
 
	@Inject
	private SkillManager skillManager;
 
	@Component(id = "add_skill_form")
	private Form addSkillForm;
 
	@Component
	private TextField skillName;
 
	@Property
	private Skill skill;
 
	public void onActivate() {
		skill = new Skill();
	}
 
	public Boolean onActivate(Integer id) {
		skill = skillManager.findById(id);
		if(null == skill) {
			return false;
		}
		return true;
	}
 
	public Integer onPassivate() {
		return (skill != null) ? skill.getSkillId() : null;
	}
 
	public String onSuccess() {
		try {
			skillManager.persist(skill);
		} catch (DataIntegrityViolationException dive) {
			addSkillForm.recordError(skillName, dive.getMostSpecificCause().getMessage());
			return null;
		} catch (Exception e) {
			addSkillForm.recordError(skillName, e.getMessage());
			return null;
		}
 
		return "skills/SkillsIndex";
	}
 
	// Necessary cause ValidationTrackers are stored into session and so record
	// errors would not be cleaned automatically
	void cleanupRender() {
		addSkillForm.clearErrors();
	}
 
}