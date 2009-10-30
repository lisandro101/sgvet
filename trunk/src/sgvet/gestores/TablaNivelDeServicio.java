/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

/**
 *
 * @author Luciano
 */
public class TablaNivelDeServicio {
    private double Porcentaje;
     private double K;
     public TablaNivelDeServicio(){}
     public double NivelDeServicio(int Porcentaje)
     {
     switch (Porcentaje)
        {
         case 5:
         { K=0;
            break;}
         case 6:
         {K=0.25;
            break;}
         case 7:
         {K=0.52;
            break;}
         case 8:
         { K=0.84;
            break;}
         case 9:
         { K=1.24;
            break;}
         case 95:
         { K=1.64;
            break;}
         case 99:
         { K=0.84;
            break;}
            default:
            { K=99999999;
            System.out.println("PORCENTAJE FUERA DE RANGO");
            }
        }
     return K;
     }


}

