package com.kayulu.springbootAdvancedMappings.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // Notes:
    // FetchType.EAGER
    // To avoid a LazyInitializationException when adding a Review to a Course, the list of Reviews must be present
    // after a Course has been loaded by the EntityManager.
    // Note that FetchType.LAZY is the preferred way to retrieve an entity with a collection of related entities.
    // This must be done inside a transaction that encapsulates the loading of both, the entity and its collection.

    // @JoinColumn
    // This annotation tells Hibernate/JPA how tables in the database are linked by foreign-keys.
    // Regarding the Java side this is a unidirectional one-to-many association (Review class does not know to which
    // Course it belongs to, but Course knows about all it's reviews).
    // On the database side however each review is related to its course by a foreign-key.
    // The @JointTable annotation describes this exact scenario to Hibernate.
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() { return reviews; }

    public void setReviews(List<Review> reviews) { this.reviews = reviews; }

    public void addReview(Review review) {
        if(reviews == null) {
            reviews = new ArrayList<>();
        }

        reviews.add(review);
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
