package controller;

import domain.dto.SessionAssemblyDto;
import domain.request.SessionAssemblyRequest;
import domain.response.SessionAssemblyResponse;
import mapper.SessionAssemblyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SessionAssemblyService;

@RestController
@RequestMapping(value = "/topics-assembly", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class SessionController {

        @Autowired
        private SessionAssemblyService sessionService;

        @Autowired
        private SessionAssemblyMapper sessionAssemblyMapper;

        @RequestMapping(value = "/v1/{topicVoteId}/open-session", method = RequestMethod.POST)
        public ResponseEntity<SessionAssemblyResponse> openSession(@PathVariable Long topicAssemblyId, @RequestBody SessionAssemblyRequest sessionRequest) {
               SessionAssemblyDto sessionAssemblyDto =
                       sessionService.openSession(sessionAssemblyMapper.sessionRequestToSessionDto(topicAssemblyId, sessionRequest));
            return ResponseEntity.ok(sessionAssemblyMapper.dtoToSessionAssemblyResponse(sessionAssemblyDto));
        }

}
