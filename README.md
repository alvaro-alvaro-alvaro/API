# API

Este proyecto consiste en el desarrollo de una API REST utilizando Spring Boost.  
Se basa en mi práctica 2 anterior, es decir  una página web sobre la liga española de fútbol, que incluye información sobre clasificación, historia y un formulario para que los usuarios se registren y reciban noticias.

En la práctica anterior, desarrollé una web compuesta por varias páginas:

- index.html: Página principal de bienvenida a la web
- pagina1.html: Muestra una clasificación con los equipos de la liga
- pagina2.html: Contiene un video sobre la historia de la liga
- pagina3.html: Incluye un formulario de registro donde el usuario introduce:
  - Nombre
  - Edad
  - Ciudad
  - Código Postal
  - DNI
  - Correo electrónico

La API REST desarrollada en esta práctica esta relacionada con dicha web, permite realizar operaciones sobre los datos que los usuarios introducirían en el formulario.

Este repositorio contiene dos carpetas principales:

- alvaro/
  
Es un proyecto desarrollado con Spring Boot. Contiene la API REST con las operaciones de creación, lectura, actualización y eliminación (CRUD).  

- p2-main/p2-main/
  
Contiene la página web de la práctica 2, incluyendo pagina3.html que está conectada con la API REST mediante JavaScript (fetch).  

La API REST permite realizar las 4 operaciones básicas (CRUD) sobre los registros de usuarios:

- Crear un usuario nuevo (POST)
- Leer los usuarios registrados (GET)
- Actualizar los datos de un usuario existente (PUT)
- Eliminar usuarios por ID (DELETE)

Estas operaciones se utilizan para gestionar los datos que los usuarios introducirían en el formulario de la página web.

A través del método GET en la ruta /api/usuarios, se pueden obtener todos los usuarios almacenados.

Con el método POST en la misma ruta /api/usuarios, se puede registrar un nuevo usuario enviando sus datos en formato JSON, incluyendo nombre, edad, ciudad, código postal, DNI y correo electrónico.

Para actualizar un usuario existente, se utiliza el método PUT en la ruta /api/usuarios/{id}. En este caso, también se debe enviar el cuerpo de la petición con los nuevos datos del usuario.

Finalmente, con el método DELETE y la ruta /api/usuarios/{id}, se puede eliminar un usuario de la base de datos indicando su ID.

Cada una de estas rutas responde con distintos códigos según el resultado de la operación, como 200 OK si todo ha salido bien, 201 Created si se ha creado un recurso correctamente, o 404 Not Found si el usuario no existe.


EJEMPLO

Si queremos ver todos los usuarios registrados, usamos el método GET. En Postman, pondríamos lo siguiente:

- Método: GET

- URL: http://localhost:8080/api/usuarios

- No hay que escribir nada en el cuerpo.

Al darle a “Send”, nos devolverá una lista de usuarios en formato JSON. Si aún no hay ninguno, devolverá una lista vacía ([]).

Si queremos añadir un nuevo usuario, hacemos una petición POST. Por ejemplo,queremos registrar a un usuario llamado Álvaro que tiene 20 años, vive en Madrid, con código postal 28001, DNI 12345678Z y su correo es alvaro@email.com.

- Método: POST

- URL: http://localhost:8080/api/usuarios

- Escribimos esto en el cuerpo:

{
  "nombre": "Álvaro",
  
  "edad": 20,
  
  "ciudad": "Madrid",
  
  "codigoPostal": "28001",
  
  "dni": "65783412P",
  
  "correo": "alvaro@email.com"
}

Cuando pulsamos “Send”, la API responderá con el mismo usuario, pero ya con un campo id añadido automáticamente.

Si queremos modificar ese usuario usamos el método PUT indicando su ID.

- Método: PUT

- URL: http://localhost:8080/api/usuarios/1

- En el cuerpo JSON ponemos los datos actualizados, así:

{
  "nombre": "Álvaro Modificado",
  
  "edad": 21,
  
  "ciudad": "Barcelona",
  
  "codigoPostal": "08001",
  
  "dni": "98765432A",
  
  "correo": "nuevo@email.com"
}

La respuesta será el usuario actualizado, con los nuevos valores y el mismo ID.
