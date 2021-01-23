<p align="center">
<img src="/resources/cabecera.png"/>
</p>

# <p align="center">PROYECTO PSP/AAD 20/21</p>

## <p align="center">GAMER HUB</p>

<p align="center">
<img src="/resources/gamerhublogo.png"/>
</p>


<br>
<br>


# <p align="center">Índice</p>
> **[1. Licencia y Autores](#1)**<br>
> **[2. Presentación](#2)**<br>
> **[3. FASE 1: Análisis y diseño](#3)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 1: Requisitos no funcionales](#4)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 2: Requisitos funcionales. Definición del problema.](#5)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 3: Entorno de trabajo.](#6)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 4: Análisis de requisitos funcionales. Casos de uso.](#7)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 5: Modelo de objetos del negocio.](#8)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 6: Interfaz gráfica.](#9)**<br>
<br>

<a name="1"></a>
# LICENCIA Y AUTORES

Este material ha sido producido por <b>Manuel Santos</b> y <b>Victor Ruiz</b> bajo licencia Creative Commons.  

<br>

<p align="center">
<img src="/resources/cclogo.png" height="40" width="140"/>  
</p>

<br>

<a name="2"></a>
# PRESENTACIÓN

¡Hola! Somos el equipo 3, formado por los alumnos Manuel Santos, Víctor Ruiz y Miguel Rodríguez.
Somos estudiantes de 2º curso de ciclo FP superior DAM y este es un proyecto
que estamos realizando para la asignatura de PSP y AAD en el I.E.S Ramón del Valle Inclán.

<a name="3"></a>
# FASE 1: ANÁLISIS Y DISEÑO

<br>

<a name="4"></a>
## ACTIVIDAD 1: REQUISITOS NO FUNCIONALES.

1. Funcionalidades desarrolladas en procesos y subprocesos.
 
    * Procesos del SO: fecha y hora, CMD, recoger
    datos de otras aplicaciones como Spotify o Steam.
    * Procesos de la propia app: [por ver aún...]
  
2. Funcionalidades concurrentes con hilos.

    * Nuestra aplicación requerirá de hilos para la propia conexión en sí al servidor,
    al conectarse a un canal o sala de chat. En el primer caso, cada usuario conectado es un hilo,
    y las conexiones a los chats serían subhilos.
    * ... o al enviar peticiones al admin, las cuales 
    serán limitadas en un tiempo determinado (productor-consumidor). Esta última funcionalidad
    requerirá de una cola de peticiones, y sólo cuando el admin o usuario con el rol requerido
    atienda a la petición se podrá enviar otra.

3. Funcionalidades para comunicaciones en red: Arquitectura Cliente-Servidor.

    * La aplicación en sí tendrá un desarrollo por dos partes en este requisito:
         
         - La aplicación servidor, que será la encargada de recibir peticiones de los clientes, 
         la que establecerá una conexión con la base de datos. Si está parte no está operativa
         los usuarios no podrán usar la aplicación del lado del cliente. Se usará el protocolo
         TPC/IP para estas conexiones.
         
         - La aplicación cliente, que enviará la petición de conexión al servidor.
    
4. Implementación protocolos estándar de correo y ficheros: SMTP y FTP.

    * <b>FTP: </b>Servidor común de archivos (imágenes o ficheros) en los que los usuarios podrán descargar
    o subir archivos.
    
    * <b>SMTP: </b>Servidor para correos: recordatorios, envíos de peticiones, recuperación de la cuenta.



<br>

<a name="5"></a>
## ACTIVIDAD 2: REQUISITOS FUNCIONALES. DEFINICIÓN DEL PROBLEMA.


1. <b>TÍTULO: </b> GAMER HUB
2. <b>RESUMEN: </b> Nuestro proyecto constituye una aplicación cliente servidor para jugadores, parecida a Discord. Esta aplicación va a requerir de varios clientes que se conecten a un servidor, mediante un login. Sus características incluirán:
- Registrar una cuenta.
- Un perfil del cliente que el mismo podrá modificar a gusto propio.
- Salas de chats o canales para hablar con amigos.
- Una funcionalidad que permite enviar mensajes (peticiones o incidencias) al administrador del sistema.
- APIs: que nos proporcionarán datos de los juegos (Steam) o música (Spotify) que nosotros o nuestros amigos están jugando o escuchando en ese momento.
- Un calendario de eventos.

- En la pantalla de login o registro una opción de recuperación de la cuenta si se olvidan el correo, nombre de usuario o contraseña.
- Añadir/Eliminar amigo
- Ver perfil de amigo
 

<br>

<a name="6"></a>
## ACTIVIDAD 3: ENTORNO DE TRABAJO

1.  Lenguaje: Java.
2.  Entorno de Desarrollo: IntelliJ.
3.  Control de versiones: GitHub Classroom
4.  Arquitectura MVC/Cliente-Servidor .
5.  Maven.
6.  Spring.
<br>

<a name="7"></a>
## ACTIVIDAD 4: ANÁLISIS DE REQUISITOS FUNCIONALES. CASOS DE USO.

<br>

### <b>DIAGRAMA CASOS DE USO</b>

<br>
<p align="center">
<img src="/resources/casos_uso_gamerhub.png"/>
</p>

<br>


<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-1</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>REGISTRO USUARIO/ CREACIÓN DE CUENTA </td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Se accede al formulario de registro al pulsar el botón “Crear cuenta”</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Usuario</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>El nombre de usuario o el correo mediante los cuales vamos a crear nuestra cuenta no deben existir previamente como registrados, es decir, han de ser nuevos.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  En la pantalla inicial de login o registro, pulsamos el botón “Crear Cuenta”<br><br>
2.  Se pasa a una vista de formulario, en la que se nos pedirán datos como:<br><br>
-   	Nombre de usuario o nickname.<br>
-   	Nombre (Obligatorio) y apellidos (Opcional).<br>
-   	Fecha de nacimiento. (Obligatorio).<br>
-   	E-mail. (Obligatorio).<br>
-   	Teléfono (Opcional).<br><br>
3.  El usuario hace clic en aceptar.<br><br>
4.  El sistema verifica los datos.<br><br>
5.  La cuenta se crea satisfactoriamente.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>Acceso a la pantalla principal o “home” de la aplicación.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
  1.  Error de conexión<br><br>
  ---------------------------------------------------------------------------<br>
  3.  Error en la introducción de algún campo, algún dato no es correcto.<br>
  4.  No se crea la cuenta.
</td>
</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-2</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>LOGIN O ACCESO A LA CUENTA</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Victor</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Acceder a la cuenta de nuestro usuario.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Usuario</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Haberse registrado y tener una cuenta.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
 1.  Se introducen el nombre de usuario o E-mail y la contraseña, en la vista de inicio.<br><br>
 2.  El usuario clica en iniciar sesión.<br><br>
 3.  El sistema comprueba los datos de acceso.<br><br>
 4.  El usuario accede correctamente a la aplicación.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>Se accede a la vista “Home” o “Principal”<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
 4.  Error de conexión con el server.<br>
 
		4.1.  Nombre de usuario/ E-mail o contraseñas incorrectos.
		4.2.  El nombre de usuario no existe.
</td>
</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-3</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>MODIFICAR PERFIL</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Manuel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Se accede a la vista de nuestro perfil, donde se nos mostrarán todos nuestros datos y la posibilidad de modificarlos/ actualizarlos.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  En la vista del perfil, pulsamos el botón de edición adyacente al campo que queramos modificar.<br><br>
2.  Introducimos la modificación.<br><br>
3.  Se realiza la modificación correctamente.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>Se modifica nuestro perfil.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
 3. El tipo de dato introducido en algún campo es incorrecto, no tiene el formato correcto o es demasiado largo o corto.
</td>
</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-4</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>BUSCAR/AÑADIR AMIGOS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Se accede a una pantalla donde el usuario podrá buscar a cualquier usuario de la plataforma por su nombre/nickname y agregarlo como amigo.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Usuario</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  En la vista buscar amigos, el usuario introducirá el nick del amigo que quiera buscar en la barra de búsqueda.<br><br>
2.  Aparecerán los usuarios del sistema que se llamen igual al puesto y el usuario podrá añadir a su amigo haciendo click en el icono de agregar.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>Se actualizará la lista de amigos para chatear o insertar en un canal al usuario agregado.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
2. No se encuentra al usuario introducido en la barra de búsqueda y el sistema notificará al usuario.
</td>
</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-5</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ABRIR CHAT</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Victor</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Se accede a la vista de chat eligiendo el usuario o grupo.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta, acceder a la misma y tener agregado al usuario o grupo con el que quiere chatear.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  En la lista de amigos/grupos estando en la vista principal, el usuario selecciona el que quiera.<br><br>
2.  Se abre la vista chat con la conversación anterior si hubiera.<br><br>
3.  El usuario introduce el mensaje en la barra de mensajes y lo envía pulsando el botón de enviar.<br><br>
4.  El sistema envía el mensaje al chat.<br><br>
5.  Se envía satisfactoriamente el mensaje.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario chatea con otro usuario o en un grupo.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
5. El mensaje no puede enviarse y el sistema notifica al usuario.
</td>
</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-6</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>CREAR CANAL/GRUPO</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Manuel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Se accede a la vista de creación de grupo donde se seleccionará un nombre y se agregaran a los amigos que quiera y tenga el usuario.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta, acceder a la misma y tener agregados usuarios como amigos.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El usuario hace clic en crear canal.<br><br>
2.  Se abre una nueva vista que pide al usuario que introduzca un nombre del canal y que introduzca a los amigos que quiera agregar al canal.<br><br>
3.  El usuario introduce los datos.<br><br>
4.  El sistema crea el grupo/canal con las personas seleccionadas por el usuario.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario crea el canal/grupo para chatear correctamente.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
Ninguna.
</td>
</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-7</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ENVIAR MENSAJE A ADMIN</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario manda un mensaje de incidencia al administrador.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Usuario</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El usuario hace clic en ayuda en la vista principal de la aplicación.<br><br>
2.  Se abrirá una nueva vista en la que se le pedirá que indique su problema y detalle el mismo.<br><br>
3.  El usuario introduce los datos.<br><br>
4.  El sistema envía la incidencia a la base de datos donde se guardará.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El mensaje de incidencia se envía correctamente al administrador.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
5. El sistema notifica al usuario que no se ha podido enviar la incidencia y que lo intente más tarde.
</td>
</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-8</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ADMINISTRAR MENSAJES DE INCIDENCIAS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Victor</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El administrador ve y responde los mensajes de incidencias de los usuarios.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Ser administrador y acceder a la aplicación.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El administrador hace clic en incidencias.<br><br>
2.  Se abrirá una nueva vista con una lista de las incidencias que los usuarios les han mandado.<br><br>
3.  Podrá ver, responder al usuario y eliminar la incidencia con sus respectivos botones.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El administrador ve las incidencias.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
Ninguna.
</td>
</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-9</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>MODIFICAR PERFILES</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Manuel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El administrador modifica, suspende temporalmente o elimina a los usuarios de la aplicación.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Ser administrador y acceder a la aplicación.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El administrador hace clic en administrar usuarios.<br><br>
2.  Se abrirá una vista con la lista de usuarios del sistema.<br><br> 
3.  el administrador hará clic en el usuario deseado y podrá hacer clic en modificar, suspender temporalmente y eliminar.<br><br>
4.  Se realiza la modificación correctamente.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>Se administra el usuario deseado por el administrador.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
4. El tipo de dato introducido en algún campo al modificar el perfil es incorrecto, no tiene el formato correcto o es demasiado largo o corto.
</td>
</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-10</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>VER PERFILES</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario selecciona el perfil del amigo que quiera ver y , en caso de querer, lo elimina.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El usuario hace clic en el amigo que quiera dentro de su lista de amigos.<br><br>
2.  Se abrirá una nueva vista con los datos del amigo.<br><br>
3.  El usuario ve los datos del amigo.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario accede al perfil del amigo que quiere ver.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
3.  El usuario hace clic en eliminar.<br><br>
4.  El sistema confirma que quiere eliminar.<br><br>
5.  El usuario elimina al amigo.
</td>
</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-11</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>CREAR EVENTO</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario crea un evento.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El usuario hace clic en el icono "+" para agregar un evento a su lista.<br><br>
2.  Se abrirá una nueva vista con los datos a introducir del evento y la fecha.<br><br>
3.  El usuario introduce los datos en sus respectivos campos.<br><br>
4. El evento se agregará correctamente.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario agrega un evento correctamente.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
4. Error al introducir algún campo.
</td>
</table>
<br> 

<a name="8"></a>
## ACTIVIDAD 5: MODELO DE OBJETOS DEL NEGOCIO.



<br>

### Diagrama de clases


#### Diagrama Servidor

<p align="center">
<img src="/resources/diagramas_clases_gamerhub.png"/>
</p>


<br>

### Descripción del diagrama de clases
<br>
#### Plantilla clases
<br>

<table>



<tr>

<td>  Nombre de la clase  </td>
<td>    </td>
	
</tr>

<tr>
<td>  Descripción  </td>
<td>    </td>

</tr>

<tr> 

<td> Relaciones </td>
<td></td>

<tr>
	
</table>


<br>

<br>

<table>


<tr>

<td>  Atributos  </td>
<td>    </td>
	
</tr>

<tr>
<td>  Atributos propios de la clase  </td>
<td>    </td>

</tr>

<tr> 

<td> Atributos propios de la relación </td>
<td></td>

<tr>
	
</table>


<br>

<br>

<table>


<tr>

<td>  Métodos  </td>
<td>    </td>
	
</tr>

<tr>
<td>  Función  </td>
<td>    </td>

</tr>

<tr> 

<td> Sintaxis del método </td>
<td></td>

<tr>
	
</table>

<br>

### Modelo de datos 

<p align="center">
<img src="/resources/modelo_datos_gamerHub.png"/>
</p>



<br>
<a name="9"></a>

## ACTIVIDAD 6: INTERFAZ GRÁFICA.
