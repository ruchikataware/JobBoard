package Entity;
import java.util.Date;
import java.util.List;


public class JobListing {
    private int jobID;
    private int companyID;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private double salary;
    private String jobType;
    private Date postedDate;

    // Getters
    public int getJobID() {
        return jobID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobType() {
        return jobType;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    // Setters
    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public void apply(int applicantID, String coverLetter) {
        // Implementation to allow applicants to apply for the job
    }

    public List<Applicant> getApplicants() {
        // Implementation to retrieve applicants who applied for the job
        return null; // This would typically return the applicants for this job
    }
}
