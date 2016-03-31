package net.atos.mm.formation.tapestry.components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Response;

public class Photo {

	@Parameter(required = true)
	private String filePath;

	@Inject
	private ComponentResources resources;

	public String getPhotoLink() {
		return resources.createActionLink("action", false).toRedirectURI();
	}

	@OnEvent("action")
	public StreamResponse renderPhoto() {
		return new StreamResponse() {

			public String getContentType() {
				return "application/octet-stream";
			}

			public InputStream getStream() throws IOException {
				if (filePath != null) {
					File file = new File(filePath);

					if (file.exists()) {
						return new FileInputStream(file);
					} else {
						return null;
					}

				} else {
					return null;
				}
			}

			public void prepareResponse(Response response) {

			}

		};

	}
	
	public boolean getPhotoExists(){
		
		if(filePath == null){
			return false;
		}
		 
		File file = new File(filePath);
		if(file.exists()) {
			return true;
		}
		
		return false;
	}

}
