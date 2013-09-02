<%-- 
    Document   : index
    Created on : Aug 31, 2013, 8:38:12 PM
    Author     : Hans
--%>

<%@page import="map.School"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="map.Subject"%>
<%@page import="map.Subject"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="util.NewHibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css" title="currentstyle">
            @import "jquery-ui-1.10.3.custom.css";
            @import "demo_page.css";
            @import "demo_table.css";
            /*  @import "facebox/facebox.css";*/
        </style>

        <meta charset="utf-8" />


        <script type="text/javascript" src="jquery.js"></script>
        <script type="text/javascript" src="jquery.dataTables.js"></script>
        <script type="text/javascript" src="jquery-ui-1.10.3.custom.js"></script>

        <script type="text/javascript" src="js.js"></script>

        <script type="text/javascript" >
  
            jQuery(document).ready(function(){
     

                $('#test_table').dataTable({
                    "bStateSave": true,
                    "bJQueryUI" : true,
                    "bFilter": true,
                    "bPaginate" : true,
                    "bInfo" : true,
                    "bSort" : true        
                });
            });
        </script>
    </head>
    <body onload="">
        <h1> CingleVue Coding Challenge!</h1>
<br/><br/>
        <div>
            <label for="subject">Select Subject :</label>
            <select id="subject" name="subject" onchange="loadMarks(this.value)"> 
                <option value="" selected="selected">Select Subject</option>
                <%
                    Session s = NewHibernateUtil.getSessionFactory().openSession();
                    Transaction t = s.beginTransaction();

                    Criteria cr = s.createCriteria(Subject.class);
                    List<Subject> list = cr.list();

                    for (Subject subject : list) {%>

                <option value="<%=subject.getIdsubject()%>"><%=subject.getSubjectName()%></option>
                <%  }


                %>

            </select>
        </div>



        <table width="100%" cellpadding="0" cellspacing="0" class="display" id="test_table">
            <thead>
                <tr>                                        
                    <th>School Name</th>
                    <th>Grade 11</th>
                    <th>Grade 10</th>
                    <th>Grade 9</th>
                    <th>Subject</th>

                </tr>

            </thead>
            <tbody id="dis" >
                <%
                    Session se = NewHibernateUtil.getSessionFactory().openSession();
                    Transaction tr = se.beginTransaction();

                    Criteria cri = se.createCriteria(School.class);
                    List<School> li = cri.list();

                                for (School sch : li) {%>

                <tr>


                    <td><%=sch.getSchoolName()%></td>
                    <td><%=sch.getGrade11()%></td>
                    <td><%=sch.getGrade10()%></td>
                    <td><%=sch.getGrade9()%></td>
                    <td><%=sch.getSubject().getSubjectName()%></td>


                    <%}%>

                </tr>
            </tbody>
        </table>
        

    </body>
</html>
