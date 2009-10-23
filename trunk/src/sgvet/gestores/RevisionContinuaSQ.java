/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;
/**
 *
 * @author Luciano
 */
public class RevisionContinuaSQ {

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
public RevisionContinuaSQ(){}

public double CTG(double CostoEmision, double CantDemandaAnual,double CostoAnualMant, double TamanioLote)
{
 A=CostoEmision;
 N=CantDemandaAnual;
 H=CostoAnualMant;
 Q=TamanioLote;
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
public double N (double DemandaAnual, double TamanioLote)
{
    D=DemandaAnual;
    Q=TamanioLote;
    System.out.println("El Cantidad de Pedido Por Anio es:");
    System.out.println(N);
    return N=D/Q;
}
public double CostoTotalAnualEmision(double A,double D, double Q)
{
    System.out.println("El Costo Anual de Emision es:");
    System.out.println(AN);
    return AN=A*(D/Q);
}
public double H(double TasaAnual, double CostoUnitario)
{
 r=TasaAnual;
 C=CostoUnitario;
  System.out.println("El Costo Anual de Almacenamiento es:");
  System.out.println(H);
  return H=r*C;

}
public double Qoptimo(double CostoEmision, double DemandaAnual, double CostoAnualMant)
{
 A=CostoEmision;
 H=CostoAnualMant;
 D=DemandaAnual;
    Qoptimo=Math.sqrt((2*A*D)/(H));
    System.out.println("El Lote Optimo es:");
    System.out.println(Qoptimo);
    return Qoptimo;
}

}

