package com.generation.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person
{
    private String job, education;
    private int ral, months;//(12/13)
    private LocalDate hiredOn;

    public Employee(){}

    




    public Employee(String job, String education, int ral, int months, LocalDate hiredOn) {
        this.job = job;
        this.education = education;
        this.ral = ral;
        this.months = months;
        this.hiredOn = hiredOn;
    }






    public Employee(int id, String name, String surname, LocalDate dob, String job, String education, int ral,
            int months, LocalDate hiredOn) {
        super(id, name, surname, dob);
        this.job = job;
        this.education = education;
        this.ral = ral;
        this.months = months;
        this.hiredOn = hiredOn;
    }






    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public int getRal() {
        return ral;
    }
    public void setRal(int ral) {
        this.ral = ral;
    }
    public int getMonths() {
        return months;
    }
    public void setMonths(int months) {
        this.months = months;
    }
    public LocalDate getHiredOn() {
        return hiredOn;
    }
    public void setHiredOn(LocalDate hiredOn) {
        this.hiredOn = hiredOn;
    }

    public double getMonthSalary()
    {
        return ral/months;
    }

    @Override
    public List<String> getErrors() 
    {
        List<String> res= new ArrayList<String>();

        if(job.isBlank())
            res.add("ERRORE: job vuoto");
        if(education.isBlank())
            res.add("ERRORE: education vuoto");
        if(ral<0)
            res.add("ERRORE: ral negativo");
        if(months<0)
            res.add("ERRORE: months negativi");
        if(hiredOn.isAfter(LocalDate.now()))
            res.add("ERRORE: hired on nel futuro");


        return res;
    }
    @Override
    public String toString() {
        return "Employee [job=" + job + ", education=" + education + ", ral=" + ral + ", months=" + months
                + ", hiredOn=" + hiredOn + "]";
    }

    
}
