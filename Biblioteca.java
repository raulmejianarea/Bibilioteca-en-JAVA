
package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> nombrelibro = new ArrayList();
        ArrayList<String> autor = new ArrayList();
        ArrayList<Integer> cantidad = new ArrayList();

        
    librosdelabiblioteca(nombrelibro, autor, cantidad); //llamo al metodo que rellena los arrays list
    enseñarlibros(nombrelibro, autor, cantidad); //llamo al metodo para que enseñe el array list de la libreria

        int opcion;
         // pido al usuario que elija entre dos opciones a traves de un switch
         System.out.println("Elige que opcion qieres hacer ");
         System.out.println("1. prestar");
         System.out.println("2. devolver");
         System.out.println("3. salir");
       
         opcion = entrada.nextInt();
         
        switch(opcion){
        
        //opcion de prestar un libro 
            case 1:
                prestarlibro(nombrelibro, autor, cantidad); //llamo al metodo prestar libro
                
            break;
            
        //opcion de devolver un libro 
            case 2: 
                devolverlibro(nombrelibro, autor, cantidad);//llamo al metodo devolver libro
            
  
        break;
        
        //opcion salir de programa
            case 3:
            System.exit(0); 
               
        }   
            
    }
    //Relleno los arrays
    static void librosdelabiblioteca(ArrayList<String> nombrelibro, ArrayList<String> autor, ArrayList<Integer> cantidad){
    nombrelibro.add("Quijote");
    autor.add("cervantes");
    cantidad.add(3);
     
    nombrelibro.add("Principito");
    autor.add("Antoine de Saint-Exupéry");
    cantidad.add(1);
     
    nombrelibro.add("Moby-Dick");
    autor.add("Herman Melville");
    cantidad.add(5);
     
    nombrelibro.add("Fabulas");
    autor.add("Anonimo");
    cantidad.add(5);
     
    nombrelibro.add("Intranerso");
    autor.add("Carlos Miguel Cortés");
    cantidad.add(2);
     
    nombrelibro.add("Crepusculo");
    autor.add("Stephenie Meyer");
    cantidad.add(7);
     
    nombrelibro.add("Odisea");
    autor.add("Homero"); 
    cantidad.add(3);
    }
    //creo un metodo para enseñar la libreria
    static void enseñarlibros(ArrayList<String> nombrelibro, ArrayList<String> autor, ArrayList<Integer> cantidad){
       for (int i = 0; i < nombrelibro.size(); i++) {
            System.out.println(nombrelibro.get(i)+ "  --  " +autor.get(i)+ "  --  " +cantidad.get(i) );
          
        }   
     }
    //creo un metodo para prestar libro
    static void prestarlibro(ArrayList<String> nombrelibro, ArrayList<String> autor, ArrayList<Integer> cantidad){
        Scanner entrada = new Scanner(System.in);
        String respuesta1;
        do {    
            System.out.println("Dime el titulo del libro que quieres prestar");        
            String libroaprestar =entrada.next();
            if (nombrelibro.contains(libroaprestar)) // si el array list nombre libro contiene el libro que el usuario introdujo entonces esta disponible y lo prestamos y restamos uno 
            {
                
               
               int posicion =  nombrelibro.indexOf(libroaprestar); //indexof encuentra la posicion de libro a prestar
              
               int c = cantidad.get(posicion)-1;
               cantidad.set(posicion, c );
             
            System.out.println( libroaprestar + " esta en nuestra biblioteca" +" y ahora quedan Disponibles " +cantidad.set(posicion, c) + " más para prestar ");
            }else {
               
                System.out.println("no esta Disponible en nuestra biblioteca");
            }
              System.out.print("¿Más? (s o n) ");
            respuesta1 = entrada.next();
                   } while (respuesta1.equalsIgnoreCase("s"));
        
    }
    //creo un metodo para devolver libro
    static void devolverlibro(ArrayList<String> nombrelibro, ArrayList<String> autor, ArrayList<Integer> cantidad){
        Scanner entrada = new Scanner(System.in);
        String respuesta;
            do {
                System.out.println("Dime el titulo del libro que quieres devolver");
                String libroadevolver = entrada.next();
                 if (nombrelibro.contains(libroadevolver)){
                    int posicion2 =  nombrelibro.indexOf(libroadevolver);
                    int j =cantidad.get(posicion2)+1;
                    cantidad.set(posicion2, j);
                } else{
                     System.out.println( libroadevolver + " no ha estado antes, vamos añadirlo");
                    nombrelibro.add(libroadevolver);
                    System.out.println("dime el nombre del autor nuevo");
                    String autornuevo1 = entrada.next();
                    autor.add(autornuevo1);
                    System.out.println("dime cuantos quieres añadir");
                    int cantidadnueva = entrada.nextInt();
                    cantidad.add(cantidadnueva);
                    enseñarlibros(nombrelibro, autor, cantidad);
                 }
                enseñarlibros(nombrelibro, autor, cantidad);
                System.out.print("¿Más? (s o n) ");
                respuesta = entrada.next();    
        } while (respuesta.equalsIgnoreCase("s"));
    }
}
