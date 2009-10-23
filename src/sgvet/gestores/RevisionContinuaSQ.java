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
double QOptimo;
double CTGOptimo;
double NOptimo;
double TAnual;

public RevisionContinuaSQ(){}

public double CTG(double CostoEmision, double DemandaAnual,double CostoAnualMant, double TamanioLote)
{
 A=CostoEmision;
 D=DemandaAnual;
 H=CostoAnualMant;
 Q=TamanioLote;
  double CTG1,CTG2;
  CTG1=A*(D/Q);
  CTG2=H*(Q/2);
  return  CTG=CTG1+CTG2;

}
public double N (double DemandaAnual, double TamanioLote)
{
    D=DemandaAnual;
    Q=TamanioLote;
    return N=D/Q;
}
public double CostoTotalAnualEmision(double CostoEmision,double DemandaAnual, double TamanioLote)
{

    A=CostoEmision;
    D=DemandaAnual;
    Q=TamanioLote;
    return AN=A*(D/Q);
}
public double H(double TasaAnual, double CostoUnitario)
{
 r=TasaAnual;
 C=CostoUnitario;
 return H=r*C;

}
public double QOptimo(double CostoEmision, double DemandaAnual, double CostoAnualMant)
{
 A=CostoEmision;
 H=CostoAnualMant;
 D=DemandaAnual;
 QOptimo=Math.sqrt((2*A*D)/(H));
 return QOptimo;
}
public double CTGOptimo(double CostoEmision, double DemandaAnual, double  CostoAnualMant)
{
    A=CostoEmision;
    D=DemandaAnual;
    H=CostoAnualMant;
    CTGOptimo=Math.sqrt(2*A*D*H);
    return CTGOptimo;
}
public double NOptimo(double CostoEmision, double DemandaAnual, double  CostoAnualMant)
{
    A=CostoEmision;
    D=DemandaAnual;
    H=CostoAnualMant;
    NOptimo=Math.sqrt((D*H)/(2*A));
    return NOptimo;
}
public double TAnual(double DemandaAnual, double TamanioLote)
{
   D=DemandaAnual;
   Q=TamanioLote;
   TAnual=Q/D;
return TAnual;
}
public double TMensual(double DemandaAnual, double TamanioLote)
{
   D=DemandaAnual;
   Q=TamanioLote;
   double TMensual=(Q/D)*12;
return TMensual;
}
public double TSemanal(double DemandaAnual, double TamanioLote)
{
   D=DemandaAnual;
   Q=TamanioLote;
   double TSemanal=(Q/D)*12;
return TSemanal;
}

}






