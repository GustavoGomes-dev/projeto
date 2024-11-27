package catalago.de.jogos.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import catalago.de.jogos.demo.dto.JogosDto;
import catalago.de.jogos.demo.dto.UpdateJogoDto;
import catalago.de.jogos.demo.model.JogosModel;
import catalago.de.jogos.demo.service.JogosService;

@RestController
@CrossOrigin("*")
@RequestMapping ("Jogos")
public class JogosController {
	
	private JogosService jogosService;


	public JogosController(JogosService jogosService) {
		
		this.jogosService = jogosService;
	}






	
	@PostMapping
	public ResponseEntity<JogosModel> createJogos(@RequestBody JogosDto jogosDto) {
	    var jogoid = jogosService.createJogos(jogosDto);
	    return ResponseEntity.created(URI.create("/Jogos/" + jogoid.toString())).build(); 
	}

	
	@GetMapping("/{userId}")
	public ResponseEntity<JogosModel> getUserById(@PathVariable("userId") String userId){
		var jogo = jogosService.getUserById(userId);
		if(jogo.isPresent()) {
			return ResponseEntity.ok(jogo.get());
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<JogosModel>> listJogos(){
		var jogos = jogosService.listJogos();
		
		return ResponseEntity.ok(jogos);
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId, @RequestBody UpdateJogoDto upadateJogoDto){
		jogosService.updateJogoById(userId, upadateJogoDto);
		return ResponseEntity.noContent().build();
		
		
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId){
		jogosService.deleteById(userId);
		return ResponseEntity.noContent().build();
		
		
	}
}
