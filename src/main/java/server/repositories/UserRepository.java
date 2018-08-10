package server.repositories;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @NotFound(action = NotFoundAction.IGNORE)
    List<User> findByUsername (String username);
}