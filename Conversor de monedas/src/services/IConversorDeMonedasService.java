package services;

public interface IConversorDeMonedasService {
    public String MenuDeConversion(int eleccion);
    public Double Conversion(int eleccion, Double valorMoneda);
    public void SolicitudDeConversion();
}
