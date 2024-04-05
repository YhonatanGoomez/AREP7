# APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES

Una solución integral para garantizar el acceso seguro desde el navegador a la aplicación web, manteniendo la autenticación, autorización e integridad de los usuarios. Diseñado para facilitar una comunicación segura entre computadoras y proteger el acceso a servicios remotos mediante autenticación y autorización rigurosas.

## Getting Started

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para fines de desarrollo y pruebas. Consulta la sección de despliegue para obtener notas sobre cómo desplegar el proyecto en un sistema en vivo.

### Prerequisites

Antes de comenzar, necesitarás instalar el siguiente software:

- Git
- Maven
- Spark
- Java

# Installing

Sigue estos pasos para configurar tu entorno de desarrollo en las dos instancias de AWS:

## Github y Java

En ambas instancias instalaremos github para así poder clonar nuestro repositorio, además que también tendremos Java en ambas virtualizaciones 

#### Instalacion de git:

```bash
sudo yum install -y git
```

![img_1.png](img/img_1.png)

#### Instalacion de java:

```bash
sudo yum install -y java-17-amazon-corretto-devel
```

![img_2.png](img/img_2.png)

#### Instalacion de Maven:

```bash
sudo yum install maven
```

![img_5.png](img/img_5.png)


## Clona el repositorio
git clone https://github.com/YhonatanGoomez/AREP7.git


cd /AREP7

![img_3.png](img/img_3.png)
# Instala las dependencias del proyecto
`mvn compile install`

# Ejecuta el servidor de desarrollo
En la primera instancia ejecutaremos el siguiente comando:

```bash
java -cp "target/classes:target/dependency/*" org.example.controllers.Login
```
Y en la segunda instancia ejecutaremos el siguiente comando:
```bash
java -cp "target/classes:target/dependency/*" org.example.controllers.MainPage
```

Después de seguir estos pasos, podrás acceder a la aplicación en `http://localhost:5000`.

Sin embargo, en el navegador copiaremos la URL de la instancia en la que se usó el Login con el user y password para ambos: admin



## Deployment

Para desplegar este proyecto en un sistema en vivo, sigue las instrucciones específicas de tu proveedor de hosting o servidor de aplicaciones.


## Built With
- **Java** - Lenguaje con el cual funciona la mayor parte del proyecto
- **Html** - Usado para la sección del cliente
- **JavaScript** - Este lenguaje le permite al cliente realizar las peticiones necesarias
- **Maven** - Usado para la construcción de la estructura del proyecto
- **Git** - Usado para el versionamiento
- **Docker** - Es un software que permite crear imágenes y correr contenedores
- **Spark** - Framework con el cual se realizó el API
- **AWS** - Plataforma de servicios en la nube que maneja almacenamiento, bases de datos, análisis, inteligencia artificial, aprendizaje automático, Internet de las cosas (IoT), seguridad y mucho más.


## Arquitectura


Este sistema dedicado a la verificación de identidades atiende requerimientos cifrados en el puerto 5000, respaldado por un certificado SSL para la seguridad en el intercambio de datos. Está configurado para procesar solicitudes tipo POST bajo la ruta /login y establece conexión con la página principal, MainPage, para su funcionamiento integral.

![img_4.png](img/img_4.png)

## Authors

- **Yhonatan Steven Gómez Jiménez**

Consulta también la lista de contribuyentes que participaron en este proyecto.

## License

Este proyecto está licenciado bajo la Licencia MIT - vea el archivo `LICENSE.md` para detalles.

## Acknowledgments

- Consejo a cualquiera cuyo código fue usado
- Inspiración
- etc

## Prueba y Despliegue en AWS

https://www.youtube.com/watch?v=tW3ayCe5imc