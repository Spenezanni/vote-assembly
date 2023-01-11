package domain.request;

import lombok.Data;

@Data
public class VoteAssemblyRequest {

    private String document;
    private Boolean voteAssembly;

    public VoteAssemblyRequest() {
    }

    public VoteAssemblyRequest(String document, Boolean vote) {
        this.document = document;
        this.voteAssembly = vote;
    }
}
