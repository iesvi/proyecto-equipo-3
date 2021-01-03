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


# <p align="center">Índice:</p>

<br>

# LICENCIA Y AUTORES

Este material ha sido producido por <b>Manuel Santos</b> y <b>Victor Ruiz</b> bajo licencia Creative Commons.  

<br>

<p align="center">
<img src="/resources/cclogo.png" height="40" width="140"/>  
</p>

<br>

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


1. <b> 


<br>


## ACTIVIDAD 3: ENTORNO DE TRABAJO


<br>


## ACTIVIDAD 4: ANÁLISIS DE REQUISITOS FUNCIONALES. CASOS DE USO.


<br> 


## ACTIVIDAD 5: MODELO DE OBJETOS DEL NEGOCIO.


<br>

### Modelo de datos 

<p align="center">
<img src="/resources/modelo_datos_gamerHub.png"/>
</p>



<br>


## ACTIVIDAD 6: INTERFAZ GRÁFICA.
