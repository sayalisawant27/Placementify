package model;

import java.util.Date;

public class Student {
    protected int sid;
    protected int cuid;
    protected int bid;
    protected String nameBySSC;
    protected String emaiId;
    protected String phoneNumber;
    protected String whatsappNumber;
    protected String gender;
    protected Date dateOfBirth;
    protected String currentState;
    protected String currentCity;
    protected String homeState;
    protected String homeCity;
    protected String languagesKnown;
    protected String currentCourse;
    protected String currentBatch;
    protected String currentInstitute;
    protected String postgrad;
    protected String dreamCompanies;
    protected String gradCourse;
    protected double gradCGPA;
    protected String gradYear;
    protected double gradPercent;
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
    protected int yearsOfExp;
    protected String companyName;
    protected String companyLoc;
    protected String formId;
    protected String resume;
    protected String photo;

    public Student() {

    }

	public Student(int cuid, int bid, String nameBySSC, String emaiId, String phoneNumber, String whatsappNumber,
			String gender, Date dateOfBirth, String currentState, String currentCity, String homeState, String homeCity,
			String languagesKnown, String currentCourse, String currentBatch, String currentInstitute, String postgrad,
			String dreamCompanies, String gradCourse, double gradCGPA, String gradYear, double gradPercent,
			String gradInstitute, String gradUniversity, String gradCityState, double hscPercent, double hscCGPA,
			String hscYear, double sscPercent, double sscCGPA, String sscYear, String gap, int yearsOfGap,
			String workExp, int yearsOfExp, String companyName, String companyLoc, String formId, String resume,
			String photo) {
		super();
		this.cuid = cuid;
		this.bid = bid;
		this.nameBySSC = nameBySSC;
		this.emaiId = emaiId;
		this.phoneNumber = phoneNumber;
		this.whatsappNumber = whatsappNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.currentState = currentState;
		this.currentCity = currentCity;
		this.homeState = homeState;
		this.homeCity = homeCity;
		this.languagesKnown = languagesKnown;
		this.currentCourse = currentCourse;
		this.currentBatch = currentBatch;
		this.currentInstitute = currentInstitute;
		this.postgrad = postgrad;
		this.dreamCompanies = dreamCompanies;
		this.gradCourse = gradCourse;
		this.gradCGPA = gradCGPA;
		this.gradYear = gradYear;
		this.gradPercent = gradPercent;
		this.gradInstitute = gradInstitute;
		this.gradUniversity = gradUniversity;
		this.gradCityState = gradCityState;
		this.hscPercent = hscPercent;
		this.hscCGPA = hscCGPA;
		this.hscYear = hscYear;
		this.sscPercent = sscPercent;
		this.sscCGPA = sscCGPA;
		this.sscYear = sscYear;
		this.gap = gap;
		this.yearsOfGap = yearsOfGap;
		this.workExp = workExp;
		this.yearsOfExp = yearsOfExp;
		this.companyName = companyName;
		this.companyLoc = companyLoc;
		this.formId = formId;
		this.resume = resume;
		this.photo = photo;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCuid() {
		return cuid;
	}

	public void setCuid(int cuid) {
		this.cuid = cuid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getNameBySSC() {
		return nameBySSC;
	}

	public void setNameBySSC(String nameBySSC) {
		this.nameBySSC = nameBySSC;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getHomeState() {
		return homeState;
	}

	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getLanguagesKnown() {
		return languagesKnown;
	}

	public void setLanguagesKnown(String languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

	public String getCurrentCourse() {
		return currentCourse;
	}

	public void setCurrentCourse(String currentCourse) {
		this.currentCourse = currentCourse;
	}

	public String getCurrentBatch() {
		return currentBatch;
	}

	public void setCurrentBatch(String currentBatch) {
		this.currentBatch = currentBatch;
	}

	public String getCurrentInstitute() {
		return currentInstitute;
	}

	public void setCurrentInstitute(String currentInstitute) {
		this.currentInstitute = currentInstitute;
	}

	public String getPostgrad() {
		return postgrad;
	}

	public void setPostgrad(String postgrad) {
		this.postgrad = postgrad;
	}

	public String getDreamCompanies() {
		return dreamCompanies;
	}

	public void setDreamCompanies(String dreamCompanies) {
		this.dreamCompanies = dreamCompanies;
	}

	public String getGradCourse() {
		return gradCourse;
	}

	public void setGradCourse(String gradCourse) {
		this.gradCourse = gradCourse;
	}

	public double getGradCGPA() {
		return gradCGPA;
	}

	public void setGradCGPA(double gradCGPA) {
		this.gradCGPA = gradCGPA;
	}

	public String getGradYear() {
		return gradYear;
	}

	public void setGradYear(String gradYear) {
		this.gradYear = gradYear;
	}

	public double getGradPercent() {
		return gradPercent;
	}

	public void setGradPercent(double gradPercent) {
		this.gradPercent = gradPercent;
	}

	public String getGradInstitute() {
		return gradInstitute;
	}

	public void setGradInstitute(String gradInstitute) {
		this.gradInstitute = gradInstitute;
	}

	public String getGradUniversity() {
		return gradUniversity;
	}

	public void setGradUniversity(String gradUniversity) {
		this.gradUniversity = gradUniversity;
	}

	public String getGradCityState() {
		return gradCityState;
	}

	public void setGradCityState(String gradCityState) {
		this.gradCityState = gradCityState;
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

	public String getGap() {
		return gap;
	}

	public void setGap(String gap) {
		this.gap = gap;
	}

	public int getYearsOfGap() {
		return yearsOfGap;
	}

	public void setYearsOfGap(int yearsOfGap) {
		this.yearsOfGap = yearsOfGap;
	}

	public String getWorkExp() {
		return workExp;
	}

	public void setWorkExp(String workExp) {
		this.workExp = workExp;
	}

	public int getYearsOfExp() {
		return yearsOfExp;
	}

	public void setYearsOfExp(int yearsOfExp) {
		this.yearsOfExp = yearsOfExp;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLoc() {
		return companyLoc;
	}

	public void setCompanyLoc(String companyLoc) {
		this.companyLoc = companyLoc;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
    
	
}