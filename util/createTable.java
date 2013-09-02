/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import map.School;
import map.Subject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;

/**
 *
 * @author Hans
 */
@WebServlet(name = "createTable", urlPatterns = {"/createTable"})
public class createTable extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            String su = request.getParameter("subid");

            int i = 1;

            Session s = NewHibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();

            Criteria cr = s.createCriteria(Subject.class);
            cr.add(Restrictions.eq("idsubject", Integer.parseInt(su)));
            Subject sab = (Subject) cr.uniqueResult();
            Subject subt = (Subject) s.load(Subject.class, sab.getIdsubject());


            Criteria c = s.createCriteria(School.class);
            c.add(Restrictions.eq("subject", subt));
            
            JSONArray json = new JSONArray();
            Map m = new HashMap();

            List<School> list = c.list();

            for (School school : list) {
                m.put("schoolName", school.getSchoolName());
                m.put("grade11", school.getGrade11());
                m.put("grade10", school.getGrade10());
                m.put("grade9", school.getGrade9());
                m.put("subject", school.getSubject().getSubjectName());
                
                json.add(m);
                
                m= null;
                m= new HashMap();
                
                out.write(json.toJSONString());
                
                
//                out.write("<tr>" + school.getSchoolName() + "</tr>");
//                out.write("<tr>" + school.getGrade11() + "</tr>");
//                out.write("<tr>" + school.getGrade10() + "</tr>");
//                out.write("<tr>" + school.getGrade9() + "</tr>");
//                out.write("<tr>" + school.getSubject().getSubjectName() + "</tr>");
            }




        } catch (Exception e) {
            throw new ServletException(e);
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
