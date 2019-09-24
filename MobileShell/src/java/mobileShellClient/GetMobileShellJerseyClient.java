/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileShellClient;

import com.shellentity.Shell;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.util.ArrayList;
import java.util.List;

/**
 * Jersey REST client generated for REST resource:ShellFacadeREST
 * [com.shellentity.shell]<br> USAGE:
 * <pre>
 *        GetMobileShellJerseyClient client = new GetMobileShellJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author nabanita
 */
// create restful webservice using restful client
public class GetMobileShellJerseyClient {
// URL of webservice which was created through local database server

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/MobileShell/webresources";

    public GetMobileShellJerseyClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        // Path of webservice
        webResource = client.resource(BASE_URI).path("com.shellentity.shell");
    }
// Delete operation performed through web service

    public void remove(String id) throws UniformInterfaceException {
        webResource.path(java.text.MessageFormat.format("{0}", new Object[]{id})).delete();
    }

    public String countREST() throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("count");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }
// Read operation performed through web service to get a list of elements from XML format

    public <T> T findAll_XML(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
// Read operation performed through web service to get a list of elements from JSON format

    public <T> T findAll_JSON(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
// Update operation performed through web service in XML format

    public void edit_XML(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }
// Update operation performed through web service in JSON format

    public void edit_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(requestEntity);
    }
// Create operation performed through web service in XML format

    public void create_XML(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).post(requestEntity);
    }
// Create operation performed through web service in JSON format

    public void create_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(requestEntity);
    }
// Read operation performed through web service with in a specific range of elements in XML format

    public <T> T findRange_XML(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
// Read operation performed through web service with in a specific range of elements in JSSON format

    public <T> T findRange_JSON(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
// Read operation performed through web service to a particular element from XML format

    public <T> T find_XML(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
// Read operation performed through web service to a particular element from JSON format

    public <T> T find_JSON(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.destroy();
    }

    public static String[] specificShellDetails(String ModelNo) throws UniformInterfaceException {
        GetMobileShellJerseyClient client1 = new GetMobileShellJerseyClient();
        // Find details of a specific model
        String[] value = new String[5];
        ClientResponse response = client1.find_XML(ClientResponse.class, ModelNo);
        int statusCode = response.getStatus();
        if (statusCode == 200) {

            GenericType<Shell> genericType = new GenericType<Shell>() {
            };

            Shell shells = response.getEntity(genericType);

            System.out.println("Brand: " + shells.getBrand());
            System.out.println("Manufacturer: " + shells.getManufacturer());
            System.out.println("Color: " + shells.getColor());
            value[0] = shells.getBrand();
            value[1] = shells.getManufacturer();
            value[2] = shells.getColor();
            value[3] = shells.getModel();
        } else {
            value[0] = "NODATAFOUND";
            value[1] = "NODATAFOUND";
            value[2] = "NODATAFOUND";
            value[3] = ModelNo;
        }
        return value;
    }

    public static ArrayList<String> allModelShell() throws UniformInterfaceException {
        GetMobileShellJerseyClient client1 = new GetMobileShellJerseyClient();
        // Get list of model
    
        ArrayList<String> value = new ArrayList<String>();
        ClientResponse response = client1.findAll_XML(ClientResponse.class);
        GenericType<List<Shell>> genericType = new GenericType<List<Shell>>() {
        };
// Returns an ArrayList of Shells from the web service
        List<Shell> data = new ArrayList<Shell>();
        data = (response.getEntity(genericType));
        System.out.println("Retreiving and Displaying Shells Model Nos");
        for (Shell shells : data) {
            // System.out.println("Model: " + shells.getModel());
            value.add(shells.getModel());

        }
        return value;
    }
}
