package controller;

import domain.dto.TopicAssemblyDto;
import domain.request.TopicAssemblyRequest;
import domain.response.TopicAssemblyResponse;
import mapper.TopicAssemblyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.TopicAssemblyService;

@RestController
@RequestMapping(value = "/topics-assembly", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TopicController {

    @Autowired
    private TopicAssemblyService topicAssemblyService;

    @Autowired
    private TopicAssemblyMapper topicAssemblyMapper;

    @RequestMapping(value = "/v1/create", method = RequestMethod.POST)
    public ResponseEntity<TopicAssemblyResponse> createTopicAssembly(@RequestBody TopicAssemblyRequest topicAssemblyRequest) {
        TopicAssemblyDto topicAssemblyDto =
                topicAssemblyService.saveTopicAssembly(topicAssemblyMapper.requestToTopicAssemblyDto(topicAssemblyRequest));
        return ResponseEntity.ok(topicAssemblyMapper.dtoToTopicAssemblyResponse(topicAssemblyDto));
    }

}
