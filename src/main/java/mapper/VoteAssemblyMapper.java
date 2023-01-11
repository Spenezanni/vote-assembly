package mapper;

import domain.dto.VoteAssemblyDto;
import domain.model.TopicAssembly;
import domain.model.VoteAssembly;
import domain.request.VoteAssemblyRequest;
import domain.response.VoteAssemblyResponse;
import exception.Messages;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class VoteAssemblyMapper {

    public VoteAssembly dtoToVoteAssembly(TopicAssembly topicAssembly, VoteAssemblyDto voteAssemblyDto) {
        return new VoteAssembly(topicAssembly, voteAssemblyDto.getDocument(), voteAssemblyDto.getVoteAssembly());
    }

    public VoteAssemblyDto entityToVoteAssemblyDto(VoteAssembly voteAssembly) {
        return new VoteAssemblyDto(Objects.nonNull(voteAssembly));
    }

    public VoteAssemblyDto entityToVoteAssemblyDto(TopicAssembly topicAssembly, Long countVoteYes, Long countVoteNo) {
        return new VoteAssemblyDto(topicAssembly.getDescription(), countVoteYes, countVoteNo);
    }

    public VoteAssemblyDto requestToVoteAssemblyDto(Long topicAssemblyId, VoteAssemblyRequest voteAssemblyRequest) {
        VoteAssemblyDto voteAssemblyDto = new VoteAssemblyDto();
        voteAssemblyDto.setTopicAssemblyId(topicAssemblyId);
        voteAssemblyDto.setDocument(voteAssemblyRequest.getDocument());
        voteAssemblyDto.setVoteAssembly(voteAssemblyRequest.getVoteAssembly());
        return voteAssemblyDto;
    }

    public VoteAssemblyResponse dtoToVoteAssemblyResponse(VoteAssemblyDto voteAssemblyDto) {
        if (Objects.isNull(voteAssemblyDto)) {
            return new VoteAssemblyResponse(Messages.YOU_CAN_NOT_VOTE);
        }
        return new VoteAssemblyResponse(Messages.YOUR_VOTE_ASSEMBLY_IS_OK);
    }

    public VoteAssemblyDto requestToVoteAssemblyDto(Long topicAssemblyId) {
        VoteAssemblyDto voteAssemblyDto = new VoteAssemblyDto();
        voteAssemblyDto.setTopicAssemblyId(topicAssemblyId);
        return voteAssemblyDto;
    }

    private String buildMessage(Long countVoteYes, Long countVoteNo) {
        if (Objects.equals(countVoteYes, countVoteNo)) {
            return Messages.THE_OPTION_IS_THE_SAME;
        } else if (countVoteYes > countVoteNo) {
            return Messages.THE_OPTION_YES_WIN;
        }
        return Messages.THE_OPTION_NO_WIN;
    }
}
