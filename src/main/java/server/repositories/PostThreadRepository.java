package server.repositories;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.PostThread;

import java.util.List;

@Repository
public interface PostThreadRepository extends JpaRepository<PostThread, Long> {
    List<PostThread> findByCategory(String category);
}
