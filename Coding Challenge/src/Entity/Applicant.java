package Entity;

public class Applicant {
    private int applicantID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String resume;

    // Getters
    public int getApplicantID() {
        return applicantID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getResume() {
        return resume;
    }

    // Setters
    public void setApplicantID(int applicantID) {
        this.applicantID = applicantID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void createProfile(String email, String firstName, String lastName, String phone) {
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
    }

    public void applyForJob(int jobID, String coverLetter) {

    }
}
