package DAO;

import Entity.Company;
import java.util.List;

public interface CompanyDAO {
    void insertCompany(Company company);
    List<Company> getAllCompanies();
}

