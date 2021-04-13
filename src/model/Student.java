package model;

import java.util.Date;

public class Student {
    protected int sid;
    //Pass the course id in constructor
    protected int cuid;
    //Pass the batch id in constructor
    protected int bid;
    protected String nameBySSC;
    protected String gender;
    protected String currentCity;
    protected Date dateOfBirth;
    protected String languagesKnown;
    protected String emaiId;
    protected String phoneNumber;
    protected String whatsappNumber;
    protected String homeTown;
    protected String state;
    protected String course;
    protected String institute;
    protected String dreamCompanies;
    protected String postgrad;
    protected String gradCourse;
    protected double gradPercent;
    protected double gradCGPA;
    protected String gradYear;
    protected String gradInstitute;
    protected String gradUniversity;
    protected String gradCityState;
    protected double hscPercent;
    protected double hscCGPA;
    protected String hscYear;
    protected double sscPercent;
    protected double sscCGPA;
    protected String sscYear;
    protected String gap;
    protected int yearsOfGap;
    protected String workExp;
    protected String companyName;
    protected String companyLoc;
    protected String yearsOfExp;

    public Student() {

    }

    public Student(int sid, int cuid, int bid, String nameBySSC, String gender, String currentCity,
                   Date dateOfBirth, String languagesKnown, String emaiId, String phoneNumber, String whatsappNumber,
                   String homeTown, String state, String course, String institute, String dreamCompanies, String postgrad,
                   String gradCourse, double gradPercent, double gradCGPA, String gradYear,
                   String gradInstitute, String gradUniversity, String gradCityState, double hscPercent,double hscCGPA,
                   String hscYear, double sscPercent,double sscCGPA, String sscYear, String gap, int yearsOfGap, String workExp,
                   String companyName, String companyLoc, String yearsOfExp) {
        //super();
        this.sid = sid;
        this.cuid = cuid;
        this.bid = bid;
        this.nameBySSC = nameBySSC;
        this.gender = gender;
        this.currentCity = currentCity;
        this.dateOfBirth = dateOfBirth;
        this.languagesKnown = languagesKnown;
        this.emaiId = emaiId;
        this.phoneNumber = phoneNumber;
        this.whatsappNumber = whatsappNumber;
        this.homeTown = homeTown;
        this.state = state;
        this.course = course;
        this.institute = institute;
        this.dreamCompanies = dreamCompanies;
        this.postgrad = postgrad;
        this.gradCourse = gradCourse;
        this.gradPercent = gradPercent;
        this.gradCGPA=gradCGPA;
        this.gradYear = gradYear;
        this.gradInstitute = gradInstitute;
        this.gradUniversity = gradUniversity;
        this.gradCityState = gradCityState;
        this.hscPercent = hscPercent;
        this.hscCGPA=hscCGPA;
        this.hscYear = hscYear;
        this.sscPercent = sscPercent;
        this.sscCGPA=sscCGPA;
        this.sscYear = sscYear;
        this.gap = gap;
        this.yearsOfGap = yearsOfGap;
        this.workExp = workExp;
        this.companyName = companyName;
        this.companyLoc = companyLoc;
        this.yearsOfExp = yearsOfExp;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getCuid() {
        return cuid;
    }

    public void setCuid(int cuid) {
        this.cuid = cuid;
    }

    public String getNameBySSC() {
        return nameBySSC;
    }

    public void setNameBySSC(String nameBySSC) {
        this.nameBySSC = nameBySSC;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLanguagesKnown() {
        return languagesKnown;
    }

    public void setLanguagesKnown(String languagesKnown) {
        this.languagesKnown = languagesKnown;
    }

    public String getEmaiId() {
        return emaiId;
    }

    public void setEmaiId(String emaiId) {
        this.emaiId = emaiId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getDreamCompanies() {
        return dreamCompanies;
    }

    public void setDreamCompanies(String dreamCompanies) {
        this.dreamCompanies = dreamCompanies;
    }

    public String getPostgrad() {
        return postgrad;
    }

    public void setPostgrad(String postgrad) {
        this.postgrad = postgrad;
    }


    public String getGraduationCourse() {
        return gradCourse;
    }

    public void setGraduationCourse(String graduationCourse) {
        this.gradCourse = graduationCourse;
    }

    public double getGraduationPercent() {
        return gradPercent;
    }

    public void setGraduationPercent(double graduationPercent) {
        this.gradPercent = graduationPercent;
    }
    
    public double getGradCGPA() {
        return gradCGPA;
    }

    public void setGradCGPA(double gradCGPA) {
        this.gradCGPA = gradCGPA;
    }

    public String getGraduationYear() {
        return gradYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.gradYear = graduationYear;
    }

    public String getGraduationInstitute() {
        return gradInstitute;
    }

    public void setGraduationInstitute(String graduationInstitute) {
        this.gradInstitute = graduationInstitute;
    }

    public String getGraduationUniversity() {
        return gradUniversity;
    }

    public void setGraduationUniversity(String graduationUniversity) {
        this.gradUniversity = graduationUniversity;
    }

    public String getGraduationCityState() {
        return gradCityState;
    }

    public void setGraduationCityState(String graduationCityState) {
        this.gradCityState = graduationCityState;
    }

    public double getHscPercent() {
        return hscPercent;
    }

    public void setHscPercent(double hscPercent) {
        this.hscPercent = hscPercent;
    }

    public double getHscCGPA() {
        return hscCGPA;
    }

    public void setHscCGPA(double hscCGPA) {
        this.hscCGPA = hscCGPA;
    }
    
    public String getHscYear() {
        return hscYear;
    }

    public void setHscYear(String hscYear) {
        this.hscYear = hscYear;
    }

    public double getSscPercent() {
        return sscPercent;
    }

    public void setSscPercent(double sscPercent) {
        this.sscPercent = sscPercent;
    }

    public double getSscCGPA() {
        return sscCGPA;
    }

    public void setSscCGPA(double sscCGPA) {
        this.sscCGPA = sscCGPA;
    }
    
    public String getSscYear() {
        return sscYear;
    }

    public void setSscYear(String sscYear) {
        this.sscYear = sscYear;
    }

    public String getEducationalGap() {
        return gap;
    }

    public void setEducationalGap(String educationalGap) {
        this.gap = educationalGap;
    }
    
    public int getYearsOfGap() {
        return yearsOfGap;
    }

    public void setYearsOfGap(int yearsOfGap) {
        this.yearsOfGap = yearsOfGap;
    }

    public String getWorkExperience() {
        return workExp;
    }

    public void setWorkExperience(String workExperience) {
        this.workExp = workExperience;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLoc;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLoc = companyLocation;
    }

    public String getYearsOfExperience() {
        return yearsOfExp;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExp = yearsOfExperience;
    }
}