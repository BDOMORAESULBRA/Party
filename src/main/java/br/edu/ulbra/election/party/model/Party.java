package br.edu.ulbra.election.party.model;

import javax.persistence.*;
import br.edu.ulbra.election.party.repository.PartyRepository;

@Entity
public class Party {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String code;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Integer number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public static boolean verificaCode(String code, PartyRepository partyRepository) {

		Iterable<Party> list = partyRepository.findAll();

		for (Party e : list) {
			if (e.getCode().equalsIgnoreCase(code)) {
				return true;
			}
		}
		return false;

	}

	public static boolean verificaNumber(Integer number, PartyRepository partyRepository) {

		Iterable<Party> list = partyRepository.findAll();

		for (Party e : list) {
			if (e.getNumber().equals(number)) {
				return true;
			}
		}
		return false;
	}

}
