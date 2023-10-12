package com.meisterlampe.dockertestingarea2.repository;
import com.meisterlampe.dockertestingarea2.entities.Ausleihe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AusleiheRepository extends JpaRepository<Ausleihe, Integer> {


}
