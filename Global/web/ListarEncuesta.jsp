<%-- 
    Document   : ListarEncuesta
    Created on : 14-ene-2020, 10:30:37
    Author     : ilariadot
--%>



<%@page import="java.util.List"%>
<%@page import="GlobalSurveys.Entity.Encuesta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Encuestas</title>
    <%
        List<Encuesta> lista = (List)request.getAttribute("listado");
    %>
    </head>
    <body>
        <h1>Listado de encuestas</h1>
        
        <table>
            <%
                for (Encuesta encuesta: lista) {
            %>
            <tr>
                <td>Nombre de la encuesta</td>   
                <td>Descripcion de la encuesta</td>
            <td><button onclick="window.location.href = 'ServletEncuestaEditar?id=<%= encuesta.getIdEncuesta()%>';">Editar</button>                               
            <td><button onclick="window.location.href = 'ServletEncuestaBorrar?id=<%= encuesta.getIdEncuesta()%>';">Borrar</button>
                
            </tr>
            
            <tr>
                <td><%= encuesta.getNomEncuesta() %></td> 
                <td><%= encuesta.getDescripcionEncuesta()%></td>
                <td><button onclick="window.location.href = 'ServletEncuestaEditar?id=<%= encuesta.getIdEncuesta()%>';">Editar</button>                               
                <td><button onclick="window.location.href = 'ServletEncuestaBorrar?id=<%= encuesta.getIdEncuesta()%>';">Borrar</button>
                
            </tr>
                    
              
                
            <tr>
                
            
            
            
          
                   
                    
                    
                    
            </tr>
                
                                                 
            
            <%
                }
            %>    
           
        </table>
        
        <button onclick="window.location.href = 'PanelAdmin.jsp';">Volver</button>
    </body>
</html>

