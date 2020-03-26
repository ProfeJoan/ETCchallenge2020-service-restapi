# Microservice ETCchallenge2020-service-restapi

[Autor JOAN]()

## Espero que disfrute de este proyecto!
### Pero, antes revisemos un par de cosas que debe saber...

## JNDI, JPA, EJB
Por defecto este proyecto usa para su persistencia de objetos JTA y un JNDI seteado en su unidad de persistencia.

**Si gusta** y para ayudar puede [descargar aquí un servidor WildFly](https://drive.google.com/file/d/1cadZKiPyuUjQy0Brrlr7YparvwZke9rZ/view?usp=sharing) con **todo listo**: el datasource, el driver PostgreSQL y hasta un deployment del proyecto ya incluidos.

## PostgreSQL es la base de datos
Por defecto esa es la base de datos configurada en el datasource anteriormente mencionado y usa el esquema **etcchallenge2020** con el usuario: **jo** y la contraseña: **jo**
Para ayudar, los siguientes son los scripts de creación tanto del esquema, el usuario así como de las tablas:
```postgres=# CREATE DATABASE etcchallenge2020;
postgres=# CREATE USER jo PASSWORD 'jo';

user@PC:~$ psql -d etcchallenge2020 -U jo

CREATE TABLE usuarios
(
 id varchar(30) NOT NULL,
 contrasena varchar(50) NOT NULL,
 perfil varchar(30) NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE clientes
(
 id varchar(30) NOT NULL,
 nombre varchar(100) NOT NULL ,
 correo varchar(80) DEFAULT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE parqueos
(
 id varchar(30) NOT NULL,
 nombre varchar(100) NOT NULL,
 telefono varchar(30) DEFAULT NULL,
 ubicacion varchar(300) DEFAULT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE facturas
(
 id varchar(30) NOT NULL,
 id_cliente varchar(30) REFERENCES clientes (id),
 id_parqueo varchar(30) REFERENCES parqueos (id),
 monto numeric NOT NULL,
 PRIMARY KEY (id)
);
```

## ¿Qué más debe saber...?
Pues nada, solo detalles como que este es proyecto Maven y un microservicio con el plugin de Thorntail de hecho creado en primera instancia desde su [GENERATOR](https://thorntail.io/generator/).

Así también el proyecto contiene las pruebas unitarias de rigor con JUnit.

## Y para el final: ¿Hay algún frontend listo para consumir este RestAPI?
Pues claro, tan solo [ingresa acá](https://github.com/ProfeJoan/ETCchallenge2020-frontend-Angular9.git) y podrá encontrar un front diseñado en ***Angular9*** que aprovecha este RestAPI.

**Saludos cordiales.**
