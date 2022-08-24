package com.nicolas.project_postgres.repositories;

import com.nicolas.project_postgres.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(
            value = "SELECT * FROM accounts ORDER BY id ASC",
            nativeQuery = true
    )
    List<Account> getAccountsOrdered();

}
