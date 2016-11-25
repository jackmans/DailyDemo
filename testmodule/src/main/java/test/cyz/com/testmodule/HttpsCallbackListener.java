package test.cyz.com.testmodule;

/**
 * Created by M on 2016/11/24.
 */
public interface HttpsCallbackListener {

    public void onFinish(String response);

    public void onError(Exception e);
}
