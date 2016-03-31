package net.atos.mm.formation.tapestry.components;

import java.util.ArrayList;
import java.util.Collection;

import net.atos.mm.formation.tapestry.data.Action;
import net.atos.mm.formation.tapestry.data.User;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Menu {

	@Inject
	private ComponentResources resources;

	private User loggedUser;

	@Parameter(required = true)
	private Collection<Action> listOfActions;

	private String menuIndexPage;

	private Action currentAction;

	private ArrayList<Action> verifiedList;

	@SetupRender
	public void verifyActionsUrls() {

		verifiedList = new ArrayList<Action>();

		if (listOfActions != null) {
			for (Action action : listOfActions) {
				try {
					resources.createPageLink(action.getUrl(), true);
					verifiedList.add(action);
				} catch (Exception ex) {
					System.err.println(action.getUrl() + " doesn't exist");
					ex.printStackTrace(System.err);
				}
			}
		}
	}

	/**
	 * This method must be called on logout component action using the bubbling
	 * process.
	 */
	public void logout() {

		// Remove loggedUser from session
		System.out
				.println("Menu Component : Logged User has been removed from session...");
		System.out.println("Menu Component : Logout Event Completed...");

	}

	public Action getCurrentAction() {
		return currentAction;
	}

	public void setCurrentAction(Action currentAction) {
		this.currentAction = currentAction;
	}

	public ArrayList<Action> getVerifiedList() {
		return verifiedList;
	}

	public void setVerifiedList(ArrayList<Action> verifiedList) {
		this.verifiedList = verifiedList;
	}

}
