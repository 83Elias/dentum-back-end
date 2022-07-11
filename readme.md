# Dentum Back-end Tutorial


## Pre-Requisitos para usar Dentum back-end

>######  Base de Datos

antes de usar dentum back-end asegurese
de tener instalado la base de datos **MYSQL**
en su maquina local, debe estar configurado
para que se ejecute por el puerto **3306**
de manera local.

el siguente paso es entrar a su base de datos
mysql y crear un nuevo  `schema` con el nombre
de dentoner para que spring jpa pueda crear las 
tablas en la base de datos.

el ultimo paso a realizar es dirigirse al 
**application.properties** y  modificar los 
siguentes atributos en base a su configuracion de mysql

```
spring.datasource.username= tu usuario de base de datos
spring.datasource.password= tu password de base de datos
```
en caso que su base de datos **MYSQL*** se ejecuta en un 
puerto diferente por favor modificar el siguente atributo
en el mismo archivo mencionado anteriormente

 `spring.datasource.url=jdbc:mysql://localhost:puerto/dentoner`



>######  Postman y Colecciones de Endpoints

asegurese de tener instalado postman, en la rais del
proyecto encontrara un archivo llamado:

**Dentoner.postman_collection.json**

este archivo usted lo debe de importar en su postman
este le instalara todos los endpoints del back-end
ya configurado


>######  Version de Java

asegurese tener instalado la version del jdk 11
de java en caso que no la tenga proceda a instalarlo
ya que el proyecto fue hecho usando java 11.


>######  Estructura del Proyecto

el proyecto se encuentra divido en muchas carpetas
las cuales tienen nombres descriptivos en base a su funcion


**Config:** contiene todas las configuraciones del proyecto para
         swagger y spring security.

**constant:** contiene todas las variables constantes del proyecto

**controller:** contiene todos los controlladores del proyectos

**dto:** con tiene todos los dto del proyecto

**exceptions:** contiene todas las excepciones personalizadas
del proyecto

**interfaces:** contiene todas las interfaces a implementar en el proyecto.

**jwt:** contiene una clase que sirve para adicionar informacion
a el token.

**model:** contienes todos las entidades del proyecto

**repository:** es la capa de acceso a base de datos

**service:** contiene toda la logica de negocio.

**util:** contiene las utilidades necesarias


>######  Como usar el proyecto?

tenga el cuenta que para usar los endpoints y acceder a los
recuros debe tener claro lo siguente:

el proyecto tiene todas las rutas protegidas
es decir es necesario estar autenticado y tener
un usuario **ADMIN** o **USER**.


las siguentes rutas no estan protegidas, es decir
son rutas **publicas** la cual no necesita estar autenticado
a continuacion en las colecciones de postman que debio
aver importado busque la carpeta **Auth**  y presione el request que dice **Register**.

**Request: localhost:8080/api/v1/customer/register**
este request se maneja con una peticion post, esta ruta
es publica y no requiere securidad, por la cual 
viene bien para crear los usuario o su usuario inicialmente.

"recuerde que el importar todas las colecciones de postman le da la ventaja de que ya esta toco configurado y con los json armados listo para enviar.
"

```
{
    "username": "celis232",
    "password": "Celis_CDMX232",
    "dni": "68885567",
    "roles": [
        {
            "id": 1,
            "name": "ROLE_ADMIN"
        }
    ]
}
```
el json de arriba le permite crear un usuario
si desea crear un usuario con un rol diferente
tenga en cuenta tener esto

1	ROLE_USER
"id":2	
"name":ROLE_ADMIN










