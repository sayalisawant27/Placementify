package model;

public class Batch {
    public int bid;
    public int cid;
    public String batchName;
    public int startYear;
    public int endYear;
    public double noOfStudents;

    public Batch(int bid, int cid, String batchName, int startYear, int endYear, double noOfStudents) {
        super();
        this.bid = bid;
        this.cid = cid;
        this.batchName = batchName;
        this.startYear = startYear;
        this.endYear = endYear;
        this.noOfStudents = noOfStudents;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public double getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(double noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
}