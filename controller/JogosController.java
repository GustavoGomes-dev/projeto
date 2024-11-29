package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.UpdateJogoDto;
import com.example.demo.model.JogosModel;
import com.example.demo.service.JogosService;

@RestController
@RequestMapping("/catalogo")
public class JogosController {

    @Autowired
    private JogosService jogosService;

    @PostMapping("/adicionar")
    public ResponseEntity<JogosModel> adicionarCatalogo(@RequestBody JogosModel jogo) {
        JogosModel jogoCriado = jogosService.criarJogo(jogo);
        return new ResponseEntity<>(jogoCriado, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<JogosModel>> listarCatalogo() {
        List<JogosModel> jogos = jogosService.listarJogos();
        return ResponseEntity.ok(jogos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogosModel> getJogoPorId(@PathVariable("id") Long id) {
        return jogosService.getJogoPorId(id)
                .map(jogo -> ResponseEntity.ok(jogo))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogosModel> atualizarJogo(@PathVariable("id") Long id, @RequestBody JogosModel jogoAtualizado) {
        JogosModel jogo = jogosService.atualizarJogo(id, jogoAtualizado);
        return jogo != null ? ResponseEntity.ok(jogo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogo(@PathVariable("id") Long id) {
        return jogosService.deletarJogo(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
