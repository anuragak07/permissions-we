package com.masai.permissions_we_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtnRequestPermissions;
    private static final int REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnRequestPermissions = findViewById(R.id.btnRequestPermissions);
        mBtnRequestPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = {Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE};
                ActivityCompat.requestPermissions(MainActivity.this,permissions,REQUEST_CODE);

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED) {
            showToast("Both the permissions Granted");
        }
        else if(grantResults[0]==PackageManager.PERMISSION_GRANTED &&  grantResults[1]==PackageManager.PERMISSION_DENIED){
            showToast("Camera granted but storage denied");
        }
        else if(grantResults[0]==PackageManager.PERMISSION_DENIED && grantResults[1]==PackageManager.PERMISSION_GRANTED){
            showToast("Camera is denied but storage granted");
        }
        else{
            showToast("Both permissions are denied");
        }

        }
        private void showToast(String message){
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();


    }
}