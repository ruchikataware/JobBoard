package DAO;

import Entity.Company;
import JDBC.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {

    @Override
    public void insertCompany(Company company) {
        String query = "INSERT INTO Companies (CompanyName, Location) VALUES (?, ?)";
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, company.getCompanyName());
            pstmt.setString(2, company.getLocation());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        String query = "SELECT * FROM Companies";
        try (Connection conn = JDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Company company = new Company();
                company.setCompanyID(rs.getInt("CompanyID"));
                company.setCompanyName(rs.getString("CompanyName"));
                company.setLocation(rs.getString("Location"));
                companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }
}

