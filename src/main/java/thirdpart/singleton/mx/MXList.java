package thirdpart.singleton.mx;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;
import java.util.Vector;

public class MXList {

    private static MXList mxl = null;
    private Vector<MailServer> list;
    private static final String FACTORY_ENTRY = "java.naming.factory.initial";
    private static final String FACTORY_CLASS = "";
    private static final String PROVIDER_ENTRY = "";
    private static final String MX_TYPE = "MX";
    private String dnsUrl = null;
    private String domainName = null;

    private MXList() {

    }

    private MXList(String dnsUrl, String domainName) {
        this.dnsUrl = dnsUrl;
        this.domainName = domainName;
    }

    public static synchronized MXList getInstance(String dnsUrl, String domainName) {
        if (mxl == null) {
            mxl = new MXList(dnsUrl, domainName);
        }
        return mxl;
    }

    private Vector<MailServer> getMXRecords(String providerUrl, String domainName) throws NamingException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(FACTORY_ENTRY, FACTORY_CLASS);
        env.put(PROVIDER_ENTRY, providerUrl);

        DirContext dirContext = new InitialDirContext(env);

        Vector<MailServer> records = new Vector<>(10);

        Attributes attrs = dirContext.getAttributes(domainName, new String[]{MX_TYPE});

        for (NamingEnumeration en = attrs.getAll(); en != null && en.hasMoreElements(); ) {
            Attribute attr = (Attribute) en.next();
            NamingEnumeration e = attr.getAll();
        }
        return null;
    }

}