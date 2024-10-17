package Database;

import DAO.ApplicantDAO;
import DAO.ApplicantDAOImpl;
import DAO.CompanyDAO;
import DAO.CompanyDAOImpl;
import DAO.JobApplicationDAO;
import DAO.JobApplicationDAOImpl;
import DAO.JobListingDAO;
import DAO.JobListingDAOImpl;
import Entity.Applicant;
import Entity.Company;
import Entity.JobApplication;
import Entity.JobListing;

import java.util.List;

public class DatabaseManager {
    private ApplicantDAO applicantDAO = new ApplicantDAOImpl();
    private CompanyDAO companyDAO = new CompanyDAOImpl();
    private JobListingDAO jobListingDAO = new JobListingDAOImpl();
    private JobApplicationDAO jobApplicationDAO = new JobApplicationDAOImpl();

    // Insert a new applicant
    public void insertApplicant(Applicant applicant) {
        applicantDAO.insertApplicant(applicant);
    }

    // Retrieve all applicants
    public List<Applicant> getAllApplicants() {
        return applicantDAO.getAllApplicants();
    }

    // Insert a new job listing
    public void insertJobListing(JobListing jobListing) {
        jobListingDAO.insertJobListing(jobListing);
    }

    // Retrieve all job listings
    public List<JobListing> getAllJobListings() {
        return jobListingDAO.getAllJobListings();
    }

    // Insert a new job application
    public void insertJobApplication(JobApplication jobApplication) {
        jobApplicationDAO.insertJobApplication(jobApplication);
    }

    // Retrieve all job applications
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationDAO.getAllJobApplications();
    }

    // Insert a new company
    public void insertCompany(Company company) {
        companyDAO.insertCompany(company);
    }

    // Retrieve all companies
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    // Retrieve applications for a specific job
    public List<JobApplication> getApplicationsForJob(int jobID) {
        return jobApplicationDAO.getAllJobApplications().stream()
                .filter(application -> application.getJobID() == jobID)
                .toList(); // Filter applications by jobID
    }
}
