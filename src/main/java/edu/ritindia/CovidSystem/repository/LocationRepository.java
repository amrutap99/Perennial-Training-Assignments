package edu.ritindia.CovidSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ritindia.CovidSystem.model.LocationModel;

public interface LocationRepository extends JpaRepository<LocationModel, Long>{

}
