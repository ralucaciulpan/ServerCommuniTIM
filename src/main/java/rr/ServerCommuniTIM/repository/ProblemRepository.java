package rr.ServerCommuniTIM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rr.ServerCommuniTIM.model.Problem;
import rr.ServerCommuniTIM.model.User;

import java.util.Optional;

@Repository
public interface ProblemRepository extends JpaRepository<Problem,Integer> {
    Optional<Problem> findById(Integer id);
}
