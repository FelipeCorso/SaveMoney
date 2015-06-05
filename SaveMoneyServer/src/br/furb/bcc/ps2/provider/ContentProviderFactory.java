package br.furb.bcc.ps2.provider;

import java.util.ResourceBundle;

import br.furb.bcc.ps2.provider.db.DBProvider;
import br.furb.bcc.ps2.utils.constants.Constant;

public final class ContentProviderFactory {

    private static final ContentProviderFactory CONTENTPROVIDERFACTORY = new ContentProviderFactory();
    private static final String PROVIDER_PROPERTIES = "br.furb.bcc.ps2.provider.provider";

    public static ContentProviderFactory getInstance() {
	return CONTENTPROVIDERFACTORY;
    }

    public ContentProviderAbstract getContentProvider() {

	String dataSource = ResourceBundle.getBundle(PROVIDER_PROPERTIES).getString(Constant.DATA_SOURCE);

	ContentProviderAbstract contentProvider = null;
	if (dataSource.equals(ETypeContentProvider.DB.toString())) {
	    contentProvider = DBProvider.getInstance();
	}

	return contentProvider;
    }

}
