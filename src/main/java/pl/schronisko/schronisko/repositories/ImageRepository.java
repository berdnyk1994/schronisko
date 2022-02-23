package pl.schronisko.schronisko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.schronisko.schronisko.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {


}
