package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Student {

    private static final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private int studentId;
    private String name;
    private LocalDate dateOfAdmission;

    public Student(String name) {
        setName(name);
    }

    public Student(int studentId, String name) {
        this(name);
        setStudentId(studentId);
    }

    public Student(int studentId, String name, LocalDate dateOfAdmission) {
        this(studentId, name);
        setDateOfAdmission(dateOfAdmission);
    }

    @Override
    public String toString() {
        return String.format("studentId: %d | name: %s | dateOfAdmission: %s", this.studentId, this.name,
                dtFormatter.format(this.dateOfAdmission));
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAdmission() {
        return this.dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public boolean isPlatinumAlumni() {
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(this.dateOfAdmission);
//        int year = calendar.get(Calendar.YEAR);
//        return LocalDate.now().getYear() - year >= 30;
        //return ChronoUnit.YEARS.between(LocalDate.now() - dateOfAdmission) >= 30;
        return java.time.temporal.ChronoUnit.YEARS.between( dateOfAdmission , LocalDate.now()) >= 30;
    }
}
