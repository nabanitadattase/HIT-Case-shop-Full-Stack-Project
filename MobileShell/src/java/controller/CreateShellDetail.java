/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobileShellClient.CreateMobileShellJersyClient;

/**
 *
 * @author nabanita
 */
public class CreateShellDetail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Declare variables
        String ModelNo = "";
        String Brand = "";
        String Manufacturer = "";
        String Color = "";
        String Msg = "";
        String message1 = "blank";
        try {
            //Getting the field values from JSP page
            ModelNo = (String) request.getParameter("model");
            Brand = (String) request.getParameter("brand1");
            Manufacturer = (String) request.getParameter("manufacturer1");
            Color = (String) request.getParameter("color1");
            //Creating an object of model class 
            CreateMobileShellJersyClient shc = new CreateMobileShellJersyClient();
            // Checking if all field values are not null 
            if (ModelNo != "" && Brand != "" && Manufacturer != "" && Color != "") {
                // insert the details of a shell
                Msg = shc.insertShellDetails(ModelNo, Brand, Manufacturer, Color);
                // Set the confimation message in request
                request.setAttribute("Msg", Msg);
                //Sending the message to the JSP page
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } // Checking if any field values are null 
            else {
                // Set the go back message in request
                request.setAttribute("message1", message1);
                //Sending the message to the JSP page
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }


        } 
        //if try block get failure then goes to catch block and print exception
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
