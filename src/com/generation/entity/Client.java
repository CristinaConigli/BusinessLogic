package com.generation.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;



public class Client extends Person
{
    private String status;// Open, Closed won, closed lost
    private int revenue;
    private LocalDate openedOn, closedOn;

    public Client(){}
    
    




    public Client(String status, int revenue, LocalDate openedOn, LocalDate closedOn) {
        this.status = status;
        this.revenue = revenue;
        this.openedOn = openedOn;
        this.closedOn = closedOn;
    }






    public Client(int id, String name, String surname, LocalDate dob, String status, int revenue, LocalDate openedOn,
            LocalDate closedOn) {
        super(id, name, surname, dob);
        this.status = status;
        this.revenue = revenue;
        this.openedOn = openedOn;
        this.closedOn = closedOn;
    }






    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getRevenue() {
        return revenue;
    }
    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
    public LocalDate getOpenedOn() {
        return openedOn;
    }
    public void setOpenedOn(LocalDate openedOn) {
        this.openedOn = openedOn;
    }
    public void setClosedOn(LocalDate closedOn) {
        this.closedOn = closedOn;
    }
    public LocalDate getClosedOn() {
        return closedOn;
    }

    @Override
    public List<String> getErrors() 
    {
        List<String> res= new ArrayList<String>();

        if(status.isBlank())
            res.add("ERRORE: status vuoto");
        if(revenue<0)
            res.add("ERRORE: revenue negativo");
        if(openedOn.isAfter(LocalDate.now()))
            res.add("ERRORE: openedOn nel futuro");
        if(closedOn.isAfter(LocalDate.now()))
            res.add("ERRORE: closedOnn nel futuro");


        return res;
    }
    
    public double getMonthRevenue()
    {
        if(status.equals("Open"))
        {
            Period p=Period.between(openedOn,LocalDate.now());
            int years=p.getYears();
            int months=p.getMonths();

            int totalMonths = years*12+months;
            return revenue/totalMonths;
        }
        if(status.equals("Closed won"))
        {
            Period p=Period.between(openedOn,closedOn);
            int years=p.getYears();
            int months=p.getMonths();

            int totalMonths = years*12+months;
            return revenue/totalMonths;
        }

        return 0.0;
    }
    @Override
    public String toString() {
        return "Client [status=" + status + ", revenue=" + revenue + ", openedOn=" + openedOn + ", closedOn=" + closedOn
                + "]";
    }

    
}
