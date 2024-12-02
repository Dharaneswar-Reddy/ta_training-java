package com.epam.training.virupakshi_dharaneswar_reddy;

public class User {
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String educationLevel;
    private String sex;
    private String yearsOfExperience;
    private String date;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.jobTitle = builder.jobTitle;
        this.educationLevel = builder.educationLevel;
        this.sex = builder.sex;
        this.yearsOfExperience = builder.yearsOfExperience;
        this.date = builder.date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public String getSexType() {
        return sex;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getDate() {
        return date;
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private String jobTitle;
        private String educationLevel;
        private String sex;
        private String yearsOfExperience;
        private String date;

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public UserBuilder setEducationLevel(String educationLevel) {
            this.educationLevel = educationLevel;
            return this;
        }

        public UserBuilder setSexType(String sex) {
            this.sex = sex;
            return this;
        }

        public UserBuilder setYearsOfExperience(String yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }

        public UserBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
