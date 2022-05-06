package com.itesm.financial;

public class Client {
    public static void main(String[] args) throws Exception {
        /*
            Oscar Antonio Hinojosa Salum A00821930
            29 Abril 2022

            En VSCode ocupé ir a File -> Preferences -> Settings -> Busqué "Scrollback" 
            y cambié su cantidad de líneas de 1,000 a 2,000 para poder ver el output.

            I. Patrones de Diseño Implementados:
                1.  FACADE - Meter código "debajo de la alfombra", para que 
                    Client.java se vea limpio y sea más sencillo de leer y comprender.

                2.  DECORATOR - Añadir funcionalidades a un objeto o clase de forma
                    dinámica. En este caso a WebReport.java

                3.  BRIDGE - Con PrintReport.java creo que creamos una especie de puente
                    entre Client y los demás objetos del programa, de tal manera que
                    tiene menos responsabilidades o afecciones si sufre modificaciones. 

            II. Principios SOLID, POO o Mental Models Recopilados:
                1.  SOLID - Single Responsibility: En el objeto Client teníamos tres responsabilidades. 
                    Se redujo a una sola, llamar el interfaz PrintReport, facilitando su lectura e inicialización (carga menos librerías).

                2.  POO Encapsulation & Abstraction: El oobjeto Client no era tan abstracto como debería.
                    Por medio de una "forma" de encapsulamiento separamos y escondimos toda la data o procesos que realizaba.
                    Si bien no se crearon "gets" o "sets", la idea de hacer un poco más difícil el acceso/modificación de los métodos a los
                    usuarios se logró impulsar un poco. Su abstracción ahora, por ende, es más legible, comprensible y mantenible.
                    En sí creo que no hubo encapsulation, pero siento que la idea es un poco similar, en un detalle o dos, no estoy seguro.

                3.  Mental Models - Bayesian Thinking: Como su ejemplo leí que dice "El leer que el crímen se duplicó al doble nos puede
                    hacer sentir nerviosos, pero cuando lo piensas en retrospectiva, si antes tus chances de ser víctima de un crímen era
                    1 en 10,000, ahora es 2 en 10,000, es decir, del 0.01% creció al 0.02% lo cual no sigue siendo mucho, pero nos causó
                    un impacto". Lo mismo sucede en el desarrollo de software, a veces nos asustamos al ver demasiadas líneas en una clase u
                    objeto, pero si los troceamos en pedazos más digeribles y legibles, nos damos cuenta que es algo sencillo en realidad.
        */

        // Single Responsibility - SOLID Principle - Client.java -> PrintReport.java
        // Encapsulation or Abstraction - POO Principle - Client.java is easier to read like this
        // Mental Models - Bayesian Thinking - Client.java is easier to read like this
        PrintReport.buildReport();
    }
}
