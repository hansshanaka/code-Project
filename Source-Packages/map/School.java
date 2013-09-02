package map;
// Generated Sep 1, 2013 9:33:25 AM by Hibernate Tools 3.2.1.GA



/**
 * School generated by hbm2java
 */
public class School  implements java.io.Serializable {


     private SchoolId id;
     private Subject subject;
     private String schoolName;
     private Integer grade11;
     private Integer grade10;
     private Integer grade9;

    public School() {
    }

	
    public School(SchoolId id, Subject subject) {
        this.id = id;
        this.subject = subject;
    }
    public School(SchoolId id, Subject subject, String schoolName, Integer grade11, Integer grade10, Integer grade9) {
       this.id = id;
       this.subject = subject;
       this.schoolName = schoolName;
       this.grade11 = grade11;
       this.grade10 = grade10;
       this.grade9 = grade9;
    }
   
    public SchoolId getId() {
        return this.id;
    }
    
    public void setId(SchoolId id) {
        this.id = id;
    }
    public Subject getSubject() {
        return this.subject;
    }
    
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public String getSchoolName() {
        return this.schoolName;
    }
    
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public Integer getGrade11() {
        return this.grade11;
    }
    
    public void setGrade11(Integer grade11) {
        this.grade11 = grade11;
    }
    public Integer getGrade10() {
        return this.grade10;
    }
    
    public void setGrade10(Integer grade10) {
        this.grade10 = grade10;
    }
    public Integer getGrade9() {
        return this.grade9;
    }
    
    public void setGrade9(Integer grade9) {
        this.grade9 = grade9;
    }




}

