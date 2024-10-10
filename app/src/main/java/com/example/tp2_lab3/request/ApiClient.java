package com.example.tp2_lab3.request;

import android.content.Context;
import android.widget.Toast;

import com.example.tp2_lab3.models.Usuario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ApiClient {

    private static File file;

    private static File conectar(Context context) {
        if (file == null) {
            file = new File(context.getFilesDir(), "usuario.dat");
        }
        return file;
    }

    public static void guardar(Context context, Usuario usuario) {
        File archivo = conectar(context);
        try {
            FileOutputStream fos = new FileOutputStream(archivo, false);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(usuario);

            bos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(context, "Error de archivo", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(context, "Error de entrada/salida", Toast.LENGTH_SHORT).show();
        }
    }

    public static Usuario leer(Context context) {
        Usuario usuario = null;
        File archivo = conectar(context);
        try {
            FileInputStream fis = new FileInputStream(archivo);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            usuario = (Usuario) ois.readObject();
        } catch (FileNotFoundException e) {
            Toast.makeText(context, "Error al encontrar el archivo", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(context, "Error entrada/salida", Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e) {
            Toast.makeText(context, "Error al obtener el usuario", Toast.LENGTH_SHORT).show();
        }
        return usuario;
    }

    public static Usuario login(Context context, String email, String contrasena) {
        Usuario usuario = leer(context);
        if(usuario != null){
            if(usuario.getEmail().equals(email) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

}
