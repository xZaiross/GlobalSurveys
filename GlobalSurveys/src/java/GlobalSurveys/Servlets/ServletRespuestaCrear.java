/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GlobalSurveys.Servlets;

import GlobalSurveys.Ejb.PreguntaFacade;
import GlobalSurveys.Ejb.RespuestaFacade;
import GlobalSurveys.Entity.Pregunta;
import GlobalSurveys.Entity.Respuesta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acarr
 */
@WebServlet(name = "ServletRespuestaCrear", urlPatterns = {"/ServletRespuestaCrear"})
public class ServletRespuestaCrear extends HttpServlet {

    @EJB
    private RespuestaFacade respuestaFacade;

    @EJB
    private PreguntaFacade preguntaFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         Respuesta respuesta = new Respuesta(); 
         String str = request.getParameter("idrespuesta");
         respuesta.setIdRespuesta(new Long(str));
         
         str = request.getParameter("respuesta");
         respuesta.setRespuesta(str);
         
         
         str = request.getParameter("pregunta");
         Pregunta pregunta = preguntaFacade.find(new Long(str));
         respuesta.setIdPregunta(pregunta);
         pregunta.getRespuestaList().add(respuesta);
         
          this.respuestaFacade.create(respuesta);
          this.preguntaFacade.edit(pregunta);
                 
        RequestDispatcher rd = request.getRequestDispatcher("Preguntas");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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