package com.example.tp2_lab3.ui.register;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp2_lab3.models.Usuario;
import com.example.tp2_lab3.request.ApiClient;
import com.example.tp2_lab3.ui.login.MainActivity;

public class RegistroActivityViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<Usuario> mUsuario;

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Usuario> getMUsuario(){
        if (mUsuario == null) {
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }

    public void loginORegistro(boolean login){
        if(!login){
            mUsuario.setValue(new Usuario());
        }else{
            mUsuario.setValue(ApiClient.leer(context));
        }
    }

    public void guardar(String dni, String nombre, String apellido, String email, String contrasena){
        if(dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasena.isEmpty()){
            Toast.makeText(context, "Hay campos vacios", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiClient.guardar(context, new Usuario(dni, nombre, apellido, email, contrasena));
        Toast.makeText(context, "Usuario guardado.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}