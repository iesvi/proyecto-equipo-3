<p align="center">
<img src="./resources/cabecera.png"/>
</p>


# <p align="center">PROYECTO PSP/AAD 20/21</p>

## <p align="center">GAMER HUB</p>

<p align="center">
<img src="./resources/gamerhublogo.png"/>
</p>



<br>
<br>


# <p align="center">Índice</p>
> **[1. Licencia y Autores](#1)**<br>
> **[2. Presentación](#2)**<br>
> **[3. FASE 1: Análisis](#3)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 1: Requisitos no funcionales](#4)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 2: Requisitos funcionales. Definición del problema.](#5)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 3: Entorno de trabajo.](#6)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 4: Análisis de requisitos funcionales. Casos de uso.](#7)**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Gestión de usuarios.](#USUARIOS)**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Gestión del servidor de archivos.](#ARCHIVOS)**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Gestión de chat.](#CHATS)**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Gestión de eventos..](#EVENTOS)**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Gestión de peticiones/incidencias.](#PETICIONES)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 5: Modelo de objetos del negocio.](#8)**<br>
> **[&nbsp;&nbsp;&nbsp; Actividad 6: Interfaz gráfica.](#9)**<br>
<br>

<a name="1"></a>
# LICENCIA Y AUTORES

Este material ha sido producido por <b>Manuel Santos</b>, <b>Victor Ruiz</b> y <b>Miguel Rodríguez</b> bajo licencia Creative Commons.  

<br>

<p align="center">
<img src="./resources/cclogo.png" height="40" width="140"/>  
</p>


<br>

<a name="2"></a>

# PRESENTACIÓN

¡Hola! Somos el equipo 3, formado por los alumnos Manuel Santos, Víctor Ruiz y Miguel Rodríguez.
Somos estudiantes de 2º curso del ciclo FP superior DAM y este es un proyecto
que estamos realizando para el módulo de Programación de Servicios y Procesos con nuestro profesor José Luis Rodríguez Rodríguez y el módulo de Acceso a Datos con nuestro profesor Jesús García Rodríguez en el I.E.S Ramón del Valle Inclán.

<a name="3"></a>
# FASE 1: ANÁLISIS

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
2. <b>OBJETIVO: </b> Nuestro proyecto constituye una aplicación, parecida a Discord, cuyo objetivo es la comunicación entre jugadores en directo, los cuales además de chatear, podrán intercambiarse ficheros y administrar eventos que pueden crear como recordatorios. Sus características incluirán:
- Registrar una cuenta.
- Un perfil del cliente que el mismo podrá modificar a gusto propio.
- Salas de chats o canales para hablar con amigos.
- Una funcionalidad que permite enviar mensajes (peticiones o incidencias) al administrador del sistema.
- APIs: que nos proporcionarán información de nuestros amigos sobre que juego está jugando (Steam) o que están escuchando en ese mismo instante (Spotify).
- Un calendario de eventos.
- En la pantalla de iniciar sesión o registro una opción de recuperación de la cuenta si se olvidan el correo, nombre de usuario o contraseña.
- Añadir/Eliminar amigo
- Ver perfil de amigo
- Subir/Descargar/Eliminar archivos de un servidor.


<br>

<a name="6"></a>
## ACTIVIDAD 3: ENTORNO DE TRABAJO

- Lenguaje: Java.

- Entorno de Desarrollo: [IntelliJ](https://www.jetbrains.com/es-es/idea/download/#section=windows).

- SDK: [Java SE Development Kit 8.](https://www.oracle.com/es/java/technologies/javase/javase-jdk8-downloads.html)

- Control de versiones: Usaremos GitHub Classroom donde trabajaremos en 2 ramas fundamentalmente:

  - Rama main donde subiremos la parte de codificación de la aplicación.

  - Rama documentación donde subiremos el manual técnico que recogerá todo el apartado técnico de la aplicación, así como un manual de usuario explicando cómo puede acceder a nuestra aplicación.

    Cada rama tiene su rama release, que usaremos para preproducción una vez terminado el proyecto.

- Arquitectura: Usaremos 2 principalmente:

  -  [MVC](https://desarrolloweb.com/articulos/que-es-mvc.html): La aplicación de escritorio será realizada con este patrón.
  - [Arquitectura limpia por capas](https://www.genbeta.com/desarrollo/principios-de-una-arquitectura-limpia-mantenible-y-testeable)

- Maven.

- Spring.
  <br>

<a name="7"></a>

## ACTIVIDAD 4: ANÁLISIS DE REQUISITOS FUNCIONALES. CASOS DE USO.

<br>

### <b>DIAGRAMA CASOS DE USO</b>

<br>
<a name="USUARIOS"></a>

<p align="center">
<img src=".\resources\DCU-gestion-usuario.png"/>
</p>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-1</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>REGISTRO DE USUARIO</td>
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-2</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>INICIAR SESION</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Acceder a la cuenta de nuestro usuario.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Usuario/Administrador</td>
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-3</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>CONSULTAR PERFIL USUARIO</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-4</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>RECUPERAR LISTA DE AMIGOS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El sistema recupera una lista de amigos.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Sistema</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td></td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El sistema recupera la lista de amigos del usuario que accede a la gestion de amigos.<br><br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>Se recupera la lista de amigos.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
Ninguna
</td>
</table>

<br>



<table style="width:100%">  <tr>    <td><b>ID: </b></td>    <td>CU-5</td>  </tr>  <tr>    <td><b>Nombre: </b></td>    <td>ENVIAR PETICIÓN DE AMISTAD</td>  </tr>  <tr>  <td><b>Equipo/Individual<b></td>  <td>Equipo</td>  </tr>  <tr>    <td><b>Descripción:</b></td>    <td>Se accede a una pantalla donde el usuario podrá buscar a cualquier usuario de la plataforma por su nombre/nickname y agregarlo como amigo.</td>  </tr>  <tr>    <td><b>Actores:</b></td>    <td>Usuario/Administrador</td>  </tr>  <tr>  <td><b>Precondiciones:</b></td>  <td>Tener una cuenta y acceder a la misma.</td>  </tr>    <tr>  <td><b>Curso normal:</b></td>  <td>1.  En la vista buscar amigos, el usuario introducirá el nick del amigo que quiera buscar en la barra de búsqueda.<br><br>2.  Aparecerán los usuarios del sistema que se llamen igual al puesto y el usuario podrá añadir a su amigo haciendo click en el icono de agregar.  </td>  </tr>  <tr>  <td><b>Postcondiciones:</b></td>  <td>Se actualizará la lista de amigos para chatear o insertar en un canal al usuario agregado.<br>  </td></td>  </tr>  <tr>  <td><b>Alternativas/Excepciones:</b></td>  <td>2. No se encuentra al usuario introducido en la barra de búsqueda y el sistema notificará al usuario.</td></table>

<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-6</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>GESTIONAR LISTA DE AMIGOS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario accede a su lista de amigos pudiendo ver y eliminar su perfil.</td>
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
3.  El usuario ve los datos del amigo y tiene la opcion de realizar eliminar amigo.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario ve los amigos que tiene y accede a su perfil público.
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-7</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ELIMINAR AMIGO</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario accede a su lista de amigos y elimina un perfil.</td>
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
1.  Realiza GESTIONAR LISTA DE AMIGOS.
2.  El usuario hace clic en eliminar.<br><br>
3.  El sistema confirma que quiere eliminar.<br><br>
4.  El sistema elimina al amigo.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario ve los amigos que tiene y accede a su perfil público.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
      4. El sistema no puede eliminar al amigo
      </td>
</table>



<br>



<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-8</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>MODIFICAR USUARIOS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El administrador modifica los usuarios de la aplicación.</td>
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
3.  El administrador hará clic en el usuario deseado y hace clic en modificar usuario.<br><br>
3.  El administrador modifica los campos deseados y hace clic en aceptar.<br><br>
4.  Se realiza la modificación correctamente.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>Se modifica el usuario deseado por el administrador.
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-9</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>SUSPENDER USUARIOS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El administrador suspende temporalmente a usuarios de la aplicación.</td>
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
3.  el administrador hará clic en el usuario deseado y hará clic en suspender temporalmente.<br><br>
4.  Se realiza la suspensión correctamente.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>Se suspende temporalmente al usuario deseado por el administrador.
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-10</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ELIMINAR USUARIOS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Equipo</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El administrador elimina a un usuario de la aplicación.</td>
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
3.  el administrador hará clic en el usuario deseado y hace clic en eliminar.<br><br>
4.  Se realiza la eliminación correctamente.
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
Ninguna.
</td>
</table>

<br>

<a name="ARCHIVOS"></a>

<p align="center">
<img src=".\resources\DCU-Gestiondearchivos.png"/>
</p>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-11</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>SUBIR ARCHIVOS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Víctor</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario sube un archivo que podra descargar cualquier usuario de la plataforma. </td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Usuario/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  En la vista principal, el usuario hará clic en subir archivo.<br><br>
2.  Se abrira una pequeña ventana donde se especificará la ruta del archivo.<br><br>
3.  El archivo se subirá al servidor.<br><br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario consigue subir el archivo al servidor para los demas usuarios.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
3.1 Ocurre un error en la conexion.<br><br>
3.2 No es posible subir el archivo debido a su tamaño.
</td>
</table>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-12</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>BAJAR ARCHIVOS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Víctor</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Se accede a la pantalla de ficheros donde el usuario podrá ver y descargar un archivo del servidor.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Usuario/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  En la vista principal, el usuario hará clic en ver archivos.<br><br>
2.  Se abrirá una nueva pantalla donde podrá ver los archivos subidos.<br><br>
3.  El usuario hará clic en descargar en el archivo deseado.<br><br>
4.  El archivo se descargará correctamente.<br><br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario consigue subir el archivo al servidor para los demas usuarios.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
4.1 Ocurre un error en la conexion.<br><br>
4.2 No es posible descargar el archivo debido a que está dañado.
</td>
</table>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-13</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ELIMINAR ARCHIVOS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Víctor</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Se accede a la pantalla de ficheros donde el usuario podrá ver y eliminar un archivo suyo del servidor.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Usuario/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta, acceder a la misma y ser dueño del archivo subido.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  En la vista principal, el usuario hará clic en ver archivos.<br><br>
2.  Se abrirá una nueva pantalla donde podrá ver los archivos subidos.<br><br>
3.  El usuario hará clic en eliminar en el archivo deseado.<br><br>
4.  El archivo se eliminará correctamente.<br><br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario consigue eliminar el archivo del servidor.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
4.1 Ocurre un error en la conexion.<br><br>
4.2 No es posible eliminar el archivo debido a que no ha sido subido por él.
</td>
</table>


<br>

<a name="CHATS"></a>

<p align="center">
<img src=".\resources\DCU-gestiondechats.png"/>
</p>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-14</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>CREAR CHAT</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Víctor</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Se accede a la vista de creación de chat donde se seleccionará un nombre y se agregaran a los amigos que quiera y tenga el usuario.</td>
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
1.  El usuario hace clic en crear chat.<br><br>
2.  Se abre una nueva vista que pide al usuario que introduzca un nombre del canal y que introduzca a los amigos que quiera agregar al canal.<br><br>
3.  El usuario introduce los datos.<br><br>
4.  El sistema crea el chat con las personas seleccionadas por el usuario y la añade a la vista de chats.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario crea el chat para chatear correctamente.
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-15</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>UNIRSE A UN CHAT</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Víctor</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Se accede a la vista de chat eligiendo el chat correspondiente.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta, acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  En la lista de chats estando en la vista principal, el usuario selecciona el que quiera.<br><br>
2.  Se abre la vista chat con la conversación anterior si hubiera.<br><br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario se une al chat.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
2. No pudo abrirse la vista chat, se especifica el error al usuario.
</td>
</table>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-16</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ENVIAR/RECIBIR MENSAJES</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Víctor</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Desde la vista chat, el usuario envia y recibe mensajes.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta, acceder a la misma y haberse unido a un chat previamente.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1. El usuario introduce el mensaje en la barra de mensajes y lo envía pulsando el botón de enviar.<br><br>
2.  El sistema envía el mensaje al chat.<br><br>
3.  Se envía satisfactoriamente el mensaje.
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
3. El mensaje no puede enviarse y el sistema notifica al usuario.
</td>
</table>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-17</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ABANDONAR CHAT</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Manuel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario abandona el chat que quiera.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta, acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  En la lista de chats estando en la vista principal, el usuario selecciona el que quiera.<br><br>
2.  Una vez abierto el chat, el usuario hace clic en abandonar chat.<br><br>
3.  El sistema elimina al usuario del chat.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario abandona el chat.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
3. Error del sistema al echar al usuario.
</td>
</table>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-18</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ELIMINAR CHAT</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Manuel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario elimina un chat que creó previamente.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Cliente/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta, acceder a la misma y haber creado una cuenta.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  En la lista de chats estando en la vista principal, el usuario selecciona el que quiera.<br><br>
2.  Una vez abierto el chat, el usuario hace clic en eliminar chat.<br><br>
3.  El sistema comprueba que el usuario es el creador del chat.<br><br>
3.  El sistema elimina el chat.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario elimina el chat.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
4. Error al eliminar el chat, el usuario no es el creador del chat.
</td>
</table>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-19</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>MODIFICAR CHAT</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Manuel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El administrador modifica mensajes y elimina cualquier chat.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El administrador hace clic en el chat que desee en la vista principal de la aplicación.<br><br>
2.  El administrador gestiona el chat modificando lo que vea conveniente..<br><br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El administrador gestiona un chat.
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-20</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>CONSULTAR CHATS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Manuel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario consulta los chats ya creados.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Usuario/Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El usuario hace clic en consultar chats en la vista principal de la aplicación.<br><br>
2.  El sistema devuelve la lista de chats disponibles.<br><br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario consulta los chats.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
Ninguna.
</td>
</table>

<a name="EVENTOS"></a>

<p align="center">
<img src=".\resources\DCU-Gestióndeeventos.png"/>
</p>

<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-21</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>DAR DE ALTA UN EVENTO</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Manuel</td>
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-22</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ELIMINAR UN EVENTO</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Manuel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario elimina un evento.</td>
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
1.  Realiza Consultar eventos.<br><br>
2.  El usuario selecciona un evento en la vista de eventos.<br><br>
3.  El usuario hace clic en eliminar evento.<br><br>
4.  El evento se eliminará correctamente
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario elimina un evento correctamente.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
3. Error del sistema al eliminar un evento.
</td>
</table>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-23</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>CONSULTAR EVENTOS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Manuel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario consulta los datos de los eventos.</td>
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
1.  El usuario hace clic en cosultar eventos. <br><br>
2.  Se le devuelve una lista con los eventos creados por el usuario.<br><br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario consulta un evento correctamente.
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-24</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>MODIFICAR EVENTO</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Miguel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario modifica los datos de un evento.</td>
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
1.  Realiza Consultar eventos.<br><br>
2.  El usuario hace clic en el evento que quiera de la vista de eventos. <br><br>
3.  Se abrirá una ventana con los datos del evento.<br><br>
4.  El usuario hace clic en modificar evento.
5.  El usuario introduce los datos en sus respectivos campos.<br><br>
6.  El evento se modificará correctamente.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario modifica un evento correctamente.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
5. Error al introducir algún campo.
</td>
</table>


<br>

<a name="PETICIONES"></a>

<p align="center">
<img src=".\resources\DCU-gestiondepeticiones.png"/>
</p>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-25</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ENVIAR UNA PETICIÓN AL ADMINISTRADOR</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Miguel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario manda un mensaje de incidencia o petición al administrador.</td>
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
2.  Se abrirá una nueva vista en la que se le pedirá que indique su problema o petición y detalle el mismo.<br><br>
3.  El usuario introduce los datos.<br><br>
4.  El sistema envía la petición a la base de datos donde se guardará.
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
5.1 El sistema notifica al usuario que no se ha podido enviar la incidencia y que lo intente más tarde.
5.2 El sistema notifica que ha alcanzado el cupo de peticiones al dia que puede enviar.
</td>
</table>


<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-26</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>CONSULTAR PETICIONES ENVIADAS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Miguel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El usuario consulta las peticiones enviadas al administrador y su estado.</td>
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
1.  El usuario hace clic en ver peticiones/incidencias enviadas en la vista principal de la aplicación.<br><br>
2.  Se abrirá una nueva vista en la que se le mostrará las peticiones enviadas previamente y su estado.<br><br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario ve las incidencias correctamente.
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-27</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>CONSULTAR PETICIONES RECIBIDAS</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Miguel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El administrador consulta las peticiones recibidas de los usuarios.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El administrador hace clic en ver peticiones/incidencias recibidas en la vista principal de la aplicación.<br><br>
2.  Se abrirá una nueva vista en la que se le mostrará las peticiones recibidas.<br><br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El administrador ve las peticiones recibidas.
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-28</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ENVIAR UNA RESPUESTA A LA PETICION</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Miguel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El administrador responde las peticiones recibidas de los usuarios.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El administrador hace clic en ver peticiones/incidencias recibidas en la vista principal de la aplicación.<br><br>
2.  Se abrirá una nueva vista en la que se le mostrará las peticiones recibidas.<br><br>
3. El administrador selecciona responder.<br><br>
4. Se abrira una pequeña ventana donde podrá escribir un mensaje que recibirá el usuario de la peticion.<br><br>
5. El mensaje se envia correctamente.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El administrador envia una respuesta a las peticiones de los usuarios.
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

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-29</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>ELIMINAR PETICION</td>
  </tr>
  <tr>
  <td><b>Equipo/Individual<b></td>
  <td>Miguel</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>El administrador elimina las peticiones recibidas de los usuarios.</td>
  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Administrador</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Tener una cuenta y acceder a la misma.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>
1.  El administrador hace clic en ver peticiones/incidencias recibidas en la vista principal de la aplicación.<br><br>
2.  Se abrirá una nueva vista en la que se le mostrará las peticiones recibidas.<br><br>
3. El administrador selecciona eliminar.<br><br>
5. La peticion se elimina correctamente y el sistema le pasa el estado concluido al usuario.
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El administrador elimina las peticiones de los usuarios.
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>
Ninguna.
</td>
</table>





<a name="8"></a>
## ACTIVIDAD 5: MODELO DE OBJETOS DEL NEGOCIO.



<br>

### Diagrama de clases


#### Diagrama de clase del modelo del servidor
<p align="center">
<img src="./resources/diagrama-clases-modelo.png"/>
</p>


#### Diagrama de clase de la vista de escritorio
<p align="center">
<img src="./resources/diagrama-clases-vistas.png"/>
</p>
<br>

#### Diagrama Controladores




### Descripción del diagrama de clases
<br>
#### Plantilla clases
<br>

<table>

<tr>
<td>  Nombre de la clase  </td>
<td>Chat</td>	
</tr>

<tr>
<td>  Descripción  </td>
<td>En esta tabla se registrarán los usuarios los cuales participan en dicho chat y se le adjudicará el historial de mensajes que será de tipo mensaje</td>
</tr>

<tr> 
<td> Relaciones </td>
<td>Tendrá relación 1-1 con Mensaje y 0N-01 con Usuario	</td>
</tr>
	
<tr>
<td>  Atributos  </td>
<td>Id/Nombre/Usuarios/Historial</td>	
</tr>

<tr>
<td>  Atributos propios de la clase  </td>
<td>Id/Nombre</td>
</tr>

<tr> 
<td> Atributos propios de la relación </td>
<td>Usuarios/Historial</td>
</tr>

<tr>
<td>  Métodos  </td>
<td>  Getters y Setter  </td>	
</tr>

<tr>
<td>  Función  </td>
<td>   Devolver y establecer valores de los atributos</td>
</tr>	
</table>

<br>

### Modelo de datos 

<p align="center">
<img src="./resources/modelo_datos_gamerHub.png"/>
</p>




<br>
<a name="9"></a>

## ACTIVIDAD 6: INTERFAZ GRÁFICA.

### Interfaz WEB con ADOBE XD
<br>
<p align="center">
<img src="./resources/loginInterfazWeb.PNG"/>
</p>
<p align="center">
<img src="./resources/crearCuentaInterfazWeb.PNG"/>
</p>
<p align="center">
<img src="./resources/modificarCuentaInterfazWeb.PNG"/>
</p>
<p align="center">
<img src="./resources/homeInterfazWeb.PNG"/>
</p>

<br><br>

### Interfaz ESCRITORIO con Scene Builder
#### Vista inicio
<p><img src="./resources/vista-inicio.png"/></p>
#### Vista home
<p><img src="./resources/vista-home.png"/></p>
#### Vista perfil
<p><img src="./resources/vista-perfil.png"/></p>
#### Vista registro
<p><img src="./resources/vista-registro.png"/></p>
#### Vista evento
<p><img src="./resources/vista-evento-dialog.png"/></p>
#### Vista ayuda
<p><img src="./resources/vista-ayuda-dialog.png"/></p>
