package pl.schronisko.schronisko.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.schronisko.schronisko.model.Animal;
import pl.schronisko.schronisko.service.AnimalService;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/")
    public String animals(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("animals", animalService.listAnimals(name));
        return "animals";
    }

    @GetMapping("/product/{id}")
    public String animalInfo(@PathVariable Long id, Model model) {
        Animal animal = animalService.getProductById(id);
        model.addAttribute("animal", animal);
        model.addAttribute("images", animal.getImages());
        return "animal-info";
    }

    @PostMapping("/animal/create")
    public String createAnimal(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                               @RequestParam("file3") MultipartFile file3, Animal animal) throws IOException {
        animalService.saveProduct(animal, file1, file2, file3);
        return "redirect:/";
    }
    @PostMapping("/product/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/";
    }


}
