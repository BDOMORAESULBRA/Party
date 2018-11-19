package br.edu.ulbra.election.party.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.ulbra.election.party.output.v1.CandidateOutput;

@Service
public class CandidateClientService {

	private final CandidateClient candidateClient;

	@Autowired
	public CandidateClientService(CandidateClient candidateClient) {
		this.candidateClient = candidateClient;
	}

	public CandidateOutput verificaParty(Long id) {
		return this.candidateClient.verificaParty(id);
	}

	@FeignClient(value = "candidate-service", url = "${url.candidate-service}")
	private interface CandidateClient {

		@GetMapping("/v1/candidate/{partyId}")
		CandidateOutput verificaParty(@PathVariable(name = "partyId") Long partyId);
	}
}
