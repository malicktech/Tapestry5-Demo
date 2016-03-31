package net.ilabs.skillbrowser.pages.skills;
 
import java.util.List;

import net.ilabs.skillbrowser.domain.model.Skill;
import net.ilabs.skillbrowser.service.SkillManager;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
 
public class SkillsIndex {
 
	@Inject
	private SkillManager skillManager;
 
	@Property
	private Skill skill;
 
	public List<Skill> getSkillList() {
		return skillManager.findAll();
	}
 
	public void onActionFromDeleteSkill(Integer skillId) {
		Skill skill = skillManager.findById(skillId);
		skillManager.remove(skill);
	}
}