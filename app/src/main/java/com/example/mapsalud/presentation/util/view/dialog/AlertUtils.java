package com.example.mapsalud.presentation.util.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Button;

import com.example.mapsalud.R;

public class AlertUtils {

    private static void setButtonColor(Context context, AlertDialog alertDialog) {
        Button button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        if (button != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                button.setTextColor(context.getResources().getColor(R.color.colorAccent, context.getTheme()));
            else
                button.setTextColor(context.getResources().getColor(R.color.colorAccent));
        }

        button = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        if (button != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                button.setTextColor(context.getResources().getColor(R.color.colorAccent, context.getTheme()));
            else
                button.setTextColor(context.getResources().getColor(R.color.colorAccent));
        }

        button = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        if (button != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                button.setTextColor(context.getResources().getColor(R.color.colorReportProblem, context.getTheme()));
            else
                button.setTextColor(context.getResources().getColor(R.color.colorReportProblem));
        }
    }
    public static void showMessage(Context context, int title, int message, int button, DialogInterface.OnClickListener dialogListener) {
        setButtonColor(context, new AlertDialog.Builder(context).setTitle(title).setMessage(message).setNeutralButton(button, dialogListener).setCancelable(false).show());
    }
    public static void showMessage(Context context, String title, String message, String button, DialogInterface.OnClickListener dialogListener) {
        setButtonColor(context, new AlertDialog.Builder(context).setTitle(title).setMessage(message).setNeutralButton(button, dialogListener).setCancelable(false).show());
    }

    public static void showMessage(Context context, int title, int message, int buttonNegative, DialogInterface.OnClickListener dialogListenerNegative, int buttonPositive, DialogInterface.OnClickListener dialogListenerPositive) {
        setButtonColor(context, new AlertDialog.Builder(context).setTitle(title).setMessage(message).setNegativeButton(buttonNegative, dialogListenerNegative).setPositiveButton(buttonPositive, dialogListenerPositive).setCancelable(false).show());
    }
    public static void TokenExpiresNull(Context context,DialogInterface.OnClickListener dialogListenerPositive) {
        setButtonColor(context,new AlertDialog.Builder(context).setTitle(R.string.app_name).setMessage("Su sesión ha expirado").setPositiveButton("Aceptar", dialogListenerPositive).setCancelable(false).show());
    }

    public static void showNetworkError(Context context) {
        setButtonColor(context,new AlertDialog.Builder(context).setTitle(R.string.app_name).setMessage("No se pudo establecer conexión con el servidor, revise su conexión a Internet").setNegativeButton("Aceptar", null).setCancelable(false).show());
    }

    public static void showTokenExpires(Context context) {
        setButtonColor(context,new AlertDialog.Builder(context).setTitle(R.string.app_name).setMessage("Su sesión ha expirado").setPositiveButton("Aceptar", dialogListenerTokenExpires).setCancelable(false).show());
    }

    private static DialogInterface.OnClickListener dialogListenerTokenExpires = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Log.e("TokenExpires","onClick");
        }
    };

}
