package mapper;

import domain.dto.TopicAssemblyDto;
import domain.model.TopicAssembly;
import domain.request.TopicAssemblyRequest;
import domain.response.TopicAssemblyResponse;
import exception.Messages;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.Objects;

@Component
public class TopicAssemblyMapper {

    public TopicAssembly dtoToTopicAssembly(TopicAssemblyDto topicAssemblyDto) {
        TopicAssembly topicAssembly = new TopicAssembly();
        topicAssembly.setDescription(topicAssemblyDto.getDescription());
        return topicAssembly;
    }

    public TopicAssemblyDto entityToTopicAssemblyDto(TopicAssembly topicAssemblyEntity) {

        if (Objects.isNull(topicAssemblyEntity)) {
            return null;
        }
        TopicAssemblyDto topicAssemblyDto = new TopicAssemblyDto();
        topicAssemblyDto.setTopicAssemblyId(topicAssemblyEntity.getTopicAssemblyId());
        topicAssemblyDto.setDescription(topicAssemblyEntity.getDescription());
        return topicAssemblyDto;
    }

    public TopicAssemblyDto requestToTopicAssemblyDto(TopicAssemblyRequest topicAssemblyRequest) {
        if (StringUtils.isEmpty(topicAssemblyRequest.getDescription())) {
            throw new IllegalArgumentException(Messages.THE_FIELD_DESCRIPTION_IS_REQUIRED);
        }

        TopicAssemblyDto topicVoteDTO = new TopicAssemblyDto();
        topicVoteDTO.setDescription(topicAssemblyRequest.getDescription());
        return topicVoteDTO;
    }

    public TopicAssemblyResponse dtoToTopicAssemblyResponse(TopicAssemblyDto topicAssemblyDto) {
        TopicAssemblyResponse topicVoteResponse = new TopicAssemblyResponse();
        topicAssemblyDto.setDescription(topicAssemblyDto.getDescription());
        return topicVoteResponse;
    }
}
