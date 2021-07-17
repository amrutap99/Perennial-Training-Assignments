package edu.ritindia.CovidSystem.repository;

import edu.ritindia.CovidSystem.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is Repository interface
 */
public interface LocationRepository extends JpaRepository<LocationModel, Long> {


}
