package at.refugeescode.mp12_fakebook.persistent;

import at.refugeescode.mp12_fakebook.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}
