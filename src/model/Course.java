package model;

public class Course {
    public int cid;
    public String courseName;
    //public String specialisation;
    public String collegeName;
    public int duration;
    public String university;

    public Course() {
    	
    }
    
    public Course(int cid, String courseName, String collegeName, int duration,
                  String university) {
        this.cid = cid;
        this.courseName = courseName;
  //      this.specialisation = specialisation;
        this.collegeName = collegeName;
        this.duration = duration;
        this.university = university;
    }

    public Course(int cid) {
        super();
        this.cid = cid;
    }

    public Course(String courseName, String collegeName, int duration,
                  String university) {
        this.courseName = courseName;
 //       this.specialisation = specialisation;
        this.collegeName = collegeName;
        this.duration = duration;
        this.university = university;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

/*    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
*/
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}