INSERT INTO GRANJA(ID, DINERO_EN_CAJA, ULTIMA_ACTUALIZACION)
VALUES(1, 300000, '2023-12-12');


INSERT INTO TIPOS_ANIMALES (ID,  ANIMAL,  CANTIDAD_MAXIMA,  DIAS_EXPIRACION, TIEMPO_DE_REPRODUCCION, PRECIO_COMPRA, PRECIO_VENTA, GRANJA_ID)
VALUES(1, 'HUEVO', 10000, 21, 21, 10, 20, 1);
INSERT INTO TIPOS_ANIMALES ( ID,  ANIMAL,  CANTIDAD_MAXIMA,  DIAS_EXPIRACION, TIEMPO_DE_REPRODUCCION, PRECIO_COMPRA, PRECIO_VENTA, GRANJA_ID)
VALUES(2, 'POLLO', 10000, 1000,1, 200, 5000, 1);
INSERT INTO TIPOS_ANIMALES ( ID,  ANIMAL,  CANTIDAD_MAXIMA,  DIAS_EXPIRACION, TIEMPO_DE_REPRODUCCION, PRECIO_COMPRA, PRECIO_VENTA, GRANJA_ID)
VALUES(3, 'CHANCHO', 1000, 1300, 20, 1500, 50000, 1);
INSERT INTO TIPOS_ANIMALES ( ID,  ANIMAL,  CANTIDAD_MAXIMA,  DIAS_EXPIRACION, TIEMPO_DE_REPRODUCCION, PRECIO_COMPRA, PRECIO_VENTA, GRANJA_ID)
VALUES(4, 'VACA', 100, 1000, 27, 2000, 80000, 1);

INSERT INTO ANIMAL (ID, EDAD_EN_DIAS_AL_INGRESAR, FECHA_INGRESOAGRANJA, GRANJA_ID, TIPOS_ANIMAL_ID, PRECIO_COMPRA, PRECIO_VENTA)
VALUES (1, 5, '2023-02-02', 1, 1, 0, 0);

INSERT INTO ANIMAL (ID, EDAD_EN_DIAS_AL_INGRESAR, FECHA_INGRESOAGRANJA, GRANJA_ID, TIPOS_ANIMAL_ID, PRECIO_COMPRA, PRECIO_VENTA)
VALUES (2, 5, '2023-01-01', 1, 1, 0, 0);

INSERT INTO ANIMAL (ID, EDAD_EN_DIAS_AL_INGRESAR, FECHA_INGRESOAGRANJA, GRANJA_ID, TIPOS_ANIMAL_ID, PRECIO_COMPRA, PRECIO_VENTA)
VALUES (3, 5, '2023-01-01', 1, 2, 0, 0);


INSERT INTO COMPRA (ID, FECHA, NOMBRE_PERSONA, GRANJA_ID)
VALUES (1, '2023-02-02', 'Marina', 1);
