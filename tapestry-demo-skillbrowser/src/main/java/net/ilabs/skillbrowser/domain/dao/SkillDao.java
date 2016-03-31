package net.ilabs.skillbrowser.domain.dao;
 
import java.util.List;
 
import net.ilabs.skillbrowser.domain.model.Skill;
 
/**
 * DAO for domain model class Skill.
 * 
 * @see net.ilabs.skillbrowser.domain.model.Skill
 * @author loic.frering
 */
public interface SkillDao {
 
	/**
	 * Persist a Skill entity in the database
	 * 
	 * @param transientSkill
	 */
	public void persist(Skill transientSkill);
 
	/**
	 * Remove a persisted Skill from the database
	 * 
	 * @param persistentSkill
	 */
	public void remove(Skill persistentSkill);
 
	/**
	 * Remove a persisted Skill from the database
	 * 
	 * @param persistentSkill
	 */
	public void remove(Integer skillId);
 
	/**
	 * Update a Skill in the database
	 * 
	 * @param detachedSkill
	 * @return merged Skill
	 */
	public Skill merge(Skill detachedSkill);
 
	/**
	 * Find a Skill by id
	 * 
	 * @param id
	 * @return the found Skill
	 */
	public Skill findById(Integer id);
 
	/**
	 * Find a Skill by name
	 * 
	 * @param id
	 * @return the found Skill
	 */
	public Skill findByName(String name);
 
	/**
	 * Find all Skills
	 * 
	 * @param id
	 * @return the found Skills
	 */
	public List<Skill> findAll();
}