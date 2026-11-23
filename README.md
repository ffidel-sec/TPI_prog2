# TPI_prog2
Sistema de Turnos Médicos
Trabajo Práctico Integrador de Programación II.

Es una aplicación de consola hecha en Java que permite reservar turnos en un centro médico.

¿Qué hace?
El paciente se identifica con su DNI.
Si no existe, se registra en ese momento.
Elige un servicio (por ejemplo, "Consulta clínica").
Ingresa la fecha en la que quiere el turno.
El sistema muestra los horarios disponibles para ese día.
El paciente elige un horario y el turno queda reservado.
El médico no lo elige el paciente: el sistema le asigna uno de los que atienden ese servicio y están libres en ese horario.

Además, desde el menú se pueden:

ver todos los turnos,
ver solo los activos,
ver solo los cancelados,
cancelar un turno por su id.
Tecnologías
Java 17
Maven
MySql (JDBC)
Cómo ejecutarlo
Primero tiene que estar creada la base sistema_turnos en MySql, con los datos de especialidades, servicios, médicos y franjas horarias.

La conexión a la base está configurada en DAOs/ConexionBD.java.

Organización del código
Paquete	Qué contiene
Models	Las clases del dominio: Paciente, Medico, Servicio, Turno, etc.
Views	Todo lo que se muestra y se pide por consola.
Controllers	La lógica de negocio (los gestores).
DAOs	Las consultas a la base de datos.
La idea es que cada capa tenga una sola responsabilidad: la vista no sabe de SQL, el DAO no sabe de pantallas y el gestor coordina a los dos.

Autores
Mateo Briguera, Fidel Grando y Nicolas Piñan.

Repositorio:
https://github.com/ffidel-sec/TPI_prog2

Usuarios de Git:

https://github.com/ffidel-sec/ 
https://github.com/nicolaspinan/ 
https://github.com/Utsusis/
