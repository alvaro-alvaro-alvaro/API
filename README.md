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

Para actualizar un usuario existente, se utiliza el método PUT en la ruta /api/usuarios/id. En este caso, también se debe enviar el cuerpo de la petición con los nuevos datos del usuario.
Finalmente, con el método DELETE y la ruta /api/usuarios/id, se puede eliminar un usuario de la base de datos indicando su ID.

Cada una de estas rutas responde con distintos códigos según el resultado de la operación, como 200 OK si todo ha salido bien, 201 Created si se ha creado un recurso correctamente, o 404 Not Found si el usuario no existe.

