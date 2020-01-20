package global.testingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import global.testingsystem.entity.Role;
import global.testingsystem.entity.SlideBanner;

@Repository
public interface SlideBannerRepository extends JpaRepository<SlideBanner, Integer> {
    

	List<SlideBanner> findBytitleContaining(String title);

	List<SlideBanner> findByshowTrue();
	List<SlideBanner> findAllByOrderByIdDesc();
}
