package domain.model;

import javax.persistence.*;

@Entity
@Table(name = "vote_assembly")
public class VoteAssembly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @OneToOne()
    @JoinColumn(name = "topic_assembly_id")
    private TopicAssembly topicAssembly;

    private String document;
    private Boolean vote;

    public VoteAssembly() {
    }
    public VoteAssembly(TopicAssembly topicAssembly, String document, Boolean vote) {
        this.topicAssembly = topicAssembly;
        this.document = document;
        this.vote = vote;
    }
}
