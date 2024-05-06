package services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
                System.out.println("Elija el valor que deseas convertir");
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion("USD",  "ARS",  valorConversion1);
                return "El valor " + valorConversion1 + " [USD] corresponde al valor final de =>>> " + valorDeConversion + "[ARS] \n";
            }

            case 2: {

                eleccionRespuesta = "conversion de peso argentino a dolar";
                System.out.println("Elija el valor que deseas convertir");
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion("ARS",  "USD",  valorConversion1);
                return "El valor " + valorConversion1 + " [ARS] corresponde al valor final de =>>> " + valorDeConversion + "[USD] \n";
            }

            case 3 : {

                eleccionRespuesta = "conversion de dolar a real brasileño";
                System.out.println("Elija el valor que deseas convertir");
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion("USD",  "BRL",  valorConversion1);
                return "El valor " + valorConversion1 + " [USD] corresponde al valor final de =>>> " + valorDeConversion + "[BRL] \n";
            }

            case 4 : {

                eleccionRespuesta = "conversion de real brasileño a dolar";
                System.out.println("Elija el valor que deseas convertir");
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion("BRL", "USD",  valorConversion1);
                return "El valor " + valorConversion1 + " [BRL] corresponde al valor final de =>>> " + valorDeConversion + "[USD] \n";
            }
            case 5 : {

                eleccionRespuesta = "conversion de dolar a peso colombiano";
                System.out.println("Elija el valor que deseas convertir");
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion("USD", "COP",  valorConversion1);
                return "El valor " + valorConversion1 + " [USD] corresponde al valor final de =>>> " + valorDeConversion + "[COP] \n";
            }

            case 6 : {

                eleccionRespuesta = "conversion de peso colombiano a dolar";
                System.out.println("Elija el valor que deseas convertir");
                Double valorConversion1 = sc.nextDouble();
                valorDeConversion = this.Conversion("COP", "USD",  valorConversion1);
                return "El valor " + valorConversion1 + " [COP] corresponde al valor final de =>>> " + valorDeConversion + "[USD] \n";
            }

            case 7 : eleccionRespuesta="Salir";
                break;

            default:eleccionRespuesta = "un numero de eleccion incorrecto";
                break;

        }
        return eleccionRespuesta;
    }

//    Conversion de moneda
    @Override
    public Double Conversion(String tipoMoneda1, String tipoMoneda2, Double cantidad) {

        String url = "https://v6.exchangerate-api.com/v6/61ae0ed654f408b0e48c59bd/latest/" + tipoMoneda1;

        try {

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                Gson gson = new Gson();
                JsonObject jsonobj = gson.fromJson(responseBody, JsonObject.class);

                double tasaDeConversion = jsonobj.getAsJsonObject("conversion_rates").get(tipoMoneda2).getAsDouble();

                return cantidad * tasaDeConversion;
            } else {
                throw new IOException("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
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
