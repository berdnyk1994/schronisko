package pl.schronisko.schronisko.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long id;

    @Column(name = "type")
    public String type;
    @Column(name = "name")
    public String name;
    @Column(name = "size")
    public String size;
    @Column(name = "age")
    public int age;
    @Column(name = "sex")
    public String sex;
    @Column(name = "description")
    public String description;
    @Column(name = "status")
    public String status;
    @Column(name = "number")
    private String number;
    @Column(name = "chip_number")
    private long chipNumber;

    @Column(name = "date_of_admission")
    private Date dateOfAdmission;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "animal")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreated;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }


    public void addImageToAnimal(Image image) {
        image.setAnimal(this);
        images.add(image);
    }
}
