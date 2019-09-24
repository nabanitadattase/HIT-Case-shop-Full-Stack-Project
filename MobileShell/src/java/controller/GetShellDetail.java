/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobileShellClient.GetMobileShellJerseyClient;

/**
 *
 * @author nabanita
 */
public class GetShellDetail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Declare variables
        String ModelNo = "";
        String[] details = new String[30];
        String message = "blank";
        try {
            //Getting the Model No from JSP page
            ModelNo = (String) request.getParameter("modelno");
            //Creating an object of model class 
            GetMobileShellJerseyClient shd = new GetMobileShellJerseyClient();
            // Checking nullability of the specific field
            if (ModelNo != "") {
               // Get the shell details in array form
                details = shd.specificShellDetails(ModelNo);
                //Create an arraylist to convert the array to ArrayList
                ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(details));
               // Set the list of Values in Request
                request.setAttribute("arrayList", arrayList);
                //Sending the Values to the JSP page
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } 
            else {
                request.setAttribute("message", message);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (Exception e) {
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
