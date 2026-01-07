package com.rugved.licenseapp;

public class RTO {
  public void initiate() {
    Applicant applicant = new Applicant();
    try {
      applicant.takeInput();
      applicant.verifyAge();
    } catch (UnderAgeException | OverAgeException e1) {
      try {
        applicant.takeInput();
        applicant.verifyAge();
      } catch (UnderAgeException | OverAgeException e2) {
        System.out.println("You are Locked To Apply For License, Due To Age Related Restrictions !");
        // e2.printStackTrace();
      }
    }
  }
};