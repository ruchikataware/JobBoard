package DAO;

import Entity.JobApplication;
import java.util.List;

public interface JobApplicationDAO {
    void insertJobApplication(JobApplication jobApplication);
    List<JobApplication> getAllJobApplications();
}

