package sgvet.utils;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 * clase destinada a la validacion del codigo de la empresa
 * @author Dante
 */
/**
 * Lo unico que no he podido hacer, q es halla distintos tamaños de
 * PATRON_CODIGO, es decir, q comprube que la dimension del codigo puede ser
 * "0-01-01-005-01" , como "1-01-01-047", como "1-01-10".
 */
public class ValidarCodigo extends InputVerifier {
    
    private int primerDigito;
    private String patron;

    public ValidarCodigo(int primerDigito) {
        if(primerDigito >= 0 && primerDigito < 10) {
            this.patron = "^" + primerDigito +
                    "-\\d{2}(-\\d{2})?(-\\d{2}-\\d{3})?" +
                    "(-\\d{2}-\\d{3}-\\d{2})?$";
            this.primerDigito = primerDigito;
        } else {
            throw new IllegalArgumentException(
                    "El primer dígito debe ser un valor entre 0 y 9");
        }
    }

    @Override
    public boolean verify(JComponent componente) {

        boolean resultado = false;

        if (componente instanceof JTextComponent) {
            JTextComponent campoDeTexto = (JTextComponent) componente;
            String texto = campoDeTexto.getText();

            resultado = esCodigo(texto) || texto.length() == 0;
        }

        if(!resultado) {
            JOptionPane.showMessageDialog(null, "Código mal formado, debe " +
                    "comenzar con " + primerDigito + "\ny debe tener un " +
                    "formato como el siguiente: X-XX-XX-XXX-XX");
        }

        return resultado;
    }

    private boolean esCodigo(String cadena) {
        return cadena != null && cadena.matches(patron);
    }

//    private boolean esCodigoValido(String codigo) {
//        boolean resultado = false;
//
//        StringBuffer co = new StringBuffer();
//
//        for (Character caracter : codigo.toCharArray()) {
//            if (caracter != '-') {
//                co.append(caracter);
//            }
//        }
//
//        int ultimaHoja = 0;
//        int longitud = co.length();
//
//        switch (co.charAt(0)) {
//            //para el caso en q el nivel sea el cero
//            case '0':
//
//                if (longitud > 5 && longitud < 11) {
//                    //veo la posicion de la ultima hoja
//                    String ultima = String.valueOf(co.charAt(7));
//                    ultimaHoja = Integer.parseInt(ultima);
//
//                    if (ultimaHoja == 8) {
//                        if (longitud == 10) {
//                            resultado = true;
//                        }
//                    } else if (ultimaHoja >= 1 && ultimaHoja <= 7) {
//                        if (longitud == 8) {
//                            resultado = true;
//                        }
//                    }
//
//                }
//                break;
//
//            case '1':
//
//                if (longitud > 4 && longitud < 11) {
//                    ultimaHoja = Integer.parseInt(co.substring(2, 3));
//                    //aca ya sabemos el 2 nivel
//                    //tengo q empezar a averiguar por el 3 nivel
//                    if (ultimaHoja > 0 && ultimaHoja < 10) {
//                        if (ultimaHoja == 1) {
//                            int temp = Integer.parseInt(co.substring(4, 5));
//                            //estoy en el 3 nivel
//                            if ((temp == 1 || temp == 2) && (longitud == 8)) {
//                                int aux = Integer.parseInt(co.substring(5, 8));
//                                if (aux == 47 || aux == 60 || aux == 73 || aux == 55 || aux == 80 || aux == 105 || aux == 42 || aux == 56 || aux == 70) {
//                                    if (longitud == 8) {
//                                        resultado = true;
//                                    }
//                                }
//
//                            } else if ((temp == 3 || temp == 4) && (longitud == 8)) {
//                                int aux = Integer.parseInt(co.substring(5, 8));
//
//                                if (aux == 50 || aux == 55) {
//                                    if (longitud == 8) {
//                                        resultado = true;
//                                    }
//                                }
//                            } else if ((temp == 5) && (longitud == 8)) {
//                                int aux = Integer.parseInt(co.substring(5, 8));
//
//                                if (aux == 200 || aux == 300 || aux == 100 || aux == 75) {
//                                    if (longitud == 8) {
//                                        resultado = true;
//                                    }
//                                }
//                            } else if ((temp == 6) && (co.length() == 8)) {
//                                int aux = Integer.parseInt(co.substring(5, 8));
//
//                                if (aux == 60 || aux == 125) {
//                                    if (longitud == 8) {
//                                        resultado = true;
//                                    }
//                                }
//                            } else if (temp == 7) {
//                                int aux = Integer.parseInt(co.substring(5, 8));
//
//                                if (aux == 100 || aux == 200) {
//                                    if (longitud == 8) {
//                                        resultado = true;
//                                    }
//                                }
//                            } else if (temp == 8 || temp == 9 || temp == 10 || temp == 11 || temp == 13) {
//                                if (longitud == 5) {
//                                    resultado = true;
//                                }
//                            } else if (temp == 12) {
//                                int aux = Integer.parseInt(co.substring(5, 8));
//
//                                if (aux == 001 || aux == 002) {
//                                    if (longitud == 8) {
//                                        resultado = true;
//                                    }
//                                }
//                            }
//                        } else if (ultimaHoja == 2) {
//                            int temp = Integer.parseInt(co.substring(4, 5));
//
//                            if (temp > 0 && temp < 9) {
//                                if (temp == 1 || temp == 3 || temp == 4 || temp == 5 || temp == 6 || temp == 7) {
//                                    if (longitud == 5) {
//                                        resultado = true;
//                                    }
//                                } else if ((temp == 2 || temp == 8) && (longitud == 8)) {
//                                    int aux = Integer.parseInt(co.substring(5, 8));
//                                    if (aux == 001 || aux == 002) {
//                                        if (longitud == 8) {
//                                            resultado = true;
//                                        }
//                                    }
//                                }
//
//
//                            }
//                        } else if (ultimaHoja == 3) {
//                            int temp = Integer.parseInt(co.substring(4, 5));
//
//                            if ((temp > 0 && temp < 4) && (longitud == 8)) {
//                                int aux = Integer.parseInt(co.substring(5, 8));
//                                if (aux > 0 && aux < 004) {
//                                    if (longitud == 8) {
//                                        resultado = true;
//                                    }
//                                }
//                            }
//                        } else if (ultimaHoja == 4) {
//                            int temp = Integer.parseInt(co.substring(4, 5));
//                            if (temp > 0 && temp < 3) {
//                                if (longitud == 5) {
//                                    resultado = true;
//                                }
//                            }
//                        } else if (ultimaHoja == 6) {
//                            int temp = Integer.parseInt(co.substring(4, 5));
//                            if ((temp == 1 || temp == 2) && (longitud == 8)) {
//                                int aux = Integer.parseInt(co.substring(5, 8));
//                                if (aux > 0 && aux < 12) {
//                                    if (longitud == 8) {
//                                        resultado = true;
//                                    }
//                                }
//
//                            }
//                        } else if (ultimaHoja == 7) {
//                            int temp = Integer.parseInt(co.substring(4, 5));
//                            if ((temp == 1 || temp == 2) && (longitud == 8)) {
//                                int auxz = Integer.parseInt(co.substring(5, 8));
//
//                                if (auxz > 0 && auxz < 12) {
//
//
//                                    if (longitud == 8) {
//                                        resultado = true;
//                                    }
//                                }
//                            }
//                        } else if (ultimaHoja == 8) {
//                            int temp = Integer.parseInt(co.substring(3, 5));
//                            if (temp > 0 && temp < 12) {
//                                if (longitud == 5) {
//                                    resultado = true;
//                                }
//                            }
//                        } else if (ultimaHoja == 9) {
//                            int temp = Integer.parseInt(co.substring(3, 5));
//                            if (temp > 0 && temp < 4) {
//                                if (longitud == 5) {
//                                    resultado = true;
//                                }
//                            }
//                        }
//                    }
//                }
//                break;
//            case '2':
//                if (longitud == 5) {
//                    ultimaHoja = Integer.parseInt(co.substring(3, 5));
////
//                    if (ultimaHoja > 0 && ultimaHoja < 12) {
//                        resultado = true;
//                    }
//                }
//                break;
//
//            case '3':
//                if (longitud > 2 && longitud < 6) {
//                    ultimaHoja = Integer.parseInt(co.substring(1, 3));
//                    if (ultimaHoja > 0 && ultimaHoja < 7) {
//                        if (ultimaHoja == 2) {
//                            if (longitud == 3) {
//                                resultado = true;
//                            }
//                        } else if (ultimaHoja != 2 && (ultimaHoja > 0 && ultimaHoja < 6) && (longitud == 5)) {
//
//                            int aux = Integer.parseInt(co.substring(3, 5));
//                            if (ultimaHoja == 1) {
//                                if ((aux > 0 && aux < 4) && (longitud == 5)) {
//                                    resultado = true;
//                                }
//                            } else if (ultimaHoja == 3) {
//                                if ((aux > 0 && aux < 5) && (longitud == 5)) {
//                                    resultado = true;
//                                }
//                            } else if (ultimaHoja == 4) {
//                                if ((aux > 0 && aux < 11) && (longitud == 5)) {
//                                    resultado = true;
//                                }
//                            } else if (ultimaHoja == 5) {
//                                if ((aux > 0 && aux < 8) && (longitud == 5)) {
//                                    resultado = true;
//                                }
//                            }
//                        }
//                    }
//                }
//                break;
//            case '4':
////                    //nivel 4
//                if (longitud > 2 && longitud < 6) {
//                    ultimaHoja = Integer.parseInt(co.substring(1, 3));
//
//                    if (ultimaHoja > 0 && ultimaHoja < 5) {
//                        if (ultimaHoja == 4) {
//                            if (longitud == 3) {
//                                resultado = true;
//                            }
//                        } else if (longitud == 5) {
//                            int temp = Integer.parseInt(co.substring(4));
//
//                            if (longitud == 5 && (temp > 0 && temp < 6)) {
//                                resultado = true;
//                            }
//                        }
//                    }
//                }
//                break;
//            case '5':
//
//                if (longitud > 2 && longitud < 4) {
//                    //nivel 5
//                    ultimaHoja = Integer.parseInt(co.substring(1, 3));
//
//                    if (ultimaHoja > 0 && ultimaHoja < 18) {
//                        if (longitud == 3) {
//                            resultado = true;
//                        }
//                    }
//                }
//                break;
//            case '6':
//
//                //nivel 6
//
//                if (longitud > 2 && longitud < 6) {
//                    ultimaHoja = Integer.parseInt(co.substring(2, 3));
//
//                    if (ultimaHoja > 0 && ultimaHoja < 10) {
//                        if (ultimaHoja == 3 && longitud > 4) {
//                            int temp = Integer.parseInt(co.substring(3, 5));
//                            if (temp > 0 && temp < 4) {
//                                if (longitud == 5) {
//                                    resultado = true;
//                                }
//                            }
//                        } else if (ultimaHoja == 6 && longitud > 4) {
//
//                            int temp = Integer.parseInt(co.substring(3, 5));
//                            if (temp > 0 && temp < 3) {
//                                if (longitud == 5) {
//                                    resultado = true;
//                                }
//                            }
//                        } else if (ultimaHoja == 1 || ultimaHoja == 2 || ultimaHoja == 4 || ultimaHoja == 5 || ultimaHoja == 7 || ultimaHoja == 8 || ultimaHoja == 9) {
//                            if (longitud > 2 && longitud < 4) {
//                                resultado = true;
//                            }
//                        }
//                    }
//                }
//                break;
//            case '7':
//                //nivel 7
//                if (longitud > 4 && longitud < 7) {
//                    ultimaHoja = Integer.parseInt(co.substring(4, 5));
//
//                    if (ultimaHoja > 0 && ultimaHoja < 8) {
//                        if (longitud == 5) {
//                            resultado = true;
//                        }
//                    }
//                }
//
//                break;
//
//            case '8':
//                //nivel 8
//                if (longitud == 3) {
//                    resultado = true;
//                }
//
//                break;
//
//        }
//
//        return resultado;
//    }
}//fin calse