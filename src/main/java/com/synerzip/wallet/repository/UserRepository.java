package com.synerzip.wallet.repository;

import com.synerzip.wallet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findById(int id);

    public User findByEmail(String email);
}
