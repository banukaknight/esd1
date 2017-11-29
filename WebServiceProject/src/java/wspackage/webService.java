/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspackage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jake
 */
@WebService(serviceName = "webService")
public class webService {
    /**
     * Web service operation
     */
    @WebMethod(operationName = "calculateTotal")
    public double calculateTotal(@WebParam(name = "claims") double claims, @WebParam(name = "membersSize") int membersSize) {
        return claims / membersSize;
    }
}
