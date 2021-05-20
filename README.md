# Proyecto-Prog-3r-Trimestre

**Práctica Libre 3r Trimestre - Java**

E1.	PARTE 1 (5 PUNTOS):

E2.	Crea un proyecto Java llamado Biblioteca.

E3.	En este caso la Biblioteca del CIFP FBMoll necesita un programa para poder gestionar la biblioteca. Para poder llevarlo a cabo se solicitan realizar:

a.	Una clase llamada **Libro**. Concretamente debemos almacenar: ISBN, título, autor, editorial, nº de copias y nº copias disponibles. Para esta clase debes crear constructor vacío, constructor con todos los parámetros, constructor copia, toString, getters/setters (DTO) y un contador de libros (que llevará el control de los diferentes libros que hay en la aplicación, por ejemplo, si tenemos el libro Javañol y de este libro tenemos 4 copias, nuestro contador de libro marcará un libro). Debe haber un control en el setter de manera que el número de copias inicial nunca debe ser menos de 1. Para esta clase además necesitaremos los siguientes métodos:

-	Añadir libro. Solicitará los datos para crear un libro y añadirá dicho libro a una lista de libros que recibirá como parámetro el método. (método static)

-	Eliminar libro. Solicitará al usuario un ISBN, lo buscará y lo eliminará de la lista que recibirá como parámetro el método. No se puede eliminar un libro que tiene reservas. (método static)

-	Buscar libro por ISBN. Pedirá al usuario un ISBN, lo buscará en la lista que recibirá como parámetro el método. En caso de encontrarlo devolverá la posición en la que se encuentra, en caso contrario devolverá -1. (método static)

-	Buscar libro por título. Pedirá al usuario un título, lo buscará en la lista que recibirá como parámetro el método. Mostrará cualquier libro que contenga la cadena buscada. (método static)

b.	Una clase llamada **Biblioteca**. Concretamente debemos almacenar: nombre de la biblioteca, lista de libros y lista de personal que gestiona la biblioteca. Para esta clase debes crear constructor vacío, constructor con todos los parámetros, constructor copia, toString, getters/setters (DTO). Debe haber un control en el setter de manera que el nombre de la biblioteca empiece en mayúsculas.

-	Mostrar libros. Imprimirá por pantalla toda la lista de libros. (método instancia)

-	Mostrar libros disponibles. Solo imprime la lista de los libros disponibles. (método instancia)

c.	Una clase llamada **Persona**. Concretamente debemos almacenar: nombre, apellidos, NIF, contraseña. Para esta clase debes crear constructor con todos los parámetros, constructor copia, toString, getters/setters (DTO) y un control de la contraseña que debe tener al menos 8 caracteres. Crea los métodos que consideres oportunos para poder añadir/eliminar personas que gestionarán la biblioteca (bibliotecarios).

E4.	Crea un menú (con switch), que permita gestionar la biblioteca dando soporte a todos los métodos que se han solicitado anteriormente. Puede ser interesante que haya varios menús, uno para gestionar el personal de la biblioteca y otro para gestionar las reservas.

E5.	PARTE 2 (5 PUNTOS):

a.	Crea la clase **Reserva**. Se caracteriza por: tener un Libro, fecha y hora de la reserva. Crea constructor vacío, todos los parámetros, copia, getters/setters y toString.

b.	Desarrolla (extiende) la clase **Persona**. Se caracteriza por: nombre, apellido1, apellido2, edad. Crea constructor vacío, todos los parámetros, copia, getters/setters y toString.

c.	Crea la clase **Usuario**. Heredará los atributos anteriores (Persona), pero además deseamos almacenar su teléfono, dirección, código postal, correo electrónico y lista de Reservas. Crea constructor vacío, todos los parámetros (incluidos los de la superclase), copia, getters/setters y toString (que imprimirá también los datos de la superclase). 

d.	Crea la clase **Bibliotecario**. Heredará los atributos anteriores (Persona), pero además deseamos almacenar su puesto de trabajo, NIF y contraseña. Crea constructor vacío, todos los parámetros (incluidos los de la superclase), copia, getters/setters y toString (NO imprimirá los datos de la superclase).

e.	Teniendo en cuenta lo anterior debemos tener en cuenta que ahora la clase Biblioteca tendrá una lista de tipo Persona, y en el que se almacenará tanto Usuarios como Bibliotecarios. Crea un método llamado solicitarDatosPersona de la clase Persona, que pide los datos y los va actualizando en la propia instancia que utiliza este método. Este método será sobreescrito por las clases hijas, de manera que además de hacer lo que hace el método de la clase padre, incluirá la solicitud de datos de las clases hijas. 

f.	Incluye en el menú, para que el bibliotecario, pueda dar de alta más bibliotecarios (compañeros de trabajo), y usuarios, de manera que utilizará el método anterior. Aclaración: tendremos un arraylist de persona, lo que ocurre es que nunca almacenaremos personas, sino Usuarios o Bibliotecarios, por tanto, se entiende que la clase Persona será una clase abstracta. En consecuencia, el menú de gestión del bibliotecario llamará a solicitarDatosPersona para un usuario o para un bibliotecario, y cuando hayamos completado esta información dicha instancia se añadirá a la lista de Personas.

g.	Nuestro sistema debe dar soporte para realizar reservas y devolver libros. Las reservas las realiza únicamente un bibliotecario, que previamente ha realizado el login (NIF+contraseña), una vez realizado tendrá las siguientes opciones: reservarLibro y devolverLibro.

-	El método reservarLibro, pedirá al usuario el teléfono y el correo electrónico, si coincide, le permitirá realizar la reserva, y por tanto, solicitará el ISBN del libro, y en consecuencia quedará completa la información de la reserva (revisa la clase Reserva). Debes tener en cuenta que debes actualizar la clase Libro, con la información de libros disponibles, y obviamente se debe tener en cuenta que no podrá reservar si no hay unidades disponibles.

-	El método devolverLibro, pedirá al usuario el teléfono y correo electrónico, si coincide, le permitirá devolver el libro, y por tanto, solicitará el ISBN del libro a devolver y lo eliminará de la lista (ojo si existe en la lista y no hay error). Obviamente debe quedar actualizado el contador de unidades disponibles.

-	El método añadirLibroCopia. Este método añade un libro a partir de la información de otro, para ello pedirá al usuario el libro origen y el libro destino, y qué dato quiere modificar de los datos del libro origen. Objetivo, que utilicéis el constructor copia.

h.	Teniendo en cuenta el desarrollo anterior. ¿Tiene sentido que la clase Persona sea abstracta? Realiza los cambios necesarios y haz pruebas, de manera que compruebes los resultados obtenidos cuando creamos una clase abstracta. Sugerencia: deja comentarios en tu programa para recordar dicho concepto.

-	Realiza un método abstracto llamado cambiar contraseña. Tal y como tenemos implementado actualmente el sistema de identificación, hay claras diferencias. Los bibliotecarios el login es: NIF+contraseña. Los usuarios son: teléfono+correo electrónico.

-	El menú debe dar soporte para que se pueda cambiar la contraseña, ya sea de un usuario o de un bibliotecario.
