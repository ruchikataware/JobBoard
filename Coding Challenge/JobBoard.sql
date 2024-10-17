create database JobBoard;
use JobBoard;

CREATE TABLE Companies (
    CompanyID INT AUTO_INCREMENT PRIMARY KEY,
    CompanyName VARCHAR(255) NOT NULL,
    Location VARCHAR(255) NOT NULL
);

CREATE TABLE Applicants (
    ApplicantID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL UNIQUE,
    Phone VARCHAR(20) NOT NULL,
    Resume VARCHAR(255)
);

CREATE TABLE JobListings (
    JobID INT AUTO_INCREMENT PRIMARY KEY,
    CompanyID INT,
    JobTitle VARCHAR(255) NOT NULL,
    JobDescription TEXT NOT NULL,
    JobLocation VARCHAR(255) NOT NULL,
    Salary DECIMAL(10, 2) NOT NULL,
    JobType VARCHAR(50) NOT NULL,
    PostedDate DATETIME NOT NULL,
    FOREIGN KEY (CompanyID) REFERENCES Companies (CompanyID));
    
CREATE TABLE JobApplications (
    ApplicationID INT AUTO_INCREMENT PRIMARY KEY,
    JobID INT,
    ApplicantID INT,
    ApplicationDate DATETIME NOT NULL,
    CoverLetter TEXT,
    FOREIGN KEY (JobID) REFERENCES JobListings(JobID),
    FOREIGN KEY (ApplicantID) REFERENCES Applicants(ApplicantID)
);

INSERT INTO Companies (CompanyName, Location) VALUES
('TechCorp', 'New York');

INSERT INTO Applicants (FirstName, LastName, Email, Phone, Resume) VALUES
('John', 'Doe', 'john.doe@example.com', '123-456-7890', 'resume1.pdf');

INSERT INTO JobListings (CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) VALUES
(1, 'Software Developer', 'Develop and maintain software applications.', 'New York', 85000.00, 'Full-time', NOW());

INSERT INTO JobApplications (JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES
(1, 1, NOW(), 'I am excited to apply for the Software Developer position at TechCorp. My skills in Java and problem-solving would be a great fit.');

desc Companies;
desc Applicants;
desc JobListings;
desc JobApplications;

select * from Companies;
select * from Applicants;
select * from JobListings;
select * from JobApplications;
