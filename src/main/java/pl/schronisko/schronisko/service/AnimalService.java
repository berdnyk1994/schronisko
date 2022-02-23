package pl.schronisko.schronisko.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.schronisko.schronisko.model.Animal;
import pl.schronisko.schronisko.model.Image;
import pl.schronisko.schronisko.repositories.AnimalRepository;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;

    public List<Animal> listAnimals(String name) {
        if (name != null) return animalRepository.findByName(name);
        return animalRepository.findAll();
    }
//    public List<Animal> listAnimalsByNumber(String number) {
//        if (number != null) return animalRepository.findByNumber(number);
//        return animalRepository.findAll();
//    }

    public void saveProduct(Animal animal, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            animal.addImageToAnimal(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            animal.addImageToAnimal(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            animal.addImageToAnimal(image3);
        }
        log.info("Saving new Animal. Type: {}; Name: {}; ",animal.getType(), animal.getName());
        Animal productFromDb = animalRepository.save(animal);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        animalRepository.save(animal);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
    public Animal getProductById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

}
