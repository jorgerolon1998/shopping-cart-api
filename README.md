﻿# Challenge: Prueba Backend
 
 Api Rest modulo de carrito de compras
 
 ## Uso de API

Link de collection Postman :

### Servicio que crea un producto: 

Crea un producto en base al body que recibe 

- **URL: URL_BASE/products**
- **Method:** POST
- **Body:** JSON :
```javascript
{
  "name": "Martillo Galponero",
  "sku": "PALA-XYZ-BLN-42",
  "description" : "Martillo Galponero Cabo de fibra con saca clavos",
  "price": 1000.0,
  "hasDiscount": true,
  "quantity": 3
}
```
 - **Respuesta Ejemplo:** 
  
```javascript
{
  "name": "Martillo Galponero",
  "sku": "PALA-XYZ-BLN-42",
  "description": "Martillo Galponero Cabo de fibra con saca clavos",
  "price": 1000.0,
  "quantity": 3,
  "hasDiscount": true,
  "id": "ae1f3879-cac5-40b4-af22-bfe90d2e2aea"  ----> Lo usaremos para buscar este recurso
}
```

### Servicio para obtener todos los productos registrados:

Devuelve una lista de todos los productos registrados

- **URL: URL_BASE/products**
- **Method:** GET

 - **Respuesta Ejemplo:** 

```javascript
[
  {
    "name": "Martillo Galponero",
    "sku": "PALA-XYZ-BLN-42",
    "description": "Martillo Galponero Cabo de fibra con saca clavos",
    "price": 1000.0,
    "quantity": 3,
    "hasDiscount": true,
    "id": "ae1f3879-cac5-40b4-af22-bfe90d2e2aea"
  }
]
```

### Servicio para obtener todos los productos registrados:

Modifica un producto en base al body

- **URL: URL_BASE/products/{productId}**
- **Method:** PUT
- **Body:** JSON :

```javascript
{
  "name": "Martillo carpintero",
  "sku": "TALAD-XYZ-JKL-99",
  "description": "Martillo carpitenro de acero",
  "price": 1800.35,
  "quantity" : 5,
  "hasDiscount": true
}
```
 - **Respuesta Ejemplo:** 

```javascript
{
  "name": "Martillo carpintero",
  "sku": "TALAD-XYZ-JKL-99",
  "description": "Martillo carpintero de acero",
  "price": 1800.35,
  "quantity": 5,
  "hasDiscount": true,
  "id": "ae1f3879-cac5-40b4-af22-bfe90d2e2aea"  -----> Registro modificado, lo vemos por el identificador
}
```

### Servicio para obtener todos los productos registrados:

Elimina un producto en base al identificador

- **URL: URL_BASE/products/{productId}**
- **Method:** DELETE

 STATUS 200 -----> Recurso Eliminado
 
 STATUS 400 -----> Recurso no existente
