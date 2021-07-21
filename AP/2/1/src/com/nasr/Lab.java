package com.nasr;

/*
 * @author Mohammad Nasr
 */
public class Lab {
    //fields
    private Student[] students;
    private int avg;
    private String day;
    private int capacity;
    private int currentSize;

    //constructors
    public Lab(int cap, String d) {
    }

    //getters & setters
    public Student[] getStudents() {
        return this.students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getAvg() {
        return this.avg;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //methods
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("lAB IS Full !!");
        }
    }

    public void print() {
        calculateAvg();
        for (Student student : students) {
            System.out.println(student.toString());
            System.out.println(avg);
        }
    }

    public void calculateAvg() {
        int sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        avg = sum / currentSize;
    }

}
