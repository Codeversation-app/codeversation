package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
