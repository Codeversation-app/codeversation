package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}