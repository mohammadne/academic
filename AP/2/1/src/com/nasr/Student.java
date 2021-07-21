package com.nasr;


public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private int grade;

    /*
     * @param fName first Name of Student
     * @param lName last Name of Student
     * @param sID ID of Student
     */
    public Student(String fName, String lName, String sID) {
        this.firstName = fName;
        this.lastName = lName;
        this.id = sID;
        grade = 0;
    }

    /*
     * get student first name
     *@return firstName field
     */
    public String getFirstName() {
        return this.firstName;
    }

    /*
     *@param firstName field
     */
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    /*
     * get student last name
     *@return lastName field
     */
    public String getLastName() {
        return lastName;
    }

    /*
     *@param lastName field
     */
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    /*
     * get student id
     *@return id field
     */
    public String getId() {
        return id;
    }

    /*
     *@param id field
     */
    public void setId(String sID) {
        this.id = sID;
    }

    /*
     * get student grade
     *@return grade field
     */
    public int getGrade() {
        return grade;
    }

    /*
     *@param grade field
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("First Name" + this.firstName + '\n');
        stb.append("Last Name" + this.lastName + '\n');
        stb.append("ID" + this.id + '\n');
        stb.append("Grade" + this.grade + '\n');
        return stb.toString();
    }
}
