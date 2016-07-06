package httpsssltls;

import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/**
 * Created by cloud on 2016/7/6 17:54.
 * mail：1032863320@qq.com
 */
public class Httpstest {

    private final CertificateFactory mCertificateFactory;

    public Httpstest() throws CertificateException {
        mCertificateFactory = CertificateFactory.getInstance("X.509");
    }
}
