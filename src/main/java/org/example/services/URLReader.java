package org.example.services;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLReader {
    private static final Logger LOGGER = Logger.getLogger(URLReader.class.getName());

    // Constructor privado para prevenir la instanciación
    private URLReader() {
        throw new IllegalStateException("Utility class");
    }

    public static void trust(String trustPath, String pwd) {
        File trustStoreFile = new File(trustPath);
        char[] trustStorePassword = pwd.toCharArray();

        // Utiliza try-with-resources para asegurar que el FileInputStream se cierre automáticamente
        try (FileInputStream fis = new FileInputStream(trustStoreFile)) {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(fis, trustStorePassword);

            TrustManagerFactory tmf = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);

            for (TrustManager t : tmf.getTrustManagers()) {
                LOGGER.log(Level.INFO, "TrustManager: {0}", t.toString());
            }

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);
        } catch (IOException | NoSuchAlgorithmException | CertificateException |
                 KeyManagementException | KeyStoreException ex) {
            LOGGER.log(Level.SEVERE, "Error setting up SSLContext", ex);
        }
    }

    public static void readURL(String urlstr) throws Exception {
        URL siteURL = new URL(urlstr);
        URLConnection urlConnection = siteURL.openConnection();
        Map<String, List<String>> headers = urlConnection.getHeaderFields();
        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet) {
            String headerName = entry.getKey();
            if (headerName != null) {
                LOGGER.log(Level.INFO, "{0}:{1}", new Object[]{headerName, entry.getValue()});
            }
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                LOGGER.log(Level.INFO, inputLine);
            }
        } catch (IOException x) {
            LOGGER.log(Level.SEVERE, "Error reading from URL", x);
        }
    }
}
