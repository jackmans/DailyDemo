package test.cyz.com.newsappone.util;

/**
 * Created by M on 2016/11/24.
 */
public interface HttpsCallbackListener {

    public void onFinish(String response);

    public void onError(Exception e);
}
