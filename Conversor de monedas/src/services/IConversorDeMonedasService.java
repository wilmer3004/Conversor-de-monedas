package services;

public interface IConversorDeMonedasService {
    public String MenuDeConversion(int eleccion);
    public Double Conversion(String tipoMoneda1, String tipoMoneda2, Double cantidad);
    public void SolicitudDeConversion();
}
