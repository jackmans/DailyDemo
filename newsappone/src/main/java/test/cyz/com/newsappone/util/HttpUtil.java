package test.cyz.com.newsappone.util;

import android.net.UrlQuerySanitizer;
import android.net.sip.SipAudioCall;
import android.os.Message;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by M on 2016/11/24.
 */
public class HttpUtil {


    // https、 post、 信任所有证书
    public static void sendHttpsRequest(final String address, final String requestBody,  final HttpsCallbackListener listener){

        final int SHOW_RESPONSE = 0;

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpsURLConnection conne = null;
                try {
                    URL url = new URL(address);
                    SSLContext context = SSLContext.getInstance("TLS");
                    context.init(null, new TrustManager[]{new TrustAllManager()}, null);
                    HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
                    HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String s, SSLSession sslSession) {
                            return true;
                        }
                    });
                    conne = (HttpsURLConnection) url.openConnection();
                    conne.setConnectTimeout(3000);
                    conne.setDoInput(true);
                    conne.setDoOutput(true);
                    conne.setRequestMethod("POST");
                    conne.setUseCaches(false);
                    conne.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    DataOutputStream op = new DataOutputStream(conne.getOutputStream());
                    op.writeBytes(requestBody);
                    op.flush();
                    op.close();

                    InputStreamReader inReader = new InputStreamReader(conne.getInputStream());
                    BufferedReader buReader = new BufferedReader(inReader);
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = buReader.readLine()) != null) {
                        response.append(line);
                    }
                    if(listener != null){
                        listener.onFinish(response.toString());
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (KeyManagementException e) {
                    e.printStackTrace();
                }
                  catch (Exception e){
                      if(listener != null){
                          listener.onError(e);
                      }
                  }
                finally {
                    if(conne != null){
                        conne.disconnect();
                    }
                }

            }
        }).start();

    }

}
