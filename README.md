<h3> Requisitos </h3>
Para ejecutar localmente el proyecto se deben tener en cuenta los siguientes aspectos: <br>
<strong> -Variables de entorno:  </strong>
 Se deben tener configuradas las variables de Maven (M2 y M2_HOME) y en la variable Path también deben estar debidamente agregadas. <br>
<strong> -Java: </strong>
 La versión de Java que se requiere es la 17. La variable JAVA_HOME debe estar apuntando al jdk de la versión 17. <br>
<strong>  -Base de datos: </strong>
 El proyecto utiliza MySQL como base de datos. <br>
 En el archivo application.properties se configuró spring.jpa.hibernate.ddl-auto=update; con lo cual, al ejecutar el proyecto y hacer una petición, se creará       automáticamente la base de datos. Sin embargo, en la ruta src/static/sql también se encuentra el script de la base de datos. <br>

 <h3> Ejecutar Proyecto </h3>
 Para ejecutar el proyecto, se debe ejecutar en una consola el comando ./mvnw spring-boot:run <br>

  <h3> Realizar peticiones </h3>
 En el repositorio se encuentra una colección de Postman donde se encuentran unos ejemplos de las peticiones que se pueden realizar para consumir el api y obtener los resultados de cada ejercicio.
