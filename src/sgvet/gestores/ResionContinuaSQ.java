/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;
/**
 *
 * @author Luciano
 */
public class ResionContinuaSQ {

/*
 D : demanda anual. (unidad de ítem/año)
 A : costo de emisión (unidad monetaria)
 C : costo unitario; el valor del ítem en el inventario. (unidad monetaria / unidad de ítem)
 r : tasa anual de recargo por almacenamiento.
 H : Costo anual de almacenamiento de cada unidad de ítem. H = r *C (unidad monetaria/unidad de ítem)
 Q : Cantidad a ordenar o tamaño del lote. (unidad de ítem)
CTG : Costo Total anual de Gestión; no incluye el costo del ítem. (unidad monetaria / año)
CT : Costo total anual; incluye el costo del ítem. CT = C D + CTG (unidad monetaria/ año)
N : número de pedidos o ciclos de producción por año.
 -Número de pedidos en un año = N = D/Q
 -Costo total anual de emisión = A N = A D/Q
 -Costo total anual de almacenamiento = H = r*C
 -CTG = A D/Q + H Q/2
 */
double A;
double D;
double Q;
double N;
double AN;
double H;
double r;
double C;
double CTG;
double Qoptimo;
public ResionContinuaSQ(){}

public double CTG(double A1, double N1,double H1, double Q1)
{
 A=A1;
 N=N1;
 H=H1;
 Q=Q1;
  double CTG1,CTG2;
  System.out.println(A);
  System.out.println("__");
  System.out.println(N);
  System.out.println("__");
  System.out.println(H);
  System.out.println("__");
  System.out.println(Q);
  System.out.println("__");
  System.out.println(CTG1=A*N);
  System.out.println(CTG2=H*(Q/2));
  return  CTG=CTG1+CTG2;

}
public double N (double D, double Q)
{
    return N=D/Q;
}
public double CostoTotalAnualEmision(double A,double D, double Q)
{
    return AN=A*(D/Q);
}
public double H(double r, double C)
{
  System.out.println(H);
  return H=r*C;

}
public double Qoptimo(double A, double D, double H)
{
    Qoptimo=Math.sqrt((2*A*D)/(H));
    return Qoptimo;
}

}

