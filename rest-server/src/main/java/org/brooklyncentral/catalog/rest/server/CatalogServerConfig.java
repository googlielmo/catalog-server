package org.brooklyncentral.catalog.rest.server;

import javax.servlet.ServletContext;

import org.eclipse.jetty.servlet.ServletContextHandler;

public class CatalogServerConfig {

	// http://github.com/brooklyncentral/public-catalog-data/
    public static String DEFAULT_REPOSITORIES_URL = "https://raw.githubusercontent.com/mikezaccardo/brooklyn-community-catalog-test/master/repositories.yml";
    String repositoriesUrl;
    
    public static CatalogServerConfig newDefault() {
        CatalogServerConfig result = new CatalogServerConfig();
        result.setRepositoriesUrl(DEFAULT_REPOSITORIES_URL);
        return result;
    }
    
    public void setRepositoriesUrl(String repositoriesUrl) {
        this.repositoriesUrl = repositoriesUrl;
    }

    public String getRepositoriesUrl() {
        return repositoriesUrl;
    }

    public static void apply(ServletContextHandler context, CatalogServerConfig serverConfig) {
        context.setAttribute(CatalogServerConfig.class.getName(), serverConfig);
    }
    
    public static CatalogServerConfig retrieve(ServletContext context) {
        CatalogServerConfig result = (CatalogServerConfig)context.getAttribute(CatalogServerConfig.class.getName());
        if (result==null) result=newDefault();
        return result;
    }
    
}
