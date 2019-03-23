package com.example.mapsalud.presentation.util.view.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.example.mapsalud.R;
import com.example.mapsalud.presentation.util.view.dialog.AlertUtils;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final int PERMISSION_RESOLUTION_REQUEST = 8;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private Activity activity;

    public PermissionUtils(Activity activity) {
        this.activity = activity;
    }



    DialogInterface.OnClickListener onAcceptDialogInterface = new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            activity.finish();
        }
    };




    public boolean onRequestPermissionsResult(int[] grantResults) {
        boolean isGranted = true;
        for (int i = 0; i < grantResults.length; i++) {
            Log.e("onRequestPermissio"," grantResults "+grantResults[i] + " PackageManager "+ PackageManager.PERMISSION_DENIED);
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                isGranted = false;
                break;
            }
        }

        if (!isGranted){
            AlertUtils.showMessage(activity, R.string.app_name, R.string.permissions_not_granted, R.string.alert_accept_text, onAcceptDialogInterface);
            return false;
        }else {return true; }

    }


    public boolean checkPermissions() {
        checkStoragePermissions();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                List<String> lstPermissions = new ArrayList<>();
                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                    lstPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
                if (!lstPermissions.isEmpty()) {
                    ActivityCompat.requestPermissions(activity, lstPermissions.toArray(new String[lstPermissions.size()]), PERMISSION_RESOLUTION_REQUEST);
                    return false;
                } else
                    return true;
            } else {
                return true;

            }

    }




    public  void checkStoragePermissions() {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
