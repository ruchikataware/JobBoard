package Entity;
import java.util.Date;

public class JobApplication {
    private int applicationID;
    private int jobID;
    private int applicantID;
    private Date applicationDate;
    private String coverLetter;

    // Getters
    public int getApplicationID() {
        return applicationID;
    }

    public int getJobID() {
        return jobID;
    }

    public int getApplicantID() {
        return applicantID;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    // Setters
    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public void setApplicantID(int applicantID) {
        this.applicantID = applicantID;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

}
