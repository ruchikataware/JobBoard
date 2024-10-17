package DAO;

import Entity.JobListing;
import JDBC.JDBCConnection; // Ensure the import is correct

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobListingDAOImpl implements JobListingDAO {

    @Override
    public void insertJobListing(JobListing jobListing) {
        String query = "INSERT INTO JobListings (CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, jobListing.getCompanyID());
            pstmt.setString(2, jobListing.getJobTitle());
            pstmt.setString(3, jobListing.getJobDescription());
            pstmt.setString(4, jobListing.getJobLocation());
            pstmt.setDouble(5, jobListing.getSalary());
            pstmt.setString(6, jobListing.getJobType());
            pstmt.setTimestamp(7, new Timestamp(jobListing.getPostedDate().getTime())); // Convert Date to Timestamp
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<JobListing> getAllJobListings() {
        List<JobListing> jobListings = new ArrayList<>();
        String query = "SELECT * FROM JobListings";
        try (Connection conn = JDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                JobListing jobListing = new JobListing();
                jobListing.setJobID(rs.getInt("JobID"));
                jobListing.setCompanyID(rs.getInt("CompanyID"));
                jobListing.setJobTitle(rs.getString("JobTitle"));
                jobListing.setJobDescription(rs.getString("JobDescription"));
                jobListing.setJobLocation(rs.getString("JobLocation"));
                jobListing.setSalary(rs.getDouble("Salary"));
                jobListing.setJobType(rs.getString("JobType"));
                jobListing.setPostedDate(rs.getTimestamp("PostedDate")); // Use setTimestamp to retrieve the Date
                jobListings.add(jobListing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobListings;
    }
}
