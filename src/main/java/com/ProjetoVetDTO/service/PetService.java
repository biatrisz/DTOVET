package com.ProjetoVetDTO.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoVetDTO.dto.PetDTO;
import com.ProjetoVetDTO.entities.Pet;
import com.ProjetoVetDTO.repository.PetRepository;
@Service
public class PetService {
	private final PetRepository petRepository;
	
	@Autowired
	public PetService (PetRepository petRepository) {
		this.petRepository = petRepository;
	}
		public PetDTO salvar (PetDTO PetDTO) {
			Pet pet = new Pet (PetDTO.nome(), PetDTO.nascimento(), PetDTO.cuidador());
			Pet salvarPet = petRepository.save(pet);
			return new PetDTO (salvarPet.getId(), salvarPet.getnome(),  salvarPet.getnascimento(), salvarPet.getCuidador());
		}
			public PetDTO atualizar (Long id, PetDTO petDTO) {
				Pet existePet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
				
				existePet.setnome(petDTO.nome());
				existePet.setnascimento(petDTO.nascimento());
				existePet.setCuidador(petDTO.cuidador());

				Pet updatePet = petRepository.save(existePet);
				
				return PetDTO (updatePet.getId(), updatePet.getnome(),updatePet.getdocumento(),updatePet.getnascimento(),updatePet.getCuidador());
			}
				private PetDTO PetDTO(Long id, String getnome, String getdocumento, String getnascimento, String cuidador) {
				return null;
			}
				public boolean deletar (Long id) {
					Optional <Pet> existePet = petRepository.findById(id);
					if (existePet.isPresent()) {
						petRepository.deleteById(id);
					return true;
				}
				return false;
			}
			public List<Pet>buscarTodos(){
				return petRepository.findAll();
			}
			public Pet buscarPorId(Long id) {
				Optional <Pet> pet = petRepository.findById(id);
				return pet.orElse(null);
			}
}
