package ru.sapteh.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Model {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String model;

    @OneToMany (mappedBy = "marka")
    private Set<Model> models;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", model='" + model + '\'' +
                '}';
    }
}
