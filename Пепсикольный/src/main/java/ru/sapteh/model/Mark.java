package ru.sapteh.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Mark {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String mark;
    @Column
    private String concern;

    @OneToMany
    @JoinColumn (name = "mark_id")
    private Set<Mark> marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getConcern() {
        return concern;
    }

    public void setConcern(String concern) {
        this.concern = concern;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", concern='" + concern + '\'' +
                '}';
    }
}
