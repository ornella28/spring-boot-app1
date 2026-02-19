package se.lexicon.spring_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.spring_boot_app.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
