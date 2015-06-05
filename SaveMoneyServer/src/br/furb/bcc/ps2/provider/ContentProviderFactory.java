package br.furb.bcc.ps2.provider;

import br.furb.bcc.ps2.provider.db.DBProvider;

public final class ContentProviderFactory {

    private static final ContentProviderFactory CONTENTPROVIDERFACTORY = new ContentProviderFactory();

    private ContentProviderFactory() {
	// TODO Auto-generated constructor stub
    }

    public static ContentProviderFactory getInstance() {
	return CONTENTPROVIDERFACTORY;
    }

    public ContentProviderAbstract getContentProvider() {
	// Lê de um arquivo.properties
	String typeProvider = "DB";

	ContentProviderAbstract contentProvider = null;
	if (typeProvider.equals(ETypeContentProvider.DB.toString())) {
	    contentProvider = DBProvider.getInstance();
	}

	return contentProvider;
    }

}
