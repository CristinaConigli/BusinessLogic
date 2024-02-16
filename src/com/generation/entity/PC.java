package com.generation.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PC extends Entity
{
    private String processor, mmatype, model;
    private int mmasize, ram, price, warranty;
    private boolean inUse;
    private LocalDate dateOfPurchase;

    public PC(){}

    


    public PC(int id, String processor, String mmatype, String model, int mmasize, int ram, int price,
            int warranty, boolean inUse, LocalDate dateOfPurchase) {
        super(id);
        this.processor = processor;
        this.mmatype = mmatype;
        this.model = model;
        this.mmasize = mmasize;
        this.ram = ram;
        this.price = price;
        this.warranty = warranty;
        this.inUse = inUse;
        this.dateOfPurchase = dateOfPurchase;
    }





    public String getProcessor() {
        return processor;
    }
    public void setProcessor(String processor) {
        this.processor = processor;
    }
    public String getMmatype() {
        return mmatype;
    }
    public void setMmatype(String mmatype) {
        this.mmatype = mmatype;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getMmasize() {
        return mmasize;
    }
    public void setMmasize(int mmasize) {
        this.mmasize = mmasize;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getWarranty() {
        return warranty;
    }
    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }
    public boolean isInUse() {
        return inUse;
    }
    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }
    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
    @Override
    public List<String> getErrors() 
    {
        List<String> res = new ArrayList<String>();

        if(mmasize<0)
            res.add("ERRORE: mmasize negativo");
        if(ram<0)
            res.add("ERRORE: ram negativo");
        if(price<0)
            res.add("ERRORE: price negativo");
        if(warranty<0)
            res.add("ERRORE: warranty negativo");
        if(dateOfPurchase.isAfter(LocalDate.now()))
            res.add("ERRORE: dateOfPurchase nel futuro");
        if(processor.isBlank())
            res.add("ERRORE: processore non inserito");
        if(mmatype.isBlank())
            res.add("ERRORE: mmatype non inserita"); 
        if(model.isBlank())
            res.add("ERRORE: model non inserito");     

        return res;
    }
}