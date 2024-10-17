package DAO;

import Entity.Applicant;
import JDBC.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicantDAOImpl implements ApplicantDAO {

    @Override
    public void insertApplicant(Applicant applicant) {
        String query = "INSERT INTO Applicants (FirstName, LastName, Email, Phone, Resume) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, applicant.getFirstName());
            pstmt.setString(2, applicant.getLastName());
            pstmt.setString(3, applicant.getEmail());
            pstmt.setString(4, applicant.getPhone());
            pstmt.setString(5, applicant.getResume());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Applicant> getAllApplicants() {
        List<Applicant> applicants = new ArrayList<>();
        String query = "SELECT * FROM Applicants";
        try (Connection conn = JDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Applicant applicant = new Applicant();
                applicant.setApplicantID(rs.getInt("ApplicantID"));
                applicant.setFirstName(rs.getString("FirstName"));
                applicant.setLastName(rs.getString("LastName"));
                applicant.setEmail(rs.getString("Email"));
                applicant.setPhone(rs.getString("Phone"));
                applicant.setResume(rs.getString("Resume"));
                applicants.add(applicant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applicants;
    }
}

