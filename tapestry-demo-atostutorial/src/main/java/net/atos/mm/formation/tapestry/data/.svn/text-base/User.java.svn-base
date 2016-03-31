/** 
 * AtosOrigin Multimedia
 */
/* <a-zone id="history"> */
/*
 * $Id: User.java,v 1.1 2009/11/23 14:53:55 a160688 Exp $
 * 
 * $Log: User.java,v $
 * Revision 1.1  2009/11/23 14:53:55  a160688
 * Added TP0 to restore the project when needed
 *
 * Revision 1.1  2008/06/17 15:25:38  fr25373
 * MAVENisation
 *
 * Revision 1.1  2007/12/26 14:50:35  a136316
 * Creation d'un projet Template Tapestry 5 pour la formation
 *
 * Revision 1.5  2005/08/31 08:47:31  cmortelette
 * Add admin rigths to the user
 *
 * Revision 1.4  2003/10/29 10:30:49  nkhadri
 * MAJ Tps FW3
 *
 * Revision 1.3  2003/10/24 16:13:55  cvandaele
 * update
 *
 * Revision 1.2  2003/10/24 13:47:21  cvandaele
 * regenerate formation sources
 *
 * Revision 1.1  2003/04/30 10:13:04  fniquet
 * initial
 *
 */
/* </a-zone> */

package net.atos.mm.formation.tapestry.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/* <a-zone id="imports"> */
/* </a-zone> */

/**
 * 
 * @version $Id: User.java,v 1.1 2009/11/23 14:53:55 a160688 Exp $
 */
public class User/* <a-zone id="extends"> *//* </a-zone> */implements
		java.io.Serializable/* <a-zone id="implements"> *//* </a-zone> */{

	/* <a-zone id="fields"> */
	/* </a-zone> */

	/**
	 * 
	 */
	private String login;

	/**
	 * 
	 */
	private String password;

	/**
	 * 
	 */
	private int age;

	/**
	 * 
	 */
	private String email;

	/**
	 * 
	 */
	private Locale locale;

	/**
	 * 
	 */
	private Collection portfolios = new ArrayList();

	/**
	 * 
	 */
	private boolean adminRigths = false;

	/**
	 * 
	 */
	private Collection actions = new ArrayList();

	private String photoPath;
	
	/**
	 * 
	 * 
	 */
	public User() {
		/* <a-zone id="User()"> *//* </a-zone> */

	}

	/**
	 * 
	 * 
	 * @param login
	 * @param password
	 */
	public User(String login, String password) {
		/* <a-zone id="User(String,String)"> */
		this.login = login;
		this.password = password;
		/* </a-zone> */

	}

	/* <a-zone id="constructors"> */
	/* </a-zone> */

	/**
	 * Set
	 * 
	 * @param login
	 *            the new value of
	 */
	public void setLogin(String login) {
		/* <a-zone id="setLogin(String)"> */
		this.login = login;
		/* </a-zone> */
	}

	/**
	 * Return
	 * 
	 * @return String
	 */
	public String getLogin() {
		/* <a-zone id="getLogin()"> */
		return this.login;
		/* </a-zone> */
	}

	/**
	 * Set
	 * 
	 * @param password
	 *            the new value of
	 */
	public void setPassword(String password) {
		/* <a-zone id="setPassword(String)"> */
		this.password = password;
		/* </a-zone> */
	}

	/**
	 * Return
	 * 
	 * @return String
	 */
	public String getPassword() {
		/* <a-zone id="getPassword()"> */
		return this.password;
		/* </a-zone> */
	}

	/**
	 * Set
	 * 
	 * @param age
	 *            the new value of
	 */
	public void setAge(int age) {
		/* <a-zone id="setAge(int)"> */
		this.age = age;
		/* </a-zone> */
	}

	/**
	 * Return
	 * 
	 * @return int
	 */
	public int getAge() {
		/* <a-zone id="getAge()"> */
		return this.age;
		/* </a-zone> */
	}

	/**
	 * Set
	 * 
	 * @param email
	 *            the new value of
	 */
	public void setEmail(String email) {
		/* <a-zone id="setEmail(String)"> */
		this.email = email;
		/* </a-zone> */
	}

	/**
	 * Return
	 * 
	 * @return String
	 */
	public String getEmail() {
		/* <a-zone id="getEmail()"> */
		return this.email;
		/* </a-zone> */
	}

	/**
	 * Set
	 * 
	 * @param locale
	 *            the new value of
	 */
	public void setLocale(Locale locale) {
		/* <a-zone id="setLocale(Locale)"> */
		this.locale = locale;
		/* </a-zone> */
	}

	/**
	 * Return
	 * 
	 * @return Locale
	 */
	public Locale getLocale() {
		/* <a-zone id="getLocale()"> */
		return this.locale;
		/* </a-zone> */
	}

	/**
	 * Set
	 * 
	 * @param portfolios
	 *            the new value of
	 */
	public void setPortfolios(Collection portfolios) {
		/* <a-zone id="setPortfolios(Collection)"> */
		this.portfolios = portfolios;
		/* </a-zone> */
	}

	/**
	 * Return
	 * 
	 * @return Collection
	 */
	public Collection getPortfolios() {
		/* <a-zone id="getPortfolios()"> */
		return this.portfolios;
		/* </a-zone> */
	}

	/**
	 * Set
	 * 
	 * @param adminRigths
	 *            the new value of
	 */
	public void setAdminRigths(boolean adminRigths) {
		/* <a-zone id="setAdminRigths(boolean)"> */
		this.adminRigths = adminRigths;
		/* </a-zone> */
	}

	/**
	 * Return
	 * 
	 * @return boolean
	 */
	public boolean getAdminRigths() {
		/* <a-zone id="getAdminRigths()"> */
		return this.adminRigths;
		/* </a-zone> */
	}

	/**
	 * Set
	 * 
	 * @param actions
	 *            the new value of
	 */
	public void setActions(Collection actions) {
		/* <a-zone id="setActions(Collection)"> */
		this.actions = actions;
		/* </a-zone> */
	}

	/**
	 * Return
	 * 
	 * @return Collection
	 */
	public Collection getActions() {
		/* <a-zone id="getActions()"> */
		return this.actions;
		/* </a-zone> */
	}
	/* <a-zone id="methods"> */
	/* </a-zone> */

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	
	
}
