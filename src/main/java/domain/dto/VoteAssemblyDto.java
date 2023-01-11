package domain.dto;

import lombok.Data;

@Data
public class VoteAssemblyDto {

    private Long topicAssemblyId;
    private String document;
    private Boolean voteAssembly;
    private Boolean computedVote;
    private String topicAssemblyDescription;
    private Long countVoteYes;
    private Long countVoteNo;

    public VoteAssemblyDto() {
    }

    public VoteAssemblyDto(String description, Long countVoteYes, Long countVoteNo) {
        this.topicAssemblyDescription = description;
        this.countVoteYes = countVoteYes;
        this.countVoteNo = countVoteNo;
    }

    public VoteAssemblyDto(Boolean computedVote) {
        this.computedVote = computedVote;
    }
}
