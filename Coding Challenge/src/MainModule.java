import Database.DatabaseManager;
import Entity.Applicant;
import Entity.Company;
import Entity.JobApplication;
import Entity.JobListing;
import java.util.Scanner;
import java.util.List;
/*
public class MainModule {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();

        // Insert a new company
        Company company = new Company();
        company.setCompanyID(2);
        company.setCompanyName("Tech Innovations");
        company.setLocation("San Francisco, CA");
        dbManager.insertCompany(company);
        System.out.println("Inserted Company: " + company.getCompanyName());

        // Insert a new job listing
        JobListing jobListing = new JobListing();
        jobListing.setJobID(1);
        jobListing.setCompanyID(company.getCompanyID());
        jobListing.setJobTitle("Software Developer");
        jobListing.setJobDescription("Develop software applications.");
        jobListing.setJobLocation("Work from Office");
        jobListing.setSalary(120000.00);
        jobListing.setJobType("Full-time");
        jobListing.setPostedDate(new java.util.Date());
        dbManager.insertJobListing(jobListing);
        System.out.println("Inserted Job Listing: " + jobListing.getJobTitle());

        // Insert a new applicant
        Applicant applicant = new Applicant();
        applicant.setApplicantID(2);
        applicant.setFirstName("John");
        applicant.setLastName("Grande");
        applicant.setEmail("john.grande@example.com");
        applicant.setPhone("123-456-7890");
        applicant.setResume("Resume content here...");
        dbManager.insertApplicant(applicant);
        System.out.println("Inserted Applicant: " + applicant.getFirstName() + " " + applicant.getLastName());

        // Apply for a job
        JobApplication jobApplication = new JobApplication();
        jobApplication.setApplicationID(1);
        jobApplication.setJobID(jobListing.getJobID());
        jobApplication.setApplicantID(applicant.getApplicantID());
        jobApplication.setApplicationDate(new java.util.Date());
        jobApplication.setCoverLetter("I am excited to apply for this position.");
        dbManager.insertJobApplication(jobApplication);
        System.out.println("Inserted Job Application for: " + applicant.getFirstName());


 */
public class MainModule{
    private static DatabaseManager dbManager = new DatabaseManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while(!exit){
            System.out.println("--------- Functionalities ---------");
            System.out.println("1. Add applicant");
            System.out.println("2. Add Company");
            System.out.println("3. Add Job Listing");
            System.out.println("4. Apply for Job");
            System.out.println("5. List all applicants");
            System.out.println("6. List all companies");
            System.out.println("7. List all job listings");
            System.out.println("8. List all job applications");
            System.out.println("9. exit");

            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    addApplicant();
                    break;
                case 2:
                    addCompany();
                    break;
                case 3:
                    addJobListing();
                    break;
                case 4:
                    applyForJob();
                    break;
                case 5:
                    listApplicants();
                    break;
                case 6:
                    listCompanies();
                    break;
                case 7:
                    listJobListings();
                    break;
                case 8:
                    listJobApplications();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
    private static void addApplicant() {
        Applicant applicant = new Applicant();
        System.out.println("Enter First Name: ");
        applicant.setFirstName(scanner.nextLine());
        System.out.println("Enter Last Name: ");
        applicant.setLastName(scanner.nextLine());
        System.out.println("Enter Email: ");
        applicant.setEmail(scanner.nextLine());
        System.out.println("Enter Phone: ");
        applicant.setPhone(scanner.nextLine());
        System.out.println("Enter Resume: ");
        applicant.setResume(scanner.nextLine());

        dbManager.insertApplicant(applicant);
        System.out.println("Applicant added successfully.");
    }

    private static void addCompany() {
        Company company = new Company();
        System.out.println("Enter Company Name: ");
        company.setCompanyName(scanner.nextLine());
        System.out.println("Enter Location: ");
        company.setLocation(scanner.nextLine());

        dbManager.insertCompany(company);
        System.out.println("Company added successfully.");
    }

    private static void addJobListing() {
        JobListing jobListing = new JobListing();
        System.out.println("Enter Company ID: ");
        jobListing.setCompanyID(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Job Title: ");
        jobListing.setJobTitle(scanner.nextLine());
        System.out.println("Enter Job Description: ");
        jobListing.setJobDescription(scanner.nextLine());
        System.out.println("Enter Job Location: ");
        jobListing.setJobLocation(scanner.nextLine());
        System.out.println("Enter Salary: ");
        jobListing.setSalary(scanner.nextDouble());
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Job Type: ");
        jobListing.setJobType(scanner.nextLine());

        dbManager.insertJobListing(jobListing);
        System.out.println("Job Listing added successfully.");
    }

    private static void applyForJob() {
        JobApplication jobApplication = new JobApplication();
        System.out.println("Enter Job ID: ");
        jobApplication.setJobID(scanner.nextInt());
        System.out.println("Enter Applicant ID: ");
        jobApplication.setApplicantID(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Cover Letter: ");
        jobApplication.setCoverLetter(scanner.nextLine());
        jobApplication.setApplicationDate(new java.util.Date());

        dbManager.insertJobApplication(jobApplication);
        System.out.println("Application submitted successfully.");
    }

    private static void listApplicants() {
        List<Applicant> applicants = dbManager.getAllApplicants();
        System.out.println("List of Applicants:");
        for (Applicant applicant : applicants) {
            System.out.println(applicant.getFirstName() + " " + applicant.getLastName());
        }
    }

    private static void listCompanies() {
        List<Company> companies = dbManager.getAllCompanies();
        System.out.println("List of Companies:");
        for (Company company : companies) {
            System.out.println(company.getCompanyName() + " - " + company.getLocation());
        }
    }

    private static void listJobListings() {
        List<JobListing> jobListings = dbManager.getAllJobListings();
        System.out.println("List of Job Listings:");
        for (JobListing jobListing : jobListings) {
            System.out.println(jobListing.getJobTitle() + " - " + jobListing.getJobLocation());
        }
    }

    private static void listJobApplications() {
        List<JobApplication> jobApplications = dbManager.getAllJobApplications();
        System.out.println("List of Job Applications:");
        for (JobApplication jobApplication : jobApplications) {
            System.out.println("Application ID: " + jobApplication.getApplicationID() +
                    ", Job ID: " + jobApplication.getJobID() +
                    ", Applicant ID: " + jobApplication.getApplicantID());
        }
    }
}
