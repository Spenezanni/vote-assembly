package domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicAssemblyResponse {

    private String description;

    public TopicAssemblyResponse() {
    }

    public TopicAssemblyResponse(String description) {
        this.description = description;
    }
}
