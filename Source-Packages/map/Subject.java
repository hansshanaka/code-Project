package map;
// Generated Sep 1, 2013 9:33:25 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Subject generated by hbm2java
 */
public class Subject  implements java.io.Serializable {


     private Integer idsubject;
     private String subjectName;
     private Set<School> schools = new HashSet<School>(0);

    public Subject() {
    }

    public Subject(String subjectName, Set<School> schools) {
       this.subjectName = subjectName;
       this.schools = schools;
    }
   
    public Integer getIdsubject() {
        return this.idsubject;
    }
    
    public void setIdsubject(Integer idsubject) {
        this.idsubject = idsubject;
    }
    public String getSubjectName() {
        return this.subjectName;
    }
    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public Set<School> getSchools() {
        return this.schools;
    }
    
    public void setSchools(Set<School> schools) {
        this.schools = schools;
    }




}


