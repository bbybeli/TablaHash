Tabla Hash almacena pares clave-valor, usando encadenamiento (listas enlazadas) para manejar colisiones.

Estructura del proyecto
- "TablaHash.java" clase principal que implementa la tabla hash.  
-  'Entry' clase para representar cada entrada (clave, valor).  
-  'Main' clase para probar la tabla hash con lectura/escritura o ejemplo.

Función de esta implementación
1. Función hash 
   - Para cada clave, se calcula el índice con una función como 'hash(key) = key % tamañoTabla'.  
   - El tamaño de la tabla (número de contenedores) se define cuando se crea la tabla.  
2. Inserción 
   - Se obtiene el índice con la función hash.  
   - Se va al contenedor correspondiente.  
   - Si el contenedor está vacío, se crea un nuevo nodo con la clave y el valor.  
   - Si ya hay uno o más nodos (colisión), se añaden al final de la lista del contenedor.
3. Búsqueda 
   - Se calcula el índice con la función hash.  
   - Se recorre la lista del contenedor correspondiente hasta encontrar la clave.  
   - Si se encuentra, retorna el valor. Si no, retorna “no encontrado” (o 'null', según implementación).



