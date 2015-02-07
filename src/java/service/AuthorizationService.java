/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author johanand
 */
@WebService(serviceName = "AuthorizationServiceService", 
            portName = "AuthorizationServicePort", 
            endpointInterface = "org.netbeans.j2ee.wsdl.authorizationservice.java.authorizationservice.AuthorizationServicePortType", 
            targetNamespace = "http://j2ee.netbeans.org/wsdl/AuthorizationService/java/AuthorizationService", 
            wsdlLocation = "WEB-INF/wsdl/AuthorizationService/AuthorizationService.wsdl")
@Stateless
public class AuthorizationService {
    private static final Map<String, String> USERS;
    
    static {
        USERS = new HashMap<>();
        USERS.put("johan", "pass");
        USERS.put("user", "password");
        USERS.put("andre", "word");
    }
    
    public boolean authorizationServiceOperation(java.lang.String username, java.lang.String password) {
        String foundPassword = USERS.get(username);
        if (foundPassword == null)
            return false;
        
        return foundPassword.equals(password);
    }
    
}
