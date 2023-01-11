package mapper;

import domain.dto.SessionAssemblyDto;
import domain.model.SessionAssembly;
import domain.model.TopicAssembly;
import domain.request.SessionAssemblyRequest;
import domain.response.SessionAssemblyResponse;
import exception.Messages;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class SessionAssemblyMapper {

    public SessionAssemblyDto sessionRequestToSessionDto(Long topicAssemblyId, SessionAssemblyRequest sessionRequest) {
        SessionAssemblyDto sessionAssemblyDto = new SessionAssemblyDto();
        sessionAssemblyDto.setTopicAssemblyId(topicAssemblyId);
        sessionAssemblyDto.setFinalVote(sessionRequest.getFinalVote());
        return sessionAssemblyDto;
    }

    public SessionAssembly dtoToSessionAssembly(TopicAssembly topicAssembly, LocalDateTime startVote, SessionAssemblyDto sessionDto) {
        SessionAssembly session = new SessionAssembly();
        session.setTopicAssembly(topicAssembly);
        session.setStartVote(startVote);
        session.setFinalVote(buildfinalVote(sessionDto.getFinalVote(), startVote));
        return session;
    }

    private LocalDateTime buildfinalVote(LocalDateTime finalVote, LocalDateTime startVote) {
        if (Objects.isNull(finalVote)) {
            return startVote.plusMinutes(1);
        }
        return finalVote;
    }

    public SessionAssemblyDto entityToSessionAssemblyDto(SessionAssembly sessionSaved) {
        return new SessionAssemblyDto(Objects.nonNull(sessionSaved));
    }

    public SessionAssemblyResponse dtoToSessionAssemblyResponse(SessionAssemblyDto sessionAssemblyDto) {
        SessionAssemblyResponse sessionAssemblyResponse = new SessionAssemblyResponse();
        if (sessionAssemblyDto.isOpened()) {
            return new SessionAssemblyResponse(Messages.THE_SESSION_TO_ASSEMBLY_HAS_OPENED);
        }
        return new SessionAssemblyResponse(Messages.THE_SESSION_TO_ASSEMBLY_CAN_NOT_OPEN);
    }
}
