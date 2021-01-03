<p align="center">
<img src="/resources/cabecera.png"/>
</p>

# <p align="center">PROYECTO PSP 20/21</p>

## <p align="center">GAMER HUB</p>

<p align="center">
<img src="/resources/gamerhublogo.png"/>
</p>


<br>
<br>


# <p align="center">Índice</p>
> **[1. Licencia y Autores](#1)**<br>
> **[2. Presentación](#2)**<br>

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

¡Hola! Somos el equipo 3, formado por los alumnos Manuel Santos y Víctor Ruiz.
Somos estudiantes de 2º curso de ciclo FP superior DAM y este es un proyecto
que estamos realizando para la asignatura de PSP en el I.E.S Ramón del Valle Inclán.


# FASE 1: ANÁLISIS Y DISEÑO

<br>

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


## ACTIVIDAD 2: REQUISITOS FUNCIONALES. DEFINICIÓN DEL PROBLEMA.


1. <b>TÍTULO: </b> GAMER HUB
2. <b>RESUMEN: </b> 


<br>


## ACTIVIDAD 3: ENTORNO DE TRABAJO

1.  Lenguaje: Java.
2.  Entorno de Desarrollo: IntelliJ.
3.  Control de versiones: GitHub Classroom
4.  Arquitectura MVC.
5.  Maven.
<br>


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


## ACTIVIDAD 5: MODELO DE OBJETOS DEL NEGOCIO.


<br>

### Modelo de datos 

<p align="center">
<img src="/resources/modelo_datos_gamerHub.png"/>
</p>



<br>


## ACTIVIDAD 6: INTERFAZ GRÁFICA.
