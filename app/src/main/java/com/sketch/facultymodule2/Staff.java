package com.sketch.facultymodule2;

public class Staff {
    private String staffname;
    private String email;
    private String profilepicture;

    public Staff(){

    }

    public Staff(String staffname, String email, String profilepicture) {
        this.staffname = staffname;
        this.email = email;
        this.profilepicture = profilepicture;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }
}
