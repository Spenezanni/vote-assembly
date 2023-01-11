package domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessionAssemblyDto {
    private Long topicAssemblyId;
    private LocalDateTime finalVote;
    private boolean opened;
    public SessionAssemblyDto() {
    }
    public SessionAssemblyDto(boolean opened) {
        this.opened = opened;
    }

    public SessionAssemblyDto(Long topicAssemblyId, LocalDateTime finalVote) {
        this.topicAssemblyId = topicAssemblyId;
        this.finalVote = finalVote;
    }
}
