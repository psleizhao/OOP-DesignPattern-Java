package viewlayer;

import businesslayer.PeerTutorBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobject.PeerTutor;
import transferobject.Student;

public class PeerTutorServlet extends HttpServlet {

    PeerTutorBusinessLogic logic = null;
    List<PeerTutor> list = null;
    List<Student> studentList = null;
    List<String> gradeList = List.of("A", "A+", "A-");
    PeerTutor peerTutor = null;
    String courseCode = null;

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
        response.setContentType("text/html;charset=UTF-8");
        // TODO:  Add your code here.  Make sure to use try-catch or
        //        try-with-resources statement here.  Need to instantiate a
        //        PrintWriter object which is a resource.  You can use the
        //        PrintWriter object to compose the HTML response of this
        //        servlet.  Also, need to instantiate a PeerTutorBusinessLogic
        //        object here and use it to access the database by calling its
        //        appropriate methods.  As the servlet composes the HTML response,
        //        it should use the business logic object.  You should also
        //        retrieve the request parameters here and instantiate a PeerTutor
        //        object and set its fields as needed.  Use bgcolor="#FDF5E6" for
        //        the background color of the HTML response of this servlet.
        //        Please refer to the sample projects code in Week 9.

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PeerTutorServlet</title>");
            out.println("<style> p, span, caption {font-weight: bold;}</style>");
            out.println("</head>");
            out.println("<body BGCOLOR=\"#FDF5E6\">");
            out.println("<h1>Servlet PeerTutorServlet at " + request.getContextPath() + "</h1>");

            // Initialize PeerTutor object with appropriate data
            String buttonClicked = request.getParameter("submit");
            switch (buttonClicked) {
                case "Assign" -> {
                    peerTutor = new PeerTutor();
                    peerTutor.setLastName(request.getParameter("lastName"));
                    peerTutor.setFirstName(request.getParameter("firstName"));
                    courseCode = request.getParameter("courseCode");
                    logic = new PeerTutorBusinessLogic();
                    peerTutor.setPeerTutorID(logic.getPeerTutorID(peerTutor));
                    // Create a business logic object

                    if (!logic.isPeerTutorRegistered(peerTutor)) {
                        out.println("<ul><li><span>Last Name:</span> " + peerTutor.getLastName()
                                + "</li><li><span>First Name:</span> " + peerTutor.getFirstName()
//                                + "</li><li><span>Course Code:<span> " + courseCode
                                + "</li></ul>");
                        out.println("<p>Error: The person is not registered as a peer tutor.</p>");
                    } else if (!logic.isCourseValid(courseCode)) {
                        out.println("<ul><li><span>Last Name:</span> " + peerTutor.getLastName()
                                + "</li><li><span>First Name:</span> " + peerTutor.getFirstName()
                                + "</li><li><span>Course Code:</span> " + courseCode
                                + "</li></ul>");
                        out.println("<p>Error: The course is not valid.</p>");
                    } else if (!logic.hasPeerTutorTakenCourse(peerTutor, courseCode)) {
                        out.println("<ul><li><span>Last Name:</span> " + peerTutor.getLastName()
                                + "</li><li><span>First Name:</span> " + peerTutor.getFirstName()
                                + "</li><li><span>Course Code:</span> " + courseCode
                                + "</li></ul>");
                        out.println("<p>Error: The peer tutor has not taken the course.</p>");
                    } else if (!gradeList.contains(logic.getPeerTutorLetterGradeForCourse(peerTutor, courseCode))) {
                        out.println("<ul><li><span>Last Name:</span> " + peerTutor.getLastName()
                                + "</li><li><span>First Name:</span> " + peerTutor.getFirstName()
                                + "</li><li><span>Course Code:</span> " + courseCode
                                + "</li></ul>");
                        out.println("<p>Error: The letter grade obtained by the peer tutor for the course is not sufficient.</p>");
                    } else if (logic.isCourseAlreadyAssignedToPeerTutor(peerTutor, courseCode)) {
                        out.println("<ul><li><span>Last Name:</span> " + peerTutor.getLastName()
                                + "</li><li><span>First Name:</span> " + peerTutor.getFirstName()
                                + "</li><li><span>Course Code:</span> " + courseCode
                                + "</li></ul>");
                        out.println("<p>Error: The peer tutor is already assigned to the course.</p>");
                    } else {
                        // Perform insert and display logic
                        // You can add your code here to insert data into the database
                        // and display the result.
                        int rowAffected = logic.assignCourseToPeerTutor(peerTutor, courseCode);
                        list = logic.getAllPeerTutorsForCourse(courseCode);
                        
//                        out.println(rowAffected > 0 ? "<p>Assigned!</p>" : "<p>Assign failed!</p>");
                        if(rowAffected > 0) {
                            out.println("<p>Peer tutor " + peerTutor.getPeerTutorID() + " "
                                        + peerTutor.getFirstName() + " " + peerTutor.getLastName() + " "
                                        + "has been assigned to course " + courseCode + "</p>");
                        }
                        else {
                            out.println("<p>Assign failed!</p>");
                        }
                        
                        out.println("<table border=\"1\">");
                        out.println("<caption>Table of Peer Tutors for CST8101</caption>");
                        out.println("<tr>");
                        out.println("<td>TutorID</td>");
                        out.println("<td>Last Name</td>");
                        out.println("<td>First Name</td>");
                        out.println("</tr>");
                        for (PeerTutor tutor : list) {
                            out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                                    tutor.getPeerTutorID(), tutor.getLastName(), tutor.getFirstName());
                        }
                        out.println("</table>");
                    }
                }

                case "Delete" -> {
                    logic = new PeerTutorBusinessLogic();
                    peerTutor = new PeerTutor();
                    String idParam = request.getParameter("peerTutorID");

                    try {
                        peerTutor.setPeerTutorID(Integer.parseInt(idParam));
                    } catch (NumberFormatException e) {
                        out.println("<p>Please enter a valid peer tutor ID!</p>");
                    }

                    int rowAffected = logic.deletePeerTutor(peerTutor);
                    list = logic.getAllPeerTutorsForCourse("CST8101");
                    
//                    out.println(rowAffected > 0 ? "<p>Deleted!</p>" : "<p>Delete failed!</p>");
                    if(rowAffected>0){
                        out.println("<p>Peer tutor " + peerTutor.getPeerTutorID() 
                                + " " + peerTutor.getFirstName()+ " " + peerTutor.getLastName()                                
                                + " has been removed from peer tutor list of course CST8101!</p>");
                    }
                    else{
                        out.println("<p>Delete failed! Please comfirm if this student is a peer tutor.</p>");
                    }
                    
                    out.println("<table border=\"1\">");
                    out.println("<caption>Table of Peer Tutors for CST8101</caption>");
                    out.println("<tr>");
                    out.println("<td>TutorID</td>");
                    out.println("<td>Last Name</td>");
                    out.println("<td>First Name</td>");
                    out.println("</tr>");
                    for (PeerTutor tutor : list) {
                        out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                                tutor.getPeerTutorID(), tutor.getLastName(), tutor.getFirstName());
                    }
                    out.println("</table>");
                }

                case "Update" -> {
                    Student oldStudent = new Student();
                    Student newStudent = new Student();
                    String oldLastName = request.getParameter("oldLastName");
                    String oldFirstName = request.getParameter("oldFirstName");
                    String newLastName = request.getParameter("newLastName");
                    String newFirstName = request.getParameter("newFirstName");
                    int studentID;
//                    List<Student> studentList = null;

                    
                    logic = new PeerTutorBusinessLogic();

                    oldStudent.setLastName(oldLastName);
                    oldStudent.setFirstName(oldFirstName);
                    studentID = logic.getStudentID(oldStudent);
                    
                    newStudent.setLastName((newLastName.isEmpty()) ? oldLastName : newLastName);
                    newStudent.setFirstName((newFirstName.isEmpty()) ? oldFirstName : newFirstName);
                    
                    oldStudent.setStudentID(studentID);
                    String oldStudentString = oldStudent.getStudentID() + " " + oldStudent.getFirstName() + " " + oldStudent.getLastName();
                    String newStudentString = newStudent.getFirstName() + " " + newStudent.getLastName();
                    
                    int rowAffected = logic.updateStudent(oldStudent, newStudent);
                    studentList = logic.getAllStudents();
                            
                    if(rowAffected>0){
                        out.println("<p>Student " + oldStudentString + "'s name has been updated to " + newStudentString + "!</p>" );
                    }
                    else{
                        out.println("<p>Student Name Update failed!</p>" );
                    }
                    
                    out.println("<table border=\"1\">");
                    out.println("<caption>Table of Students</caption>");
                    out.println("<tr>");
                    out.println("<td>Student ID</td>");
                    out.println("<td>Last Name</td>");
                    out.println("<td>First Name</td>");
                    out.println("</tr>");
                    for (Student student : studentList) {
                        out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                                student.getStudentID(), student.getLastName(), student.getFirstName());
                    }
                    out.println("</table>");
                }

                default -> {
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
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
