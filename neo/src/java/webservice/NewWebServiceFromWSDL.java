/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author impala
 */


@WebService(serviceName = "GlobalWeather", portName = "GlobalWeatherSoap", endpointInterface = "net.webservicex.GlobalWeatherSoap", targetNamespace = "http://www.webserviceX.NET", wsdlLocation = "WEB-INF/wsdl/NewWebServiceFromWSDL/www.webservicex.com/globalweather.asmx.wsdl")
public class NewWebServiceFromWSDL {

    public String getWeather(String cityName, String countryName) {
        //TODO implement this method
        //throw new UnsupportedOperationException("Not implemented yet.");
        return cityName;
    }

    public String getCitiesByCountry(String countryName) {
        //TODO implement this method
        //throw new UnsupportedOperationException("Not implemented yet.");
        return countryName;
    }
    
    public int add(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        return i + j;
    }
    
}
