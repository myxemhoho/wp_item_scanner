package com.example.vaksi.wp_item_scanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;


import javax.xml.transform.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(com.google.zxing.Result result) {
        //Do anything with result here :D
        Log.w("handleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle("Scan result");
        //builder.setMessage(result.getText());
        //AlertDialog alertDialog = builder.create();
        //alertDialog.show();
        Intent intent = new Intent(this, ItemDetailActivity.class);
        String message = builder.setMessage(result.getText()).toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        //Resume scanning
        //mScannerView.resumeCameraPreview(this);
    }
}
