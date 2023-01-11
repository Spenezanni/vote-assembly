package domain.response;

public class VoteAssemblyResultResponse {
    private Long countVoteYes;
    private Long countVoteNo;

    public VoteAssemblyResultResponse() {
    }

    public VoteAssemblyResultResponse(Long countVoteYes, Long countVoteNo) {
        this.countVoteYes = countVoteYes;
        this.countVoteNo = countVoteNo;
    }

}
