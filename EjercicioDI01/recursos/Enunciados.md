### **AVA — Enunciados E1**

**Autor:** Rodrigo Gómez Pérez[1][2]

---

#### **1\. Jerarquía de clases (** **Equipo** **,** **Futbol** **,** **Baloncesto** **)**

Crear las siguientes clases. Prohibir crear objetos de la clase madre. Obligar a definir `showS` en todas las subclases. Crear dos objetos de cada subclase. Mostrar todos sus valores[1].

* **nombre** es un valor por argumento[1].
* **agnoFundacion** es un valor predefinido, siempre el mismo[1].
* **numChampions** es un valor aleatorio entre 2 y 15, ambos inclusive[1].
* **numEuroligas** lo escribe el usuario[1].

**Estructura de clases y métodos:**

* **Equipo** *(Clase madre)*[1][2]:
    * **Atributos:** `nombre`, `agnoFundacion`[1].
    * **Métodos:** `setNombre`, `setAgnoFundacion`, `getNombre`, `getAgnoFundacion`, `show`[1][2].
* **Futbol** *(Subclase)*[2]:
    * **Atributos:** `numChampions`[2].
    * **Métodos:** `setNumChampions`, `getNumChampions`, `showS`[2].
* **Baloncesto** *(Subclase)*[2]:
    * **Atributos:** `numEuroligas`[2].
    * **Métodos:** `setNumEuroligas`, `getNumEuroligas`, `showS`[2].

---

#### **2\. Manejo de archivos (** **Escribir.java** **y** **Leer.java** **)**

Crear `Escribir.java` y `Leer.java`[2].

1. **Escribir.java**: escribirá algo similar a la siguiente imagen en `archivo.xls`[2]:

| Monumento    | Continente |
| ------------ | ---------- |
| Chichen Itzá | América    |
| Coliseo      | Europa     |
| Keops        | África     |

1. **Leer.java**: leerá todo el contenido de `archivo.xls` y lo mostrará por consola[2].