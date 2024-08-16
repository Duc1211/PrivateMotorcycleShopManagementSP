package model;

import javax.swing.*;

public class NameModel {
    private String employeeName;
    private Icon profile;
    private String path;


    public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }



        public Icon getProfile() {
            return profile;
        }

        public void setProfile(Icon profile) {
            this.profile = profile;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public NameModel(String employeeName, Icon profile, String path) {
            this.employeeName = employeeName;
            this.profile = profile;
            this.path = path;
        }

    public NameModel(String employeeName) {
        this.employeeName = employeeName;
    }

    public NameModel() {
        }

        @Override
        public String toString() {
            return employeeName;
        }

}
