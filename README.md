# Challenge: Prueba Backend
 
 Api Rest modulo de carrito de compras
 
 ## Uso de API

Link de collection Postman (local): https://www.getpostman.com/collections/5359328c54e58f07a532

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
 
 ### Servicio para agregar un producto a un carrito:
 
 Agrega un producto a un carrito, si dentro del body enviamos el identificador del carrito 
 agrega el producto. Si no enviamos el identificador del carrito se crea un carrito. 
 
 - **URL: URL_BASE/shopping-carts**
- **Method:** POST
- **Body:** JSON :

```javascript
{
 "productId" : "ae1f3879-cac5-40b4-af22-bfe90d2e2aea"
}
```

Ejemplo con carrito ya creado

```javascript
{
 "shoppingCartId": "cacd1813-20f2-4ad0-bcb1-03ea04b8ece8",
 "productId" : "ae1f3879-cac5-40b4-af22-bfe90d2e2aea"
}
```

 - **Respuesta Ejemplo:** 

```javascript
{
 "shoppingCartId": "cacd1813-20f2-4ad0-bcb1-03ea04b8ece1",   ----> Lo usaremos para identificar este recurso
 "name": "Martillo carpintero",
 "sku": "TALAD-XYZ-JKL-99",
 "description": "Martillo carpitenro de acero",
 "price": 1800.35,
 "quantity": 5,
 "hasDiscount": true
}
```

 ### Servicio obtener todos los productos de un carrito:
 
Devuelve una lista de todos los productos en base el identificador del carrito

- **URL: URL_BASE/shopping-carts/{shoppingCartId}**
- **Method:** GET

 - **Respuesta Ejemplo:** 

```javascript
[
 {
  "name": "Martillo carpintero",
  "sku": "TALAD-XYZ-JKL-99",
  "description": "Martillo carpitenro de acero",
  "price": 1800.35,
  "quantity": 5,
  "hasDiscount": true
 }
]
```

 ### Servicio modificar la cantidad de un producto del carrito:
 
 Modifica la cantidad de un producto en base al identificador del carrito
 
- **URL: URL_BASE/shopping-carts/{shoppingCartId}**
- **Method:** PUT
- **Body:** JSON :
 
```javascript
{
 "productId": "ae1f3879-cac5-40b4-af22-bfe90d2e2aea",   ----> identificador del producto a modificar
 "quantity": 10
}
```
 - **Respuesta Ejemplo:** 

```javascript
 {
  "shoppingCartId": "cacd1813-20f2-4ad0-bcb1-03ea04b8ece1",
  "name": "Martillo carpintero",
  "sku": "TALAD-XYZ-JKL-99",
  "description": "Martillo carpitenro de acero",
  "price": 1800.35,
  "quantity": 10,
  "hasDiscount": true
 }
```

 ### Servicio eliminar un producto del carrito:
 
 Eliminar un producto en base al identificador del carrito y del producto a modificar
 
 - **URL: URL_BASE/shopping-carts/{shoppingCartId/{productId}**
- **Method:** DELETE

 STATUS 200 -----> Recurso Eliminado
 
 STATUS 400 -----> Recurso no existente

 ### Servicio de checkout de un carrito:

- **URL: URL_BASE/shopping-carts/{shoppingCartId}/checkout**
- **Method:** GET

- **Respuesta Ejemplo:** 

```javascript
{
 "finalCost": 9001.75     ---> Los productos con descuento valen la mitad del precio al hacer checkout
}
```

_________________________________________________

 ### Uso local del proyecto:
 
 Herramientas necesarias: 
 
 - java 11 
 - gradle 7.1
 - git
 - kotlin 1.4.31

**Comandos para ejecutar localmente la aplicacion**

Una vez descargado el repositorio:

 - gradle build
 - gradle bootRun 

(puerto por defecto 8080)


