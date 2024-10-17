package DAO;

import Entity.JobApplication;
import JDBC.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobApplicationDAOImpl implements JobApplicationDAO {

    @Override
    public void insertJobApplication(JobApplication jobApplication) {
        String query = "INSERT INTO JobApplications (JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, jobApplication.getJobID());
            pstmt.setInt(2, jobApplication.getApplicantID());
            pstmt.setTimestamp(3, new Timestamp(jobApplication.getApplicationDate().getTime()));
            pstmt.setString(4, jobApplication.getCoverLetter());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<JobApplication> getAllJobApplications() {
        List<JobApplication> jobApplications = new ArrayList<>();
        String query = "SELECT * FROM JobApplications";
        try (Connection conn = JDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                JobApplication jobApplication = new JobApplication();
                jobApplication.setApplicationID(rs.getInt("ApplicationID"));
                jobApplication.setJobID(rs.getInt("JobID"));
                jobApplication.setApplicantID(rs.getInt("ApplicantID"));
                jobApplication.setApplicationDate(rs.getTimestamp("ApplicationDate"));
                jobApplication.setCoverLetter(rs.getString("CoverLetter"));
                jobApplications.add(jobApplication);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobApplications;
    }
}
