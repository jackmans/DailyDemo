package test.cyz.com.testmodule;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

public class MainActivity extends AppCompatActivity {

    public static final int SHOW_RESPONSE = 0;

    //将获取到的新闻信息存在这里
    List<News> NewsArray = new ArrayList<News>();
    TextView text;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case SHOW_RESPONSE:
                    String response = (String) msg.obj;
                    text.setText(response);
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tv = (Button) findViewById(R.id.send);
        text = (TextView)findViewById(R.id.text);
        Log.d("test", "begin");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        requestForNews();

                Log.d("aaa", "执行完了");
            }
        });


    }

    private void requestForNews(){
        String address = "https://matthew-yao.com/chenyuanze.php";
        String body = "token=836b32ec64436f6fbc7c0a3d1c8bc17a";
        HttpUtil.sendHttpsRequest(address, body, new HttpsCallbackListener() {
            @Override
            public void onFinish(String response) {

                String result = response;
                text.setText(response);
                Log.d("aaa", result.toString());
                try {
//                    List<News> list = newsHandler(result);
//                    Message message = new Message();
//                    message.what = SHOW_RESPONSE;
//                    message.obj = result.toString();
//                    handler.sendMessage(message);
//                    Log.d("aaa", "发送到UI线程");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    private List<News> newsHandler(String result) throws JSONException {

        JSONArray jsonArray = new JSONArray(result);
        for (int i=0; i <jsonArray.length(); i++ ){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String title = (String) jsonObject.get("title");
            String content = jsonObject.getString("content");
            String author = jsonObject.getString("author");
            Date date = (Date) jsonObject.get("date");
            News newsItem = new News(author, content, date, title);
            NewsArray.add(newsItem);
        }
        return NewsArray;
    }

//    private String getSpecNews() throws MalformedURLException {
//        String result = null;
//        URL url = new URL("https://matthew-yao.com/chenyuanze.php");
//        InputStreamReader in = null;
//
//        try {
//            SSLContext sc = SSLContext.getInstance("TLS");
//            sc.init(null, new TrustManager[]{new MyTrustManager()}, new SecureRandom());
//            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//            HttpsURLConnection.setDefaultHostnameVerifier(new MyHostnameVerifier());
//            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
//
//            connection.setConnectTimeout(3000);
//            connection.setDoInput(true);
//            connection.setDoOutput(true);
//            connection.setRequestMethod("POST");
//
//            connection.setUseCaches(false);
//            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            DataOutputStream op = new DataOutputStream(connection.getOutputStream());
//            op.writeBytes("token=836b32ec64436f6fbc7c0a3d1c8bc17a");
//            op.flush();
//            op.close();
//
//            in = new InputStreamReader(connection.getInputStream());
//            BufferedReader reader = new BufferedReader(in);
//            StringBuilder response = new StringBuilder();
//            String line;
//            while((line = reader.readLine()) != null){
//                response.append(line);
//            }
//            result = response.toString();
//            Log.d("newsapp", result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        }
//        Log.d("test", result);
//        return result;
//    }

}
