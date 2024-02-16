package com.generation.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.generation.entity.Client;
import com.generation.entity.Employee;
import com.generation.entity.Entity;
import com.generation.entity.PC;
import com.generation.entity.Person;
import com.generation.interfaces.BusinessLogic;

public class BusinessLogicRepositoryMock implements BusinessLogic
{
    List<Employee> employeeList = new ArrayList<>();
    List<Client> clientList = new ArrayList<Client>();
    List<PC> pcList = new ArrayList<PC>();
    List<Entity> entityList=new ArrayList<Entity>();
    List<Person> personList=new ArrayList<Person>();

    public BusinessLogicRepositoryMock()
    {
        
        employeeList.add(new Employee(1, "John", "Doe", LocalDate.now().minusYears(30), "Software Developer", "Bachelor's", 5000, 12, LocalDate.now().minusYears(1)));
        employeeList.add(new Employee(2, "Jane", "Smith", LocalDate.now().minusYears(35), "Project Manager", "Master's", 7000, 24, LocalDate.now().minusYears(2)));
        // ArrayList for Client objects

        clientList.add(new Client(1, "Acme Corp", "Inc", LocalDate.now().minusYears(10), "Open", 15000, LocalDate.now().minusMonths(5), LocalDate.now()));
        clientList.add(new Client(2, "Beta LLC", "GmbH", LocalDate.now().minusYears(15), "Closed won", 25000, LocalDate.now().minusYears(1), LocalDate.now().minusMonths(2)));

        // ArrayList for PC objects

        pcList.add(new PC(1, "Intel i7", "SSD", "Model X", 512, 16, 1200, 24, true, LocalDate.now().minusYears(1)));
        pcList.add(new PC(2, "AMD Ryzen 5", "HDD", "Model Y", 1024, 32, 1000, 12, false, LocalDate.now().minusYears(2)));

        entityList.addAll(employeeList);
        entityList.addAll(clientList);
        entityList.addAll(pcList);

        personList.addAll(clientList);
        personList.addAll(employeeList);
    }
    
    @Override
    public List<Entity> getAllValids() 
    {       
        List<Entity> valids = new ArrayList<>();

        for (Entity e : entityList) 
        {
            if(e.isValid())
                valids.add(e);
        }
        return valids;
    }

    @Override
    public List<Entity> getAllInvalids() 
    {
        List<Entity> res = new ArrayList<>();

        for (Entity e : entityList) 
        {
            if(!e.isValid())
                res.add(e);
        }
        return res;
    }

    @Override
    public List<Person> getPeopleOlderThan(int minAge) 
    {
        List<Person> res=new ArrayList<>();
        for (Person p : personList) 
        {
            if(p.getAge(p.getDob())>minAge)
                res.add(p);
        }
        return res;
    }

    @Override
    public List<Person> getPeopleWithNameLongerThan(int minLenght) 
    {
        List<Person> lista=     personList
                                .stream()
                                .filter(p->p.getName().length()>minLenght)
                                .collect(Collectors.toList());
        return lista;
    }

    @Override
    public Person getPersonByNameAndSurname(String name, String surname) 
    {
        Person res=     personList
                        .stream()
                        .filter(p->p.getName()==name && p.getSurname()==surname)
                        .findFirst()
                        .get();
            return res;
    }

    @Override
    public Map<Integer, List<Person>> getPersonDividedByYearOfBirth() 
    {
        Map<Integer, List<Person>> mappa = new HashMap<>();
        Set<Integer> anni = personList.stream().map(p->p.getDob().getYear()).collect(Collectors.toSet());
        
        for (Integer integer : anni) 
        {
            mappa.put(integer, personList.stream().filter(p->p.getDob().getYear()==integer).toList());
            
        }
        
        return mappa;

        // return personList.stream()
        //              .collect(Collectors.groupingBy(p -> p.getDob().getYear()));
    }

    @Override
    public List<PC> getPcsInUse() 
    {
        List<PC> pc = pcList.stream().filter(p->p.isInUse()).collect(Collectors.toList());
        return pc;
    }

    @Override
    public List<PC> getGreatValuePcs() //Pc che costano meno di 500 euro e hanno 16 o più gb di ram
    {
        return pcList.stream().filter(p->p.getPrice()<500 && p.getMmasize()>=16).collect(Collectors.toList());
    }

    @Override
    public List<PC> getPcWithExpiredWarranty() 
    {
        return  pcList.stream()
                .filter(p->p.getDateOfPurchase().plusMonths(p.getWarranty()).isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> getLastYearClients() 
    {
        return clientList.stream().filter(c->c.getClosedOn().getYear()==LocalDate.now().getYear()).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Client>> getClientsByStatus() //chiave Status, valore lista di Clienti con quello status
    {
        return clientList.stream().collect(Collectors.groupingBy(p -> p.getStatus()));
    }

    @Override
    public Map<String, Integer> getRevenueByStatus() //chiave Status,valore revenue totale dei clienti con quello status
    {
            
                return clientList.stream()
                  .collect(Collectors.toMap(Client::getStatus, Client::getRevenue, Integer::sum));

// Qui, stiamo utilizzando il metodo collect() per raccogliere gli elementi dello stream in una mappa. 
//Collectors.toMap() accetta tre argomenti:

// Client::getStatus: Questo è un riferimento al metodo getStatus() della classe Client, che viene utilizzato come chiave nella mappa risultante.
// Client::getRevenue: Questo è un riferimento al metodo getRevenue() della classe Client, che fornisce il valore associato alla chiave nella mappa risultante.
// Integer::sum: Questo indica che in caso di collisione delle chiavi (cioè se due clienti hanno lo stesso status), i valori associati verranno sommati. Integer::sum è un riferimento al metodo sum della classe Integer, che somma due interi.

              
    }

    @Override
    public Map<String, Integer> getAverageSalaryByRole() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAverageSalaryByRole'");
    }

    @Override
    public Map<String, Integer> getDeltaByEducation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeltaByEducation'");
    }

}
