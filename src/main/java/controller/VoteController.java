package controller;

import domain.dto.VoteAssemblyDto;
import domain.request.VoteAssemblyRequest;
import domain.response.VoteAssemblyResponse;
import mapper.VoteAssemblyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.VoteAssemblyService;

@RestController
@RequestMapping(value = "/topics-assembly", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    @Autowired
    private VoteAssemblyService voteAssemblyService;
    @Autowired
    private VoteAssemblyMapper voteAssemblyMapper;

    @RequestMapping(value = "/v1/{topicAssemblyId}/vote/assembly", method = RequestMethod.POST)
    public ResponseEntity<VoteAssemblyResponse> voteAssembly(@PathVariable Long topicVoteId, @RequestBody VoteAssemblyRequest voteAssemblyRequest) {
        VoteAssemblyDto voteAssemblyDto =
                voteAssemblyService.voteAssembly(voteAssemblyMapper.requestToVoteAssemblyDto(topicVoteId, voteAssemblyRequest));
        return ResponseEntity.ok(voteAssemblyMapper.dtoToVoteAssemblyResponse(voteAssemblyDto));
    }

    @RequestMapping(value = "/v1/{topicAssemblyId}/result/vote/assembly", method = RequestMethod.GET)
    public ResponseEntity<VoteAssemblyResponse> getResultVoteAssembly(@PathVariable Long topicAssemblyId) {
        VoteAssemblyDto voteAssemblyDto =
                voteAssemblyService.result(voteAssemblyMapper.requestToVoteAssemblyDto(topicAssemblyId));
        return ResponseEntity.ok(voteAssemblyMapper.dtoToVoteAssemblyResponse(voteAssemblyDto));
    }

}
