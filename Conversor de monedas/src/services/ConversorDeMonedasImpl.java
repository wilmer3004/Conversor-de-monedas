package services;

import java.net.http.HttpClient;
import java.util.Objects;
import java.util.Scanner;

public class ConversorDeMonedasImpl implements IConversorDeMonedasService{


    //Menu para la conversion
    @Override
    public String MenuDeConversion(int eleccion) {
        Scanner sc = new Scanner(System.in);
        Double valorDeConversion = 0.0;
        String eleccionRespuesta = "";
        switch (eleccion) {
            case 1: {

                eleccionRespuesta = "conversion de dolar a peso argentino";
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion(eleccion,valorConversion1);

            };
                break;

            case 2: {

                eleccionRespuesta = "conversion de peso argentino a dolar";
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion(eleccion,valorConversion1);

            };
                break;

            case 3 : {

                eleccionRespuesta = "conversion de dolar a real brasileño";
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion(eleccion,valorConversion1);

            };
                break;

            case 4 : {

                eleccionRespuesta = "conversion de real brasileño a dolar";
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion(eleccion,valorConversion1);

            };
                break;

            case 5 : {

                eleccionRespuesta = "conversion de dolar a peso colombiano";
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion(eleccion,valorConversion1);

            };
                break;

            case 6 : {

                eleccionRespuesta = "conversion de peso colombiano a dolar";
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion(eleccion,valorConversion1);

            };
                break;

            case 7 : eleccionRespuesta="Salir";
                break;

            default:eleccionRespuesta = "un numero de eleccion incorrecto";
                break;

        }
        return eleccionRespuesta;
    }

//    Conversion de moneda
    @Override
    public Double Conversion(int eleccion, Double valorMoneda) {
        HttpClient httpClient = HttpClient.newHttpClient();


        return 0.0;
    }

//    Solicitud eleccion de menu
    @Override
    public void SolicitudDeConversion() {
        Scanner scanner = new Scanner(System.in);
        String eleccion = "";
        do{
            System.out.print("""
                    **************************************************************
                        Sea bienvenido/a al Conversor de Moneda =]
                       \s
                        1) Dólar =>> Peso argentino
                        2) Peso argentino =>> Dólar
                        3) Dólar =>> Real brasileño
                        4) Real brasileño =>> Dolar
                        5) Dólar =>> Peso colombiano
                        6) Peso colombiano =>> Dólar
                        7) Salir
                        Elija una opción valida:
                        \s
                    ************************************************************+*
                   \s""");
            int eleccionPersona = scanner.nextInt();
            eleccion = this.MenuDeConversion(eleccionPersona);

            System.out.println("La persona ha elegido " + eleccion);



        }
        while (!Objects.equals(eleccion, "Salir"));

    }



}
