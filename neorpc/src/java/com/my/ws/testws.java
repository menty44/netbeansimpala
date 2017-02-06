package com.my.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(name = "MyJaxWSHello", 
		targetNamespace = "http://globinch.com", 
		wsdlLocation = "http://globinch.com/ws/MyJaxWS?wsdl")
@SOAPBinding(style=Style.RPC, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)		
public interface testws {

	  @WebMethod(operationName="getGreetingRequest")
	  @WebResult(targetNamespace="http://globinch.com/ws/types",
	     name="GreetingResponse")
	  public JXRes getJXWsRes(
	     @WebParam(targetNamespace="http://globinch.com/ws/types",
	               name="name",
	               mode=Mode.IN)
	               String name
	  );

    public static class JXRes {

        public JXRes() {
        }
    }

}
