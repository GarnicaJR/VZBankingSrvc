package com.vz.banking.util;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.net.URL;
import java.security.*;

public class SSLUtil {

    public static void loadCertificate() throws Exception {

        URL resource = SSLUtil.class.getResource("/banco.jks");

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(resource.openStream(),"changeit".toCharArray());

        // 2. Initialize KeyManagerFactory with the keystore (for client auth)
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, "changeit".toCharArray()); // Use same password for keystore and private key

        // 3. Initialize TrustManagerFactory (for server trust)
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore); // You can load a truststore if separate

        // 4. Create SSLContext with KeyManagers (for client cert) and TrustManagers (for server cert verification)
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }
}
