package catalago.de.jogos.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import catalago.de.jogos.demo.model.JogosModel;

@Repository
public interface JogosRepository extends JpaRepository <JogosModel, UUID> {

}
