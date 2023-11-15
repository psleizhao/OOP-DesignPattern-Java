/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataaccesslayer;

import java.util.List;
import transferobject.Student;

/**
 *
 * @author pdstu
 */
public interface StudentDAO {
    int getStudentID(Student student);
    List<Student> getAllStudents();
}
