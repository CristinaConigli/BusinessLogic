package com.generation.interfaces;

import java.util.List;
import java.util.Map;

import com.generation.entity.Client;
import com.generation.entity.Entity;
import com.generation.entity.PC;
import com.generation.entity.Person;

public interface BusinessLogic 
{

    List<Entity> getAllValids();
    List<Entity> getAllInvalids();
    List<Person> getPeopleOlderThan(int minAge);
    List<Person> getPeopleWithNameLongerThan(int minLenght);
    Person getPersonByNameAndSurname(String name,String surname);
    Map<Integer,List<Person>> getPersonDividedByYearOfBirth(); //deve avere come chiave l'anno di nascita e come valore le persone nate in quell'anno
    List<PC> getPcsInUse();
    List<PC> getGreatValuePcs();//Pc che costano meno di 500 euro e hanno 16 o più gb di ram
    List<PC> getPcWithExpiredWarranty();
    List<Client> getLastYearClients();//solo clienti degli ultimi 12 mesi
    Map<String,List<Client>> getClientsByStatus(); //chiave Status, valore lista di Clienti con quello status
    Map<String,Integer> getRevenueByStatus();//chiave Status,valore revenue totale dei clienti con quello status
    Map<String,Integer> getAverageSalaryByRole();//chiave role, valore stipendio medio degli impiegati con quel ruolo
    


    //DIFFICILE, da data analyst
    Map<String,Integer> getDeltaByEducation(); 
    //voglio come chiavi tutti i livelli di studio, e voglio come valore la differenza tra lo stipendio medio
    //di chi ha quel livello rispetto a chi non lo ha




}
