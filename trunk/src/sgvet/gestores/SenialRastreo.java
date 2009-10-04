/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;
///import java.lang.Object;
/**
 *
 * @author LUCIANO
 */
public class SenialRastreo {
    public double[] DemandaReal;
    public double[] Pronostico;
    public double Gamma;
    public double[] Error;
    public double[] ErrorPromedio;
    public double[] MSE;
    public double[] DesviacionEstandar;
    public double[] SenialRastreo;

    public SenialRastreo()
    {
     DemandaReal= new double[13];
     Pronostico=new double[13];
     Gamma=0.1 ;
     Error=new double[13];
     ErrorPromedio=new double[13];
     MSE=new double[13];
     DesviacionEstandar=new double[13];
     SenialRastreo=new double[13];
    }

    public SenialRastreo( double[] DemandaRealX, double[] PronosticoX, double GammaX, double[] ErrorX, double[] ErrorPromedioX, double[] MSEX, double[] DesviacionEstandarX,double[] SenialRastreoX){
    /*Atener en cuanta, Hay 13 periodos de 28 y de ellos tiene que existir un pronostico
    por cada periodo, para cada producto. La senial de Rastreo se calcula a cierre del periodo */
     DemandaReal= DemandaRealX;
     Pronostico=PronosticoX;
     Gamma= GammaX ;
     //Error=new double[13];
     ErrorPromedio=ErrorPromedioX;
     MSE=MSEX;
     DesviacionEstandar=DesviacionEstandarX;
     SenialRastreo=SenialRastreoX;
    }
    public double[] Error (double[] DemandaReal,double[] Pronostico)
    {
       // DemandaReal=DemandaRealX;
        Error=new double[13];
        //Pronostico=DemandaReal;
        for(int i=0;i<13;i++)
        {
            if(i==0)
            {

            Error[i]=0;
            }
            else
            {
            Error[i]=Pronostico[i]-DemandaReal[i];

            }
            //System.out.println(Error[i]);
         }
    return Error;
    }

    public double[] ErrorPromedio(double Gamma1, double[] Error1)
    {
     ErrorPromedio=new double[13];
     Error=Error1;
     Gamma=Gamma1;
        for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            ErrorPromedio[i]=0;
            }
            else
            {
            ErrorPromedio[i]=((Gamma*Error[i])+(1-Gamma)*ErrorPromedio[i-1]);
            }
            //System.out.println(ErrorPromedio[i]);
        }

     return ErrorPromedio;
    }

    public double[] MSE(double Gamma, double[] Error1)
    {
       MSE=new double[13];
       Error=Error1;
      for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            MSE[i]=0;
            }
            else
            {
            MSE[i]=((Gamma*(Error[i]*Error[i]))+((1-Gamma)*MSE[i-1]));
        }

        // System.out.println(MSE[i]);
    }

     return MSE;
    }

    public double[] DesviacionEstandar(double Gamma, double[] MSE1)
    {
        DesviacionEstandar=new double[13];
        MSE=MSE1;
      for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            DesviacionEstandar[i]=0;
            }
            else
            {
             // DesviacionEstandar[i]=1;math//=+RAIZ(F9)*RAIZ($G$2)/(2-$G$2)
            DesviacionEstandar[i]=(Math.sqrt(MSE[i])*Math.sqrt(Gamma)/(2-Gamma));

            }
        //System.out.println(DesviacionEstandar[i]);
    }

     return DesviacionEstandar;
    }

    public double[] SenialRastreoFinal(double[] DesviacionEstandar1, double[] ErrorPromedio1)
    {
     DesviacionEstandar=DesviacionEstandar1;
     ErrorPromedio=ErrorPromedio1;
     SenialRastreo=new double[13];
      for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            SenialRastreo[i]=0;
            }
            else
            {
            SenialRastreo[i]=ErrorPromedio[i]/DesviacionEstandar[i];
            }
             System.out.println(SenialRastreo[i]);
             //System.out.println(ErrorPromedio[i]);
             //System.out.println(DesviacionEstandar[i]);
    }

     return SenialRastreo;
    }

         public double[] SenialRastreoFinalFull(double[] DemandaReal1,double[] Pronostico1)
    {
        DemandaReal=DemandaReal1;
        Pronostico=Pronostico1;
        Error=new double[13];
        for(int i=0;i<13;i++)
        {
            if(i==0)
            {

            Error[i]=0;
            }
            else
            {
            Error[i]=Pronostico[i]-DemandaReal[i];

            }
            //System.out.println(Error[i]);
         }
         ErrorPromedio=new double[13];

        for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            ErrorPromedio[i]=0;
            }
            else
            {
            ErrorPromedio[i]=((Gamma*Error[i])+(1-Gamma)*ErrorPromedio[i-1]);
            }
            //System.out.println(ErrorPromedio[i]);
        }
        MSE=new double[13];
       for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            MSE[i]=0;
            }
            else
            {
            MSE[i]=((Gamma*(Error[i]*Error[i]))+((1-Gamma)*MSE[i-1]));
            }
       }
        DesviacionEstandar=new double[13];
      for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            DesviacionEstandar[i]=0;
            }
            else
            {
             // DesviacionEstandar[i]=1;math//=+RAIZ(F9)*RAIZ($G$2)/(2-$G$2)
            DesviacionEstandar[i]=(Math.sqrt(MSE[i])*Math.sqrt(Gamma)/(2-Gamma));

            }
       }

     SenialRastreo=new double[13];
      for(int i=0;i<13;i++)
        {
            if(i==0)
            {
            SenialRastreo[i]=0;
            }
            else
            {
            SenialRastreo[i]=ErrorPromedio[i]/DesviacionEstandar[i];
            }
             System.out.println(SenialRastreo[i]);
             //System.out.println(ErrorPromedio[i]);
             //System.out.println(DesviacionEstandar[i]);
          }

     return SenialRastreo;




}
}