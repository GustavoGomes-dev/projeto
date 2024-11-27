// const modal = document.getElementById('modal');
// const openModalButton = document.getElementById('openModal');
// const closeModalButton = document.getElementById('closeModal');
// const confirmButtonModal= document.getElementById('novo');

// openModalButton.addEventListener('click', () => {
//     modal.classList.add('show');
// });

// closeModalButton.addEventListener('click', () => {
//     modal.classList.remove('show');
// });

// // Fecha a modal clicando fora do conteúdo
// modal.addEventListener('click', (e) => {
//     if (e.target === modal) {
//         modal.classList.remove('show');
//     }
// });

async function buscarJogos() {
  try {
    const response = await fetch("http://localhost:8080/Jogos"); // Requisição para a API
    if (response.ok) {
      const Jogos = await response.json(); // Converte a resposta em JSON
      exibirJogos(Jogos); // Passa os dados para a função de exibição
    } else {
      console.error("Erro na requisição:", response.status);
    }
  } catch (error) {
    console.error("Erro de conexão:", error);
  }
}

// Função para exibir médicos no HTML
function exibirJogos(Jogos) {
  const container = document.getElementById("Catalogo_jogos"); // Encontra o container

  // Verifica se há médicos e exibe ou esconde as divs
  if (Jogos.length === 0) {
    // Não há médicos
    container.style.display = "none"; // Esconde o container de médicos
  } else {
    // Há médicos
    container.style.display = "block"; // Exibe o container de médicos

    // Limpa qualquer conteúdo anterior no container
    container.innerHTML = "";

    // Cria uma div para cada médico
    Jogos.forEach((Jogos) => {
      const JogosDiv = document.createElement("div"); // Cria uma nova div para o médico
      JogosDiv.classList.add("jogo"); // Adiciona uma classe para estilo (opcional)

      // Adiciona o conteúdo da div do médico
      JogosDiv.innerHTML = `
                <p class="id">${Jogos.id}</p>
                <p class="foto_jogo">O</p> <!-- Eu imagino que "O" seja um marcador para foto -->
                <p class="nome_jogo">${Jogos.nome}</p>
                <p class="categoria_jogo">${Jogos.categoria}</p>
                <p class="classificacao_jogo">${Jogos.classificacao}</p>
                <p class="avaliacao_jogo">${Jogos.avaliacao}</p> 
                <p class="lancamento jogo">${Jogos.lancamento}</p>  
                <p class="descricao">${Jogos.descricao}</p> 
               
            `;

      // Adiciona a div criada ao container
      container.appendChild(JogosDiv);
    });
  }
}

// Chama a função para buscar e exibir os médicos ao carregar a página
buscarJogos();
