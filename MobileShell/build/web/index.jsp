<%-- 
    Document   : index
    Created on : 20 Sep, 2019, 1:21:11 PM
    Author     : naba
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String Msg = "";
    String Msg1 = "";
    String message = "";
    String message1 = "";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HIT Case shop</title>
        <script type="text/javascript" src="script.js"></script>
    </head>
    <body>  
<!--        Servlet calling to get the details of a specific model no.-->
        <form name="search" method="POST" action="GetShellDetail">
            <center>  <h1>HIT Case shop</h1></center>
            <table align="center">
<!--                Servlet calling to get the list of Shell Model-->
                <tr>
                    <td>
                        <input type="submit" value="List Of Shell Model" onclick="form.action='AllModelDetail';"/>  
                    </td> 
                </tr> 
                <tr>
<!--                    Shows list of Shell model No.s-->
                <center> <h4>
                        <%
                            if ((ArrayList<String>) request.getAttribute("ModelDetails") != null) {
                                ArrayList list = (ArrayList<String>) request.getAttribute("ModelDetails");
                                try {
                                    StringBuilder sb = new StringBuilder();
                                    for (int i = 0; i < list.size(); i++) {
                                        sb.append(list.get(i).toString() + ",");

                                    }
                                    out.println("In This Shop " + sb.toString() + " Shell Model No.s Are Available");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        %> 
                    </h4></center>
                </tr> 
                <tr>
                <p><center><font color="red">Asterisk Mark(*)fields are mandatory</font></center></p>
                <td> Enter Shell Model No : <font color="red">*</font></td>
                <td><input type="text" id="modelno" name ="modelno" size="5"/>

                    <input type="submit" value="Get Details" /></td>

                </tr>
                <tbody>
<!--                    Display message if don't provide Modelno, but click submit button-->
                    <tr><% if (request.getAttribute("message") != null) {
                        %>
                <h4><center>Please provide Model No</center></h4></tr>
                <%   }%>
                <!--   Getting the Shell details From Servlet for a particular Model No.-->
                <%
                    if ((ArrayList<String>) request.getAttribute("arrayList") != null) {
                        ArrayList list = (ArrayList<String>) request.getAttribute("arrayList");
                %> 
                <tr>
                    <td > Shell Brand:</td >
                    <td> <input type = "text" id = "brand" name = "brand" size = "15" value =
                                <%= list.get(0).toString()%> readonly> 
                    </td>
                </tr>
                <tr>
                    <td>Shell Manufacturer : </td>
                    <td> <input type="text" id= "manufacturer" name ="manufacturer" size="15" value=
                                <%= list.get(1).toString()%> readonly> 
                    </td>
                </tr>

                <tr>
                    <td>Shell Color : </td>
                    <td> <input type="text" id="color" name ="color" size="15" value=
                                <%= list.get(2).toString()%> readonly>
                    </td>
                    <td><% if (request.getAttribute("message1") != null) {
                        %>
                        <h4><center>Please provide all the Details</center></h4></td>
                        <%   }%>
                </tr>
                <tr>
                    <td>Shell Model No. : </td>
                    <td> <input type="text" id="modelno" name ="modelno" size="5" value=
                                <%= list.get(3).toString()%> readonly>
                    </td>
                </tr>
                <% }%>
                </tbody>
                <tbody>
                    <tr><td>

                            <a id="displayText" href="javascript:ShellFunction();">Add Another Shell</a> <== click Here
                        </td></tr>    
                </tbody>
                <tbody id="toggleText" style="display: none;">

                    <tr>
                        <td>Enter Shell Model No : <font color="red">*</font></td>
                        <td><input type="text" id="modelno" name ="model" size="5"/></td>
                    </tr>
                    <tr>
                        <td > Shell Brand:<font color="red">*</font></td >
                        <td> <input type = "text" id = "brand1" name = "brand1" size = "10" > 
                        </td>
                    </tr>
                    <tr>
                        <td>Shell Manufacturer : <font color="red">*</font></td>
                        <td> <input type="text" id= "manufacturer1" name ="manufacturer1" size="10" > 
                        </td>

                    </tr>

                    <tr>
                        <td>Shell Color :<font color="red">*</font> </td>
                        <td> <input type="text" id="color1" name ="color1" size="10" >
                        </td>
                    </tr>
<!--                    Calling Servlet to Add a Shell details -->
                    <tr>
                        <td>
                            <input type="submit" value="Save" onclick="form.action='CreateShellDetail';"/>  
                        </td> 
                    </tr>  
<!--                    Shows message  after successfully Adding shell details-->
                    <tr><% if (request.getAttribute("Msg") == "Success") {
                        %>
                <h4><center>Shell Information saved successfully</center></h4></tr>
                <%   }%> 
<!--            Shows below message if add the same model no. which already exist -->
                <tr> <% if (request.getAttribute("Msg") == "Failure") {%>     
                <h4><center>Same Model Number already exist</center></h4></tr>
                <% }%>

                </tbody>

            </table> 
        </form>

    </body>
</html>
