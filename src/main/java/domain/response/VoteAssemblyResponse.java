package domain.response;

import lombok.Data;

@Data
public class VoteAssemblyResponse {
    private TopicAssemblyResponse topicVote;
    private VoteAssemblyResultResponse result;
    private String message;
    public VoteAssemblyResponse() {
    }

    public VoteAssemblyResponse(String message) {
        this.message = message;
    }

    public VoteAssemblyResponse(TopicAssemblyResponse topicVote, VoteAssemblyResultResponse result, String message) {
        this.topicVote = topicVote;
        this.result = result;
        this.message = message;
    }
}
