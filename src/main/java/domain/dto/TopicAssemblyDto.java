package domain.dto;

import lombok.Data;
@Data
public class TopicAssemblyDto {
    private Long topicAssemblyId;
    private String description;
    public TopicAssemblyDto() {
    }

    public TopicAssemblyDto(String description) {
        this.description = description;
    }

    public TopicAssemblyDto(Long topicAssemblyId, String description) {
        this.topicAssemblyId = topicAssemblyId;
        this.description = description;
    }
}
