package com.example.moon.checkinternetconnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.net.ConnectivityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyTag";
    boolean isConnceted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isConnceted = checkInternetConncetion();
        if(isConnceted){
            showSnakBar("Internet is Connected");
            Log.i(TAG, "onResume: "+"Internet is Connected");
        }else {
            showSnakBar("NO Internet Connection");
            Log.i(TAG, "onResume: "+"NO Internet Connection");
        }
    }

    private void showSnakBar(String internet_connection) {
        Snackbar snackbar = Snackbar
                .make((ConstraintLayout)findViewById(R.id.parent_view), internet_connection, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    private boolean checkInternetConncetion() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()== NetworkInfo.State.CONNECTED)
                ||(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()==NetworkInfo.State.CONNECTED)){
            return true;
        }else
            return false;

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
