package javaweb.workshop.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "homeworks")
public class Homework extends BaseEntity {

    private LocalDateTime addedOn;
    private String gitAddress;
    private User author;
    private Exercise exercise;
    private Set<Comment> comments;

    public Homework() {
    }

    @Column(name = "added_on")
    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    @Column(name = "git_address")
    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }

    @ManyToOne()
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @ManyToOne()
    @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @OneToMany(mappedBy = "homework", targetEntity = Comment.class,
    fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
