import java.util.Scanner;
public class Banco2 implements Ejemplo1
{  
   static double saldo;
   static int opcion;
   static Scanner l = new Scanner(System.in);
   static double retirarAmount;
    public static void main ()
   {
       System.out.print('\u000c');
       Banco2 banco = new Banco2();
       
       boolean stop=true;
       
       System.out.println("Nombre:");
       String nombre = l.next();
       
       System.out.println("Saldo Inicial:");
       saldo = l.nextDouble();
       
       System.out.println("Usted tiene una tarjeta dorada o regular?");
       String tarjeta = l.next();
       
       
       do 
       {
       System.out.println("Elige el numero de la operacion que usted desea realizar:");
       System.out.println("1. Retirar");
       System.out.println("2. Depositar");
       System.out.println("3. Calcular Interes");
       System.out.println("4. Obtener Saldo");
       opcion = l.nextInt();
       
        switch(opcion) 
       {
         case 1: 
         System.out.println("Cuanto desea retirar:");
         retirarAmount = l.nextDouble();
         if (tarjeta.equals("dorada"))
         {
             banco.Dorada();
         }
         if (tarjeta.equals("regular"))
         {
             banco.Regular();
          }
         break;
         
         case 2:
         banco.depositarEnCuenta();
         break;
         
         case 3:
        if (tarjeta.equals("dorada"))
         {
             banco.Dorada();
         }
        if (tarjeta.equals("regular"))
         {
             banco.Regular();
         }
         break;
         
        case 4: 
        banco.getSaldo();
        break;
         
        default: System.out.println("Elige una de las cuatro opciones");
        }
        
        System.out.println("Tiene otra operacíon que desea realizar? Pone 'si' o 'no':");
        String seguir = l.next();
        
       if (seguir.equals("no"))
        {
 
            break;
        }
       if (seguir.equals("si"))
        {
            stop = true;
        }
    }
      while(stop = true);       
   }    
   
   public void depositarEnCuenta()
   {
       System.out.println("Cuanto desea depositar?:");
       double depositar = l.nextDouble();
       saldo+= depositar;       
   }
   public void getSaldo ()
   {
       System.out.println("Saldo: " + saldo);
   }
   
   public void Dorada()
   {
       if (opcion == 1)
       {
          System.out.println("Puede tomar su dinero."); 
          saldo-=retirarAmount;
       }
       if (opcion == 3)
       {
           double interes = saldo * 0.05;
           System.out.println("Interes: " + interes + " pesos.");
       }
   }
   public void Regular()
   {
       if (opcion == 1)
       {
           if (retirarAmount > saldo)
           {
               System.out.println("No puede sobregirarse");
            }
            else 
            {
                  System.out.println("Puede tomar su dinero.");
                  saldo-=retirarAmount;
            }
       }
       if (opcion == 3)
       {
           double interes = saldo * 0.06 + 100;
           System.out.println("Interes: " + interes + " pesos.");
       }
   }
}
