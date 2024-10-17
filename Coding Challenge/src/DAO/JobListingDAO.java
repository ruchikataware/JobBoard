package DAO;

import Entity.JobListing;
import java.util.List;

public interface JobListingDAO {
    void insertJobListing(JobListing jobListing);
    List<JobListing> getAllJobListings();
}

