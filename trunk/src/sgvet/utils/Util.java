package sgvet.utils;

import java.awt.Component;
import java.awt.Container;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXList;
import org.jdesktop.swingx.JXTable;
import sgvet.igu.model.IModeloReiniciable;

/**
 * Clase con utilidades varias
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class Util {
    
    private static Util instancia;

    private Util() {
    }
    
    public synchronized static Util getInstancia(){
        if (instancia == null){
            instancia = new Util();
        }
        
        return instancia;            
    }
    /**
     * valida si es cadena vacia
     * @param cadena es la cadena a comprobar
     * @return
     */
    public boolean esCadenaVacia(String cadena) {
        return cadena == null || cadena.isEmpty();
    }

    /**
     * 
     * @param numero alcual 
     * @return
     */
    public boolean esNumeroNegativo(double numero) {
        return numero < 0;
    }

    /**
     * metodo que sirve par saber si el codigo ingresado es valido, comprueba 
     * si la longitud del codigo, en el nivel correspondiente, es valida
     * @param codigo
     * @return
     */
    public boolean esCodigoValido(String codigo) {
        boolean resultado = false;
        String cc = new String();
        char nivel = codigo.charAt(0);
        int ultimaHoja = 0;

        if (codigo.length() > 0) {
            switch (nivel) {
                //para el caso en q el nivel sea el cero
                case 0:
                    //veo la posicion de la ultima hoja
                    ultimaHoja = codigo.indexOf(7);

                    if (ultimaHoja == 8) {
                        if (codigo.length() == 10) {
                            resultado = true;
                        }
                    } else if (ultimaHoja >= 3 && ultimaHoja <= 7) {
                        if (codigo.length() == 8) {
                            resultado = true;
                        }
                    }
                    break;



                case 1:

//                 cc = codigo.substring(1,2);
//                ultimaHoja = Integer.parseInt(cc);
//                
//                if(ultimaHoja>=0&&ultimaHoja<10)
//                {
//                    String temp =new String();
//                    int capa =0;
//                if(ultimaHoja==1)
//                {
//                 temp = codigo.substring(3,4);
//                 capa = Integer.parseInt(temp);
//                   if(capa>0&&capa<14)
//                   {
//                       if(capa==8||capa==9||capa==10||capa==11)
//                       {
//                        if (codigo.length()==5)
//                        {
//                            resultado=true;
//                        }
//                       }
//                       else
//                       {
//                       if (codigo.length()==8)
//                        {
//                            resultado=true;
//                        }
//                       }
//                   }
//                }
//                else if (ultimaHoja ==2)
//                {
//                    temp= codigo.substring(3, 4);
//                    capa = Integer.parseInt(temp);
//                    if(capa==2||capa==8)
//                     {
//                       String t= codigo.substring(7);
//                       int c = Integer.parseInt(t);
//                         
//                            if(c>0&&c<3)
//                            {
//                              if(codigo.length()==8)
//                              {
//                               resultado=true;
//                              }
//                            }
//                    }
//                    else
//                    {
//                    if(codigo.length()==5)
//                    {
//                       resultado=true;
//                    }
//                    }
//                }
//                else if (ultimaHoja==3)
//                {
//                    
//                }
//                    
//                    
////                 if (codigo.length()==5)
////                 {
////                   resultado=true;
////                 }
////                 }
////                       else
////                       {
////                       if (codigo.length()==8)
////                        {
////                            resultado=true;
////                        }
////                       }
////                    
////                    
////                }
//                   
//                   
//                   
//                   
//                   
//                   
//                   
//                
//                }
//                
//                 
//               
//               
//               break;
//            
                case 2:
                    //obtengo y asigno el numero de hoja
                    cc = codigo.substring(3, 4);
                    ultimaHoja = Integer.parseInt(cc);

                    if (ultimaHoja > 0 && ultimaHoja < 12) {
                        resultado = true;
                    }

                    break;

                case 3:
                    cc = codigo.substring(1, 2);
                    ultimaHoja = Integer.parseInt(cc);

                    if (ultimaHoja >= 0 && ultimaHoja < 7) {
                        if (ultimaHoja == 2) {
                            if (codigo.length() == 3) {
                                resultado = true;
                            }
                        } else {
                            if (codigo.length() == 5) {
                                resultado = true;
                            }
                        }
                    }
                    break;
                case 4:
                    //nivel 4
                    cc = codigo.substring(1, 2);
                    ultimaHoja = Integer.parseInt(cc);

                    if (ultimaHoja >= 0 && ultimaHoja < 5) {
                        if (ultimaHoja == 4) {
                            if (codigo.length() == 3) {
                                resultado = true;
                            }
                        } else {
                            if (codigo.length() == 5) {
                                resultado = true;
                            }
                        }
                    }

                    break;
                case 5:
                    //nivel 5
                    cc = codigo.substring(1, 2);
                    ultimaHoja = Integer.parseInt(cc);

                    if (ultimaHoja >= 0 && ultimaHoja < 18) {
                        if (codigo.length() == 3) {
                            resultado = true;
                        }
                    }

                    break;
                case 6:

                    //nivel 6

                    cc = codigo.substring(1, 2);
                    ultimaHoja = Integer.parseInt(cc);

                    if (ultimaHoja >= 0 && ultimaHoja < 10) {
                        if (ultimaHoja == 3 || ultimaHoja == 6) {
                            if (codigo.length() == 5) {
                                resultado = true;
                            }
                        } else {
                            if (codigo.length() == 3) {
                                resultado = true;
                            }
                        }
                    }
                    break;
                case 7:
                    //nivel 7
                    cc = codigo.substring(3, 4);
                    ultimaHoja = Integer.parseInt(cc);

                    if (ultimaHoja >= 0 && ultimaHoja < 8) {
                        if (codigo.length() == 5) {
                            resultado = true;
                        }
                    }
                    break;

                default:
                    //nivel 8
                    if (codigo.length() == 3) {
                        resultado = true;
                    }
                    break;

            }

        }



        return resultado;
    }
    
    /**
     * Limpia los campos de un panel
     * 
     * @param contenedor Panel que se desea limpiar
     */
    public void limpiarCampos(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField)componente).setText("");
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(0);
            } else if (componente instanceof JXDatePicker) {
                ((JXDatePicker) componente).setDate(null);
            } else if (componente instanceof JXTable) {
                ((IModeloReiniciable)((JXTable)componente).getModel()).reiniciar();
            } else if (componente instanceof JXList) {
                ((IModeloReiniciable)((JXList)componente).getModel()).reiniciar();
            } else if (componente instanceof JCheckBox) {
                ((JCheckBox) componente).setSelected(false);
            } else if (componente instanceof Container) {
                limpiarCampos((Container)componente);
            }
        }
    }
    
    public boolean validar(IValidable validable) {
        boolean resultado = true;
        
        if(validable != null) {
            List<Component> componentes =
                    validable.getComponentesObligatorios();
            
            resultado = true;
            
            for (Component componente : componentes) {
                if (componente instanceof JTextField) {
                    resultado &= ((JTextField)componente).getText().trim().length() > 0;
                } else if (componente instanceof JComboBox) {
                    resultado &= ((JComboBox)componente).getSelectedIndex() != -1;
                } else if (componente instanceof JXDatePicker) {
                    resultado &= ((JXDatePicker)componente).getDate() != null;
                } else if (componente instanceof JXTable) {
                    resultado &= ((JXTable)componente).getModel().getRowCount() > 0;
                } else if (componente instanceof JXList) {
                    resultado &= ((JXList)componente).getModel().getSize() > 0;
                } else if (componente instanceof IValidable) {
                    validar((IValidable)componente);
                }
            }
        }
        
        return resultado;
    }

}
