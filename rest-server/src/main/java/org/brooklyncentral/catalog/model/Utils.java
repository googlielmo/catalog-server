package org.brooklyncentral.catalog.model;

import java.net.URL;

import org.apache.brooklyn.util.exceptions.Exceptions;

public class Utils {
	
    public static URL getGitHubUrl(URL u) {
        if (u.getHost().equals("github.com")) {
            URL resolvedUrl = null;
			try {
				resolvedUrl = new URL(u.getProtocol(), "raw.githubusercontent.com", u.getPort(), u.getFile());
			} catch (Exception e) {
	            Exceptions.propagateIfFatal(e);
	            throw Exceptions.propagate(new IllegalStateException("Unable to get GitHub URL " + u + ": " + e, e));
			}
            return resolvedUrl;
        }
		return u;
	}
}
