package net.atos.mm.formation.tapestry.pages;

import java.io.File;

import net.atos.mm.formation.tapestry.data.User;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.upload.services.UploadedFile;

public class UploadPhoto {

	/**
	 * Used to stored the authenticated user after authentication or
	 * registration
	 */
	@SessionState
	private User loggedUser;

	/** Created by Tapestry to check if the loggedUser has been set in session */
	private boolean loggedUserExists;

	/** Used to store in session the number of validation error */
	private int count = 0;

	/** Used to add global error message on security checks */
	@Component(id = "uploadPhotoForm")
	private Form uploadPhotoForm;

	/** Used to get the upload file from user */
	private UploadedFile file;

	public UploadedFile getFile() {
		return this.file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	/**
	 * Used to verify if the upload feature must be disabled
	 * 
	 * @return true if the number of failed attempts exceeds 3, false otherwise
	 */
	public boolean getMaxAttemptsExceeded() {
		return count >= 3;
	}

	/**
	 * Used to verify during page activation, if the upload feature is available
	 */
	private void verifySecurityException() {
		// Add security check here
	}

	/**
	 * Used by the form on failure to increment the failure counter and get back
	 * to the input upload form if a validation error occures
	 * 
	 * @return The uploadPhoto page
	 */
	public Object countFailure() {
		return UploadPhoto.class;
	}

	/**
	 * Used to process upload on form submission and modify logged user if
	 * exists.
	 * 
	 * @return Main page on success, Index on failure
	 */
	@OnEvent(value = EventConstants.SUCCESS, component = "uploadPhotoForm")
	public Object uploadUserPhoto() {

		File copied = new File("E:/temp/" + file.getFileName());
		file.write(copied);

		if (loggedUserExists) {
			// Set photo path for the logged user
			loggedUser.setPhotoPath(copied.getPath());
			return Main.class;
		} else {
			return Login.class;
		}

	}

}
