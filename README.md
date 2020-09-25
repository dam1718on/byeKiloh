# ByeKiloh
## Beware of the Dog!!
<h3>initial branch: master</h3>
    <ul>
    <li>initial commit. Generado proyecto desde Portatil-Ubuntu(branch:master)</li>
    <li>primer commit. Upgradeado proyecto con FraseDelDia</li>
    <li>segundo commit.  Adaptar la app a las necesidades propias</li>
    <li>tercer commit. Limpiando un poco el proyecto</li>
    <li>4commit. Limpio total, guardar() y calcular() implementados</li>
    <li>5commit. Sacado atributo ms, kmh de la clase</li>
    <li>6Kommit. Mejora gráfica e implementacion botón reset con listener</li>
    <li>7Kommit. Implementado método velocidad(). Todos los botones ahora con onClickListener</li>
    <li>8Kommit. Implementado id(YYYYMMDD) al objeto ejercicio</li>
    <li>9Kommit. Arreglado el id(YYMMDD). Teniendo en cuenta los ceros a la izquierda</li>
    <li>10Komit. Implementada BBDD SQLite embebida</li>
    </ul>
<p>--new branch: format0.2</p>
    <ul>
    <li>11 commit. Nueva rama cambios sustanciales en la app. nuevo formato</li>
    <li>Commit12. NewLoginActivity guarda en BBDD</li>
    <li>Commit13. LoginActivity. Creado apaisado y finalizado diseño</li>
    <li>Commit14. REGISTRO() finalizado (primero verifica y luego añade)</li>
    <li>Commit15. LOGIN() finalizado. Clase Usuario implementada</li>
    <li>Commit16. LoginActivity finalizada</li>
    </ul>
<p>--new branch: format1.0</p>
    <ul>
    <li>Commit17. RegistroActivity creada</li>
    <li>Commit18. RegistroActivity implementada parte lógica</li>
    <li>Commit19. Obj. Usuario se completa ATR y se guarda en dos tablas de la BBDD(Usuarios-Cuentas)</li>
    <li>Commit20. Depuración y nuevo branch: format1.1</li>
    </ul>
<p>--new branch: format1.1</p>
    <ul>
    <li>Commit21. Implementado Paso1de3 para CrearCuenta</li>
    <li>Commit22. Logos Aplicación en naranja degradado y en ByN</li>
    <li>Commit23. Estructuro README.md</li>
    <li>Commit24. Estructuro styles.xml y se actualiza .Login</li>
    </ul>
<p>--new branch: format1.2</p>
    <ul>
    <li>Commit25. Re-estructuro carpeta del proyecto</li>
    <li>Commit26. Implementado el envío del Usuario-Objeto entre Activitys</li>
    </ul>
<h3>DONE</h3>
<p>Commit16. Restricciones a los digitos EditText patterns insertar, consultar datos implementado
"Mantener sesion iniciada"(CheckBox). SharedPreferences para Mantener sesion iniciada. nuevo branch
al acabar .LoginActivity</p>
<p>Commit17. Se crea .RegistroActivity para profundizar en la información de la cuenta de cada
usuario. Se cambia a ConstrainLayout en esta activity mejoría en la integridad visual de los
"com.example.byekiloh.objetos". Se crean las restricciones de los atributos</p>
<p>Commit18. Los atributos relativos al peso, se quitan de la clase/tabla usuario Edad, Altura,
Peso, Fecha inserccion. Creados varios if anidados para comprobar errores de introduccion de datos,
con mensajes toast personalizados</p>
<p>Commit19. El Objeto Usuario ya se completa en ejecucion sobre .RegistroActivity y se guardar en
la BBDD(completo). Integridad de la información de cada cuenta (prioridad alta). Creo
activity_registro.xml(land) y activity_login.xml(land)</p>
<p>Commit20. Pruebas realizadas y depurados errores en diseño y lógica. Creo nuevo branch ya que
comienzo un enfoque diferente, usando fragments(3) en .RegistroActivity</p>
<p>Commit21. No consigo con fragments el aspecto que me gustaría de pestañas de navegador web, así
que hago layouts normales para poder continuar en la parte lógica. Implementado Paso1de3 de
CrearCuenta</p>
<p>Commit22. Aprendo el uso básico de Illustrator para crear el logo de la aplicación, tanto en
naranja degradado hacia amarillo como en blancoynegro, se adjuntan ambos y se comprueba el ajuste
en la aplicación a través de LinearLayouts</p>
<p>Commit23. Reestructuro README.md con lenguaje HTML que facilita la visualización de las tareas
realizadas y pendientes</p>
<p>Commit24. Reestructuro styles.xml y añado dos nuevos estilos uno vacío para quitar la ActionBar
de inicio y otro para el borde de letra para los Botones. También se introduce el logo en byn sobre
un fondo degradado y se termina activity_login.xml</p>
<p>Commit25. Creo este commit para realizar una reestructuración de la carpeta del proyecto, solo
dejare las clases funcionales del Login, Registro e Inicio y sus xml asociados</p>
<p>Commit26. Implemento .MainActivity y le envío un Usuario-Objeto desde .LoginActivity, incluyo
graficamente el acuerdo de Términos y condiciones del servicio y la Política de privacidad de
byekiloh al checkBox de .RegistroActivity</p>
<h3>TASK</h3>
    <ul>
    <li>1. Hacer los documentos, condiciones y privacidad e implementar intent para leerlos</li>
    <li>2. Inflate el menu con los datos de Usuario</li>
    <li>3. SharedPreferences empty para acceso directo a la .MainActivity al inicar app</li>
    <li>4. Poder cerrar sesión desde el Menu de la .MainActivity, vaciando el shared y volviendo al
    .Login</li>
    <li>Terminar la parte lógica de Login y Registro de cuenta</li>
    <li>Implementar un menu para el Usuario/Cuenta</li>
    <li>Pasar objeto Usuario de .LoginActivity a .FirstActivity</li>
    <li>Posibilidad de implementar un diseño para día y otro para noche</li>
    <li>Posibilidad de varios idiomas</li>
    <li>Implementar CRUD completo SQLite</li>
    <li>Hacer usable la app por mi e ir viendo la ejecucion</li>
    <li>Probar la BBDD e intentar administrarla en remoto</li>
    <li>Implementar tiempo en minutos y segundos</li>
    <li>Implementar Kcal</li>
    <li>Implementar pulsaciones ppm</li>
    <li>Velocidad media, Real(m/s,km/h)</li>
    <li>Hacer la BBDD syncronizable.(JSON?)</li>
    </ul>
