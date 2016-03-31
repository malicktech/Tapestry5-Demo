package net.ilabs.skillbrowser.domain.dao.jpa;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.ilabs.skillbrowser.domain.dao.SkillDao;
import net.ilabs.skillbrowser.domain.model.Skill;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
 
/**
 * JPA implementation of the DAO for domain model class Skill.
 * 
 * @see net.ilabs.skillbrowser.domain.model.Skill
 * @author loic.frering
 */
@Repository("skillDao")
public class JpaSkillDao implements SkillDao {
 
	private static final Log log = LogFactory.getLog(JpaSkillDao.class);
 
	@PersistenceContext
	private EntityManager entityManager;
 
	/**
	 * {@inheritDoc}
	 */
	public void persist(Skill transientSkill) {
		log.debug("persisting Skill instance");
		try {
			entityManager.persist(transientSkill);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
		}
	}
 
	/**
	 * {@inheritDoc}
	 */
	public void remove(Skill persistentSkill) {
		log.debug("removing Skill instance");
		try {
			entityManager.remove(persistentSkill);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
		}
	}
 
	/**
	 * {@inheritDoc}
	 */
	public void remove(Integer skillId) {
		this.remove(this.findById(skillId));
	}
 
	/**
	 * {@inheritDoc}
	 */
	public Skill merge(Skill detachedSkill) {
		log.debug("merging Skill instance");
		try {
			Skill result = entityManager.merge(detachedSkill);
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
	public Skill findById(Integer id) {
		log.debug("getting Skill instance with id: " + id);
		try {
			Skill instance = entityManager.find(Skill.class, id);
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
	public Skill findByName(String name) {
		log.debug("getting Skill instance with name: " + name);
		try {
			Query query = entityManager.createQuery("select s from Skill s where s.name like :name");
			query.setParameter("name", name);
			Skill skill = (Skill) query.getSingleResult();
			log.debug("findByName successful");
			return skill;
		} catch (RuntimeException re) {
			log.error("findByName failed", re);
			return null;
		}
	}
 
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Skill> findAll() {
		log.debug("getting all Skill instances");
		try {
			Query query = entityManager.createQuery("select s from Skill s order by s.name asc");
			List<Skill> skillList = query.getResultList();
			log.debug("findAll successful");
			return skillList;
		} catch (RuntimeException re) {
			log.error("findAll failed", re);
			return new ArrayList<Skill>();
		}
	}
 
}