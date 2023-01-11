package domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "session_assembly")
public class SessionAssembly {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long sessionId;

        @OneToOne()
        @JoinColumn(name = "topic_assembly_id")
        private TopicAssembly topicAssembly;

        private LocalDateTime startVote;
        private LocalDateTime finalVote;
        private Boolean produceMessage;
        public SessionAssembly() {
        }

        public SessionAssembly(TopicAssembly topicAssembly, LocalDateTime startVote, LocalDateTime finalVote) {
            this.topicAssembly = topicAssembly;
            this.startVote = startVote;
            this.finalVote = finalVote;
        }

        public SessionAssembly(TopicAssembly topicVote, LocalDateTime startVote, LocalDateTime finalVote, Boolean produceMessage) {
            this.topicAssembly = topicVote;
            this.startVote = startVote;
            this.finalVote = finalVote;
            this.produceMessage = produceMessage;
        }

    }
