package pl.schronisko.schronisko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.schronisko.schronisko.model.Animal;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByName(String name);
}
