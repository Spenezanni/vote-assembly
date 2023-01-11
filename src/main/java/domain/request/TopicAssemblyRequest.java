package domain.request;

import lombok.Data;

@Data
public class TopicAssemblyRequest {

    private String description;

    public TopicAssemblyRequest() {
    }

    public TopicAssemblyRequest(String description) {
        this.description = description;
    }
}
