package Entity;

import java.util.List;

public class Company {
    private int companyID;
    private String companyName;
    private String location;

    // Getters
    public int getCompanyID() {
        return companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    // Setters
    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<JobListing> getJobs() {
        // Implementation to retrieve job listings
        return null; // This would typically return the jobs posted by this company
    }
}
