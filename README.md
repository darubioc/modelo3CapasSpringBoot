# modelo3CapasSpringBoot

1. Crear un esquema en oracle con su respectiva contraseña (tener en cuenta ambos para la conexión en spring boot, éstos deben reemplazarse en el application.properties).
2. Conceder permisos mediante los siguientes comandos:
  Alter user *NOMBRE_DE_SU_ESQUEMA* unlimited users;
  Grant all privileges to *NOMBRE_DE_SU_ESQUEMA*;
3. Crear tabla de nombre "Clientes" con las siguientes columnas:
  -ID : NUMBER(38,0)
  -NOMBRE : VARCHAR2(100)
  -APELLIDO : VARCHAR2(100)
  -EMAIL : VARCHAR2(100)
  -CREATEAT : DATE
4. Insertar datos en la tabla "Clientes", puede usarse los siguientes comandos para tal fin:
  INSERT INTO CLIENTES (ID ,NOMBRE ,APELLIDO ,EMAIL ,CREATEAT )VALUES(1,'Ramiro','Vasquez','r@hotmail.com','1/may/2018');
  INSERT INTO CLIENTES (ID ,NOMBRE ,APELLIDO ,EMAIL ,CREATEAT )VALUES(2,'Carlos','Rodriguez','c@hotmail.com','1/may/2018');
  INSERT INTO CLIENTES (ID ,NOMBRE ,APELLIDO ,EMAIL ,CREATEAT )VALUES(3,'Jaime','Castro','j@hotmail.com','1/may/2018');
  INSERT INTO CLIENTES (ID ,NOMBRE ,APELLIDO ,EMAIL ,CREATEAT )VALUES(4,'Ricardo','Sanchez','r@gmail.com','1/may/2018');
6. Modificar el esquema y la contraseña en el properties (si no se hizo en el paso 1):
  #Basic Spring Boot Config for Oracle
  spring.datasource.url= jdbc:oracle:thin:@//localhost:1521/xepdb1
  spring.datasource.username=*NOMBRE_DE_SU_ESQUEMA*
  spring.datasource.password=*CONTRASEÑA_DE_SU_ESQUEMA*
7. Instalar proyecto spring boot, y ejecutar.
8. Probar endpoints usando la colección de postman facilitada, o siguiendo las siguientes rutas:
   Obtener listado de clientes                    GET   localhost:9200/api
   Obtener un cliente en específico según su id   GET   localhost:9200/api/{id} ejemplo: localhost:9200/api/2
   Crear un cliente                               POST  localhost:9200/api/save
      -> Definir un body tipo JSON del siguiente tipo:
        {
            "id": 2,
            "nombre": "Carlos Alberto",
            "apellido": "Ramiro Ramirez",
            "email": "carr@hotmail.com",
            "createAt": "2018-06-01T05:00:00.000+00:00"
        }
   Actualizar un cliente parametrizando su ID     PUT   localhost:9200/api/2
      -> Definir un body tipo JSON del siguiente tipo:
        {
            "id": 2,
            "nombre": "Carlos Alberto",
            "apellido": "Ramiro Ramirez",
            "email": "carr@hotmail.com",
            "createAt": "2018-06-01T05:00:00.000+00:00"
        }
   Eliminar un registro parametrizando su ID      DELETE localhost:9200/api/{id} ejemplo:localhost:9200/api/2
