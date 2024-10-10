package com.example.tp2_lab3.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.tp2_lab3.models.Usuario;
import com.example.tp2_lab3.request.ApiClient;
import com.example.tp2_lab3.ui.register.RegistroActivity;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void login(String email, String contrasena) {

        if (email.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(context,"Ingresa el usuario y/o contraseña",Toast.LENGTH_SHORT).show();
            return;
        }

        Usuario usuario = ApiClient.login(context, email, contrasena);

        if (usuario != null) {
            Intent i = new Intent(context, RegistroActivity.class);
            i.putExtra("login", true);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } else {
            Toast.makeText(context,"Email y/o contraseña incorrectos",Toast.LENGTH_SHORT).show();
        }

    }

    public void registro() {
        Intent i = new Intent(context, RegistroActivity.class);
        i.putExtra("login", false);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }


}
