package domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "topic_assembly")
public class TopicAssembly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_assembly_id")
    private Long topicAssemblyId;

    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "topicAssembly")
    private SessionAssembly sessionAssembly;

    public TopicAssembly() {}

    public TopicAssembly(String description) {
        this.description = description;
    }
}
