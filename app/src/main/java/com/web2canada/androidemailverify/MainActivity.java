package com.web2canada.androidemailverify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

public class MainActivity extends AppCompatActivity {

    private static final int PER_LOGIN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Start Login
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                                                                      .setAllowNewEmailAccounts(true).build(),PER_LOGIN);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PER_LOGIN){

            handleSignInResponse(requestCode,data);
            return;
        }
    }

    private void handleSignInResponse(int requestCode, Intent data) {

    if(requestCode == RESULT_OK){

        Intent newActivity = new Intent(MainActivity.this,Status.class);
        startActivity(newActivity);
        finish();
        return;
    }else {
        Toast.makeText(this,"Login Failed !!!",Toast.LENGTH_SHORT).show();
    }

    }
}
