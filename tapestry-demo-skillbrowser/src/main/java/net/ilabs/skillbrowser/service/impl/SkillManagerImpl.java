package net.ilabs.skillbrowser.service.impl;
 
import java.util.List;

import net.ilabs.skillbrowser.domain.dao.SkillDao;
import net.ilabs.skillbrowser.domain.model.Skill;
import net.ilabs.skillbrowser.service.SkillManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
@Service("skillManager")
@Transactional (propagation = Propagation.REQUIRED, readOnly = false)
public class SkillManagerImpl implements SkillManager {
 
	@SuppressWarnings("unused")
	private final Log log = LogFactory.getLog(this.getClass());
 
	@Autowired
	private SkillDao skillDao;
 
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Skill> findAll() {
		return skillDao.findAll();
	}
 
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Skill findById(Integer id) {
		return skillDao.findById(id);
	}
 
	/**
	 * {@inheritDoc}
	 */
	public Skill findByName(String name) {
		return skillDao.findByName(name);
	}
 
	/**
	 * {@inheritDoc}
	 */
	public Skill merge(Skill detachedSkill) {
		return skillDao.merge(detachedSkill);
	}
 
	/**
	 * {@inheritDoc}
	 */
	public void persist(Skill transientSkill) {
		skillDao.persist(merge(transientSkill));
	}
 
	/**
	 * {@inheritDoc}
	 */
	public void remove(Skill persistentSkill) {
		skillDao.remove(skillDao.merge(persistentSkill));
	}
 
	/**
	 * {@inheritDoc}
	 */
	public void remove(Integer skillId) {
		skillDao.remove(skillId);
	}
 
}