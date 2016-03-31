package net.atos.mm.formation.tapestry.services;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.Validator;
import org.apache.tapestry5.ioc.MessageFormatter;
import org.apache.tapestry5.services.FormSupport;
import org.apache.tapestry5.upload.services.UploadedFile;

public final class FileExtensionValidator implements
		Validator<String, UploadedFile> {

	public Class<String> getConstraintType() {
		return String.class;
	}

	public String getMessageKey() {
		return "extension-not-supported";
	}

	public Class<UploadedFile> getValueType() {
		return UploadedFile.class;
	}

	public boolean invokeIfBlank() {
		return false;
	}

	public void render(Field field, String constraintValue, MessageFormatter formatter, MarkupWriter writer, FormSupport formSupport) {
	}

	public void validate(Field field, String constraintValue,
			MessageFormatter formatter, UploadedFile value)
			throws ValidationException {

		boolean authorized = false;

		// Parse authorized extension
		String[] authorizedExt = constraintValue.split(":");

		// Verify if an extension matches
		for (String ext : authorizedExt) {
			if (value.getFileName().endsWith(ext)) {
				authorized = true;
				break;
			}
		}

		// If no extension matches throw a ValidationException
		if (!authorized) {
			throw new ValidationException(value.getFileName() + " : "+formatter.format());
		}

	}

	public boolean isRequired() {
		return false;
	}

}
