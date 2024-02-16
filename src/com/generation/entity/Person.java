package com.generation.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person extends Entity
{
    private String name, surname;
    private LocalDate dob;

    public Person(){}
    
    
    


    public Person(int id, String name, String surname, LocalDate dob) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.dob = dob;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }
    

    
    public int getAge(LocalDate d)
    {
        return LocalDate.now().getYear()-d.getYear();
    }
    
   


    @Override
    public List<String> getErrors() 
    {
        List<String> res = new ArrayList<String>();

        if(id<0)
            res.add("ERRORE: id negativo");

        if(name==null || name.isBlank())
            res.add("ERRORE: Nome nullo o vuoto");

        if(surname==null || surname.isBlank())
            res.add("ERRORE: Cognome nullo o vuoto");

        if(dob.getYear()<1800 || dob.getYear()>2025)
            res.add("ERRORE: anno di nascita irrealistico");

        return res;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
