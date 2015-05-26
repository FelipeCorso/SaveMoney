package br.furb.ps.savemoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class Login extends Activity {

    CallbackManager callbackManager;
    LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);

        loginButton = (LoginButton) findViewById(R.id.btn_login_facebook);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String userId = loginResult.getAccessToken().getUserId();
                //Toast.makeText(null, userId, Toast.LENGTH_SHORT).show();
                Intent it = new Intent(Login.this, SaveMoneyActivity.class);
                it.putExtra("_userId", userId);
                startActivity(it);
            }

            @Override
            public void onCancel() {
                //Toast.makeText(null, "Cancelado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                //Toast.makeText(null, "Erro", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
