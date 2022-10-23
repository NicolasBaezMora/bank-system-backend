package com.nicolas.project_postgres.config;

import com.nicolas.project_postgres.converters.AccountConverter;
import com.nicolas.project_postgres.converters.BankConverter;
import com.nicolas.project_postgres.converters.CoinConverter;
import com.nicolas.project_postgres.converters.PersonConverter;
import com.nicolas.project_postgres.validators.AccountValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyConfiguration {

    @Bean
    public AccountConverter dependencyAccountConverter() { return new AccountConverter(); }

    @Bean
    public BankConverter dependencyBankConverter() { return new BankConverter(); }

    @Bean
    public CoinConverter dependencyCoinConverter() { return new CoinConverter(); }

    @Bean
    public PersonConverter dependencyPersonConverter() { return new PersonConverter(); }

    @Bean
    public AccountValidator accountValidator() { return new AccountValidator(); }
}
