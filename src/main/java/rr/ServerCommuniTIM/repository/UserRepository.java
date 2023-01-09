package rr.ServerCommuniTIM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rr.ServerCommuniTIM.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findById(Integer id);
    Optional<User> findByUsernameAndPasswordAndEmail(String username, String password,String email);
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);
}