package catalago.de.jogos.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import catalago.de.jogos.demo.dto.JogosDto;
import catalago.de.jogos.demo.dto.UpdateJogoDto;
import catalago.de.jogos.demo.model.JogosModel;
import catalago.de.jogos.demo.repository.JogosRepository;

@Service
public class JogosService {
	
	private JogosRepository jogosRepository;

	public JogosService(JogosRepository jogosRepository) {
		this.jogosRepository = jogosRepository;
	}
	
	public UUID createJogos(JogosDto jogosDto) {
		
		var entity = new JogosModel(UUID.randomUUID(), 
				jogosDto.nome(), 
				jogosDto.categoria(),
				jogosDto.classificacao(),
				jogosDto.avaliacao(), 
				jogosDto.lancamento(), 
				jogosDto.descricao());
		
		var jogoSaved =  jogosRepository.save(entity);
		
		return jogoSaved.getId();
		
	
		
	}
	
	public Optional<JogosModel> getUserById(String userId) {
		
		return jogosRepository.findById(UUID.fromString(userId));
	}
	public List<JogosModel> listJogos(){
		return jogosRepository.findAll();
	}
	
	public void updateJogoById(String userId, UpdateJogoDto updateJogoDto) {
		
		var id = UUID.fromString(userId);
		
		var userEntity = jogosRepository.findById(id);
		
		if(userEntity.isPresent()) {
			var jogo = userEntity.get();
			
			if (updateJogoDto.nome() != null) {
				jogo.setNome(updateJogoDto.nome());
				
			}
			if(updateJogoDto.categoria() != null) {
				jogo.setCategoria(updateJogoDto.categoria());
			}
			if(updateJogoDto.classificacao() != null) {
				jogo.setClassificação(updateJogoDto.classificacao());
			}
			if(updateJogoDto.avaliacao() != null) {
				jogo.setAvaliacao(updateJogoDto.avaliacao());
			}
			if(updateJogoDto.lancamento() != null) {
				jogo.setLancamento(updateJogoDto.lancamento());
			}
			if(updateJogoDto.descricao() != null) {
				jogo.setDescricao(updateJogoDto.descricao());
			}
			
			jogosRepository.save(jogo);
		}
			
		
		
	}
	public void deleteById(String userId) {
		var id = UUID.fromString(userId);
		
		var userExists = jogosRepository.existsById(id);
		
		if(userExists) {
			jogosRepository.deleteById(id);
		}
	}
}
