package com.example.byeKiloh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;

import android.text.SpannableString;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;

import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.byeKiloh.utilidades.*;
import static com.example.byeKiloh.utilidades.Tablas.EstructuraUsuario.*;

public class RegistroActivity extends AppCompatActivity {

    private Button btnVolverAtras, btnRegistro;
    private CheckBox cbAcepto;
    private EditText etUsuario, etContrasena, etContrasenaRe;
    private ImageView imgPass, imgPassRe;
    private TextView tvCondicionesServicio, tvPoliticaPrivacidad;

    private boolean select = false;
    //Esta variable permite comprobar los digitos de varios EditText a la vez
    private int countError = 1;

    BaseDatos basedatos;
    Mensaje mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnVolverAtras = findViewById(R.id.btnVolverAtras);
        btnRegistro = findViewById(R.id.btnIniciarSesion);

        cbAcepto = findViewById(R.id.cbAcepto);

        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        etContrasenaRe = findViewById(R.id.etContrasenaRe);

        imgPass = findViewById(R.id.imgPass);
        imgPassRe = findViewById(R.id.imgPassRe);

        tvCondicionesServicio = findViewById(R.id.tvCondicionesServicio);
        tvPoliticaPrivacidad = findViewById(R.id.tvPoliticaPrivacidad);

        basedatos = new BaseDatos(getApplicationContext());
        //Convertimos en enlaces los TextViews de, Condiciones del Servicio y Política de privacidad
        SpannableString contentC = new SpannableString(tvCondicionesServicio.getText());
        tvCondicionesServicio.setText(contentC);
        SpannableString contentP = new SpannableString(tvPoliticaPrivacidad.getText());
        tvPoliticaPrivacidad.setText(contentP);

        tvCondicionesServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos Intent para visualizar .PrivacidadActivity
                Intent intent = new Intent(getApplicationContext(), PrivacidadActivity.class);
                startActivity(intent);

                mensaje = new Mensaje(getApplicationContext(), "Términos y Condiciones del\n" +
                        "servicio y Política de privacidad");

            }

        });

        tvPoliticaPrivacidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos Intent para visualizar .PrivacidadActivity
                Intent intent = new Intent(getApplicationContext(), PrivacidadActivity.class);
                startActivity(intent);

                mensaje = new Mensaje(getApplicationContext(), "Términos y Condiciones del\n" +
                        "servicio y Política de privacidad");

            }

        });
        //TextView que permite la visualización de "Confirmar Contraseña"
        imgPassRe.setOnClickListener(new View.OnClickListener() {
            boolean selectPassRe = false;
            @Override
            public void onClick(View v) {

                if(!selectPassRe) {

                    selectPassRe = true;
                    etContrasenaRe.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                    if(etContrasenaRe.getText().length() > 0) {

                        etContrasenaRe.setSelection(etContrasenaRe.getText().length());
                        imgPassRe.setBackgroundResource(R.drawable.ic_visible);

                    }

                }
                else {

                    selectPassRe = false;
                    etContrasenaRe.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    if(etContrasenaRe.getText().length() > 0) {

                        etContrasenaRe.setSelection(etContrasenaRe.getText().length());
                        imgPassRe.setBackgroundResource(R.drawable.ic_visible_no);

                    }
                }
            }

        });
        //TextView que permite la visualización de "Contraseña"
        imgPass.setOnClickListener(new View.OnClickListener() {
            boolean selectPass = false;
            @Override
            public void onClick(View v) {

                if(!selectPass) {

                    selectPass = true;
                    etContrasena.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                    if(etContrasena.getText().length() > 0) {

                        etContrasena.setSelection(etContrasena.getText().length());
                        imgPass.setBackgroundResource(R.drawable.ic_visible);

                    }

                }
                else {

                    selectPass = false;
                    etContrasena.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    if (etContrasena.getText().length() > 0) {

                        etContrasena.setSelection(etContrasena.getText().length());
                        imgPass.setBackgroundResource(R.drawable.ic_visible_no);

                    }
                }
            }

        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Primer if comprueba que no hay EditText vacíos
                Usuario usuario;
                if (etUsuario.getText().toString().equals("") ||
                        etContrasena.getText().toString().equals("") ||
                        etContrasenaRe.getText().toString().equals("")) {

                    mensaje = new Mensaje(getApplicationContext(), "Revise los datos " +
                            "introducidos\ntodos los campos son obligatorios");

                } else {

                    countError=1;
                    //Comprobamos número mínimo de carácteres en cada EditText
                    numMinL(etUsuario, 4, "Usuario");
                    numMinL(etContrasena, 6, "Contraseña");
                    numMinL(etContrasenaRe, 6, "Confirmar Contraseña");
                    //Segundo if comprueba si se cumple con el mínimo de carácteres
                    if (countError == 1) {
                        //Se crea e inicializa el objeto usuario
                        usuario = new Usuario();
                        //Se recogen los datos de los EditText
                        usuario.setUsuario(etUsuario.getText().toString());
                        usuario.setContraseña(etContrasena.getText().toString());
                        String passRe = etContrasenaRe.getText().toString();
                        //Tercer if comprueba si no coinciden las contraseñas
                        if (!usuario.getContraseña().equals(passRe)) {

                            mensaje = new Mensaje(getApplicationContext(), "Las Contraseñas " +
                                    "introducidas\nno coinciden");

                        } else {
                            //Cuarto if comprueba que los Terminos y Condiciones están aceptados
                            if (cbAcepto.isChecked()){
                                //Se establece conexion con permisos de lectura
                                SQLiteDatabase sqlite = basedatos.getReadableDatabase();
                                //Columnas que recogerá los datos de la consulta
                                String[] columnas = {_IDUSUARIO, COLUMN_NAME_USUARIO,
                                        COLUMN_NAME_CONTRASEÑA};
                                //Cláusula WHERE para buscar por usuario
                                String usuarioSQL = COLUMN_NAME_USUARIO + " LIKE '" +
                                        usuario.getUsuario() + "'";
                                //Orden de los resultados devueltos por usuario, de forma
                                // Descendente alfabéticamente
                                String ordenSalida = COLUMN_NAME_USUARIO + " DESC";
                                //Ejecuta la sentencia devolviendo los resultados de los parámetros
                                // pasados de tabla, columnas, usuario y orden de los resultados.
                                Cursor cursor = sqlite.query(TABLE_NAME, columnas, usuarioSQL,
                                        null, null, null, ordenSalida);
                                //Quinto if comprueba que el cursor no esté vacío
                                if (cursor.getCount() != 0) {

                                    cursor.moveToFirst();
                                    mensaje = new Mensaje(getApplicationContext(), "El nombre de" +
                                            " usuario: " + usuario.getUsuario() + "\nno está disponible, " +
                                            "pruebe con otro");
                                    etUsuario.setText("");

                                } else {
                                    //Aqui se introduce el usuario nuevo en la base de datos
                                    //Se ganan tambien permisos de escritura
                                    sqlite = basedatos.getWritableDatabase();
                                    //EstructuraUsuario de insercción de datos
                                    ContentValues content = new ContentValues();
                                    //Se añaden los valores introducidos de cada campo mediante
                                    // clave(columna)/valor(valor introducido en el campo de texto)
                                    content.put(COLUMN_NAME_USUARIO, usuario.getUsuario());
                                    content.put(COLUMN_NAME_CONTRASEÑA, usuario.getContraseña());
                                    sqlite.insert(TABLE_NAME, null, content);
                                    //Registro exitoso
                                    mensaje = new Mensaje(getApplicationContext(), "El usuario " +
                                            usuario.getUsuario() + "\nse registró con éxito");
                                    //Reseteo de los EditText
                                    etUsuario.setText("");
                                    etContrasena.setText("");
                                    etContrasenaRe.setText("");
                                    //Abrimos un intent para volver a .LoginActivity
                                    Intent intent = new Intent(getApplicationContext(),
                                            LoginActivity.class);
                                    startActivity(intent);

                                }
                                //Se cierra el cursor
                                cursor.close();
                                //Se cierra la conexión abierta a la Base de Datos
                                sqlite.close();

                            } else {

                                mensaje = new Mensaje(getApplicationContext(), "Debe aceptar los" +
                                        " Términos y\nCondiciones para poder registrarse");

                            }
                        }
                    }
                }

            }

        });

        btnVolverAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos Intent para volver a .LoginActivity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }

        });

    }

    //Método que cuenta el número de caracteres introducidos
    public void numMinL(EditText et, int minDig, String campo){
        //Contamos el tamaño del EditText introducido
        int num = et.length();
        //Comprobamos si el tamaño del EditText es inferior al minimo exigido
        if(num<minDig) {
            //Retorno de mensaje de error detallado
            mensaje = new Mensaje(getApplicationContext(), "'" + campo + "' tiene " + num +
                    " carácteres\ny el mínimo para ese campo son " + minDig);

            countError += 1;

        }

    }

}