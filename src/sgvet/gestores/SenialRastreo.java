/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;
///import java.lang.Object;

import sgvet.entidades.ProductoComponente;

/**
 *
 * @author LUCIANO
 */
public class SenialRastreo {
    public double[] demandaReal;
    public double[] pronostico;
    public double alfa;
    public double[] error;
    public double[] errorPromedio;
    public double[] MSE;
    public double[] desviacionEstandar;
    public double[] senialRastreo;

    public SenialRastreo()
    {
     demandaReal= new double[13];
     pronostico=new double[13];
     alfa=0.1 ;
     error=new double[13];
     errorPromedio=new double[13];
     MSE=new double[13];
     desviacionEstandar=new double[13];
     senialRastreo=new double[13];
    }

    public SenialRastreo( double[] DemandaRealX, double[] PronosticoX, double GammaX, double[] ErrorX, double[] ErrorPromedioX, double[] MSEX, double[] DesviacionEstandarX,double[] SenialRastreoX){
    /*Atener en cuanta, Hay 13 periodos de 28 y de ellos tiene que existir un pronostico
    por cada periodo, para cada producto. La senial de Rastreo se calcula a cierre del periodo */
     demandaReal= DemandaRealX;
     pronostico=PronosticoX;
     alfa= GammaX ;
     //error=new double[13];
     errorPromedio=ErrorPromedioX;
     MSE=MSEX;
     desviacionEstandar=DesviacionEstandarX;
     senialRastreo=SenialRastreoX;
    }

    public double[] Error (double[] DemandaReal,double[] Pronostico)
    {
       // demandaReal=DemandaRealX;
        error=new double[13];
        //pronostico=demandaReal;
        for(int i=0;i<13;i++)
        {
            if(i==0)
            {

            error[i]=0;
            }
            else
            {
            error[i]=Pronostico[i]-DemandaReal[i];

            }
            //System.out.println(error[i]);
         }
    return error;
    }

    public double[] ErrorPromedio(double Gamma1, double[] Error1)
    {
     errorPromedio=new double[13];
     error=Error1;
     alfa=Gamma1;
        for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            errorPromedio[i]=0;
            }
            else
            {
            errorPromedio[i]=((alfa*error[i])+(1-alfa)*errorPromedio[i-1]);
            }
            //System.out.println(errorPromedio[i]);
        }

     return errorPromedio;
    }

    public double[] MSE(double Gamma, double[] Error1)
    {
       MSE=new double[13];
       error=Error1;
      for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            MSE[i]=0;
            }
            else
            {
            MSE[i]=((Gamma*(error[i]*error[i]))+((1-Gamma)*MSE[i-1]));
        }

        // System.out.println(MSE[i]);
    }

     return MSE;
    }

    public double[] DesviacionEstandar(double Gamma, double[] MSE1)
    {
        desviacionEstandar=new double[13];
        MSE=MSE1;
      for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            desviacionEstandar[i]=0;
            }
            else
            {
             // desviacionEstandar[i]=1;math//=+RAIZ(F9)*RAIZ($G$2)/(2-$G$2)
            desviacionEstandar[i]=(Math.sqrt(MSE[i])*Math.sqrt(Gamma)/(2-Gamma));

            }
        //System.out.println(desviacionEstandar[i]);
    }

     return desviacionEstandar;
    }

    public double[] SenialRastreoFinal(double[] DesviacionEstandar1, double[] ErrorPromedio1)
    {
     desviacionEstandar=DesviacionEstandar1;
     errorPromedio=ErrorPromedio1;
     senialRastreo=new double[13];
      for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            senialRastreo[i]=0;
            }
            else
            {
            senialRastreo[i]=errorPromedio[i]/desviacionEstandar[i];
            }
             System.out.println(senialRastreo[i]);
             //System.out.println(errorPromedio[i]);
             //System.out.println(desviacionEstandar[i]);
    }

     return senialRastreo;
    }

    public double[] SenialRastreoFinalFull(double[] _demandaReal,double[] _pronostico)
    {
        demandaReal = _demandaReal;
        pronostico = _pronostico;
        error = new double[13];
        errorPromedio = new double[13];
        MSE = new double[13];
        desviacionEstandar = new double[13];
        senialRastreo = new double[13];

        for(int i=0;i<13;i++)
        {
            if(i == 0)
            {
                error[i] = 0;
            }
            else
            {
                error[i] = pronostico[i] - demandaReal[i];
            }
            //System.out.println(error[i]);
         }

        for(int i=0;i<13;i++)
        {
            if(i == 0)
            {
                errorPromedio[i] = 0;
            }
            else
            {
                errorPromedio[i] = ((alfa * error[i]) + (1 - alfa) * errorPromedio[i-1]);
            }

            //System.out.println(errorPromedio[i]);
        }

       for(int i=0;i<13;i++)
       {
            if(i == 0)
            {
                MSE[i] = 0;
            }
            else
            {
                MSE[i] = ((alfa * (error[i] * error[i])) + ((1 - alfa) * MSE[i-1]));
            }
       }

      for(int i=0;i<13;i++)
      {

            if(i==0)
            {
                desviacionEstandar[i] = 0;
            }
            else
            {
                // desviacionEstandar[i]=1;math//=+RAIZ(F9)*RAIZ($G$2)/(2-$G$2)
                desviacionEstandar[i] = (Math.sqrt(MSE[i]) * Math.sqrt(alfa)/(2 - alfa));

            }
      }

      for(int i=0;i<13;i++)
      {
        if(i == 0)
        {
            senialRastreo[i]=0;
        }
        else
        {
            senialRastreo[i] = errorPromedio[i] / desviacionEstandar[i];
        }
        System.out.println(senialRastreo[i]);
        //System.out.println(errorPromedio[i]);
        //System.out.println(desviacionEstandar[i]);
      }

     return senialRastreo;

    }

    public boolean senialRastreoFueraRango(ProductoComponente prod) {
        double[] senial = SenialRastreoFinalFull(demandaReal, pronostico);
        double sr = senial[senial.length];



        return true;
    }
}