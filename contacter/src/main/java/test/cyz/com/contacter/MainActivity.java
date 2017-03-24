package test.cyz.com.contacter;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import test.cyz.com.contacter.fragment.ContactFragment;
import test.cyz.com.contacter.fragment.PhoneCallFragment;
import test.cyz.com.contacter.fragment.SmsFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction transaction;
    TextView tv_call;
    TextView tv_contact;
    TextView tv_sms;
    Fragment contactFragment;
    Fragment phoneCallFragment;
    Fragment smsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        tv_call = (TextView)findViewById(R.id.tv_call);
        tv_contact = (TextView)findViewById(R.id.tv_contact);
        tv_sms = (TextView)findViewById(R.id.tv_sms);
        tv_call.setOnClickListener(this);
        tv_contact.setOnClickListener(this);
        tv_sms.setOnClickListener(this);
        tv_call.setSelected(true);
    }

    private void setSelection(int index){
        transaction = fragmentManager.beginTransaction();
        hideFragment();
        clearColor();
        switch (index){
            case 0:
                tv_call.setSelected(true);
                tv_call.setTextColor(Color.WHITE);
                if(phoneCallFragment != null){
                    transaction.show(phoneCallFragment);
                }
                else{
                    phoneCallFragment =  new PhoneCallFragment();
                    transaction.add(R.id.fl_container, phoneCallFragment);
                }
                break;
            case 1:
                tv_contact.setSelected(true);
                tv_contact.setTextColor(Color.WHITE);
                if(contactFragment != null){
                    transaction.show(contactFragment);
                }
                else{
                    contactFragment =  new ContactFragment();
                    transaction.add(R.id.fl_container, contactFragment);
                }
                break;
            case 2:
                tv_sms.setSelected(true);
                tv_sms.setTextColor(Color.WHITE);
                if(smsFragment != null){
                    transaction.show(smsFragment);
                }
                else{
                    smsFragment =  new SmsFragment();
                    transaction.add(R.id.fl_container, smsFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }


    private void hideFragment(){
        if (phoneCallFragment != null) {
            transaction.hide(phoneCallFragment);
        }
        if (contactFragment != null) {
            transaction.hide(contactFragment);
        }
        if (smsFragment != null) {
            transaction.hide(smsFragment);
        }
    }


    private void clearColor(){
        tv_call.setSelected(false);
        tv_contact.setSelected(false);
        tv_sms.setSelected(false);
        tv_call.setTextColor(Color.BLACK);
        tv_contact.setTextColor(Color.BLACK);
        tv_sms.setTextColor(Color.BLACK);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_call:
                setSelection(0);
                break;
            case R.id.tv_contact:
                setSelection(1);
                break;
            case R.id.tv_sms:
                setSelection(2);
                break;
        }
    }

}
