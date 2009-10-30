/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

/**
 *
 * @author Luciano
 */
public class RevisionPeriodica {
//StockDisponible=StockRealEnAlmacen+StockPendienteDeEntrega-StockComprometido
//Q:Cantidad a Ordenar(ya esta determinada)
//Punto de Pedido:Cuando llega a este punto hay que hacer el Pedido.
//Tiempo de Demora(Hasta el Almacen):
//Faltante Esperado.
    //Te:Tiempo de Entrega.
    //s:Punto de Pedido.
    //SS:Stock de Seguridad.
    //Xe:Demanda Durante el tiempo de Espera.
    //f:Funcion Densidad.
    //Moo:Demanda Esperada durante el tiempo de Entrega.
    //Omega:Desviacion Estandar durante el Tiempo de entrega.
    //Cf:Costo Unitario por faltante.
    //CGE:Costo Anual de Gestion Esperado.
    //Nivel de Servicio:Tabla de doble entrada, la dio la Profe.
 private double NumeroDeOrdenes;
 private double D;
 private double Q;
 private double A;
 private double CostoAnualEmision;
 private double Moo;
 private double s;
 private double H;
 private double CostoAnualAlmacenamiento;
 private double DesviacionEstandar;
 private double K;
 private double SS;
 private double R;
 public RevisionPeriodica(){}
public double NumeroDeOrdenes(double DemandaAnual,double TamanioLote)
{
D=DemandaAnual;
Q=TamanioLote;
if (Q==0)
    {
    System.out.println("DIVISION Sobre ZERO");
    Q=999999999;
    }
else
    {
    NumeroDeOrdenes=D/Q;
    }
return NumeroDeOrdenes;
}
public double CostoAnualEmision(double CostoEmision,double DemandaAnual,double TamanioLote)
{
A=CostoEmision;
D=DemandaAnual;
Q=TamanioLote;
if (Q==0)
    {
    System.out.println("DIVISION Sobre ZERO");
    Q=999999999;
    }
else
    {
    CostoAnualEmision=A*(D/Q);

    }
return CostoAnualEmision;
}
public double CostoAnualAlmacenamiento(double TamanioLote, double PuntoDePedido, double DemandaEsperada,double CostoAlmacenamiento )
{
Q=TamanioLote;
s=PuntoDePedido;
Moo=DemandaEsperada;
H=CostoAlmacenamiento;
CostoAnualAlmacenamiento=((Q/2)+s-Moo)*H;
    return CostoAnualAlmacenamiento;
}

public double SSSinDemoras(double KEsperada, double DesviacionEstandarEsperada)
{
    DesviacionEstandar=DesviacionEstandarEsperada;
    K=KEsperada;
    SS=K* DesviacionEstandar;
    return SS;

}
public double SSinDemorada(double DemandaAnualEsperada, double  NivelDeServicio, double DesviacionEstandarEsperada)
{
    Moo=DemandaAnualEsperada;
    K=NivelDeServicio;
    DesviacionEstandar=DesviacionEstandarEsperada;
    s=Moo+(K*DesviacionEstandar);
    return s;
}

public double SSConDemoras( double KEsperada  , double DesviacionEstandar_R_Te )
{
    K=KEsperada;
    DesviacionEstandar=DesviacionEstandar_R_Te;
    SS=K*(DesviacionEstandar);
    return SS;

}
public double SConDemorada(double DemandaAnualEsperada_R_Te, double SS_R_Te)
{
    SS=SS_R_Te;
    Moo=DemandaAnualEsperada_R_Te;

    s=Moo+(SS);
    return s;
}





}

