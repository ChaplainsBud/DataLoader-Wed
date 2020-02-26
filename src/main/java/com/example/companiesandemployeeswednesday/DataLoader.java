package com.example.companiesandemployeeswednesday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CompanyRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Company company;
        company = new Company("FDA_");
        repository.save(company);

        company = new Company("NIST");
        repository.save(company);

        company = new Company("NIH_");
        repository.save(company);
    }
}
