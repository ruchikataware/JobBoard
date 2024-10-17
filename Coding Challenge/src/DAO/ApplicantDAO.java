package DAO;

import Entity.Applicant;
import java.util.List;

public interface ApplicantDAO {
    void insertApplicant(Applicant applicant);
    List<Applicant> getAllApplicants();
}
