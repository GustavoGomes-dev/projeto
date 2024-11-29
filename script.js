let contador = 0;
const openModalButton = document.getElementById("openModal");
const modal = document.getElementById("modal");
const closeModalButton = document.getElementById("closeModal");
const formCadastro = document.getElementById("formCadastro");
const listaJogo = document.getElementById("listaJogo");
const ModalExcluir = document.getElementById("modal-Excluir");
const cancelar = document.getElementById("cancelar");
const excluir = document.getElementById("excluir");

let linhaParaExcluir = null;

// Abrir o modal
openModalButton.addEventListener("click", function () {
  modal.classList.add("show");
});

// Fechar o modal
closeModalButton.addEventListener("click", function () {
  modal.classList.remove("show");
});

// Adicionar um jogo à tabela
formCadastro.addEventListener("submit", function (event) {
  event.preventDefault();

  const nome = document.getElementById("Nome").value;
  const categoria = document.getElementById("Categoria").value;
  const classificacao = document.getElementById("Classificação").value;
  const avaliacao = document.getElementById("Avaliação").value;
  const lancamento = document.getElementById("Lançamento").value;

  const novaLinha = document.createElement("tr");

  novaLinha.innerHTML = `
        <td>${nome}</td>
        <td>${categoria}</td>
        <td>${classificacao}</td>
        <td>${avaliacao}</td>
        <td>${lancamento}</td>
        <td><button onclick="abrirExcluir(this)">🗑️</button> <button onclick="alterarJogo(this)">✏️</button></td>
    `;

  listaJogo.appendChild(novaLinha);

  modal.classList.remove("show");
  formCadastro.reset();
});

// Abrir modal de exclusão
function abrirExcluir(botao) {
  linhaParaExcluir = botao.closest("tr");
  ModalExcluir.showModal();
}

// Cancelar exclusão
cancelar.addEventListener("click", function () {
  ModalExcluir.close();
});

// Confirmar exclusão
excluir.addEventListener("click", function () {
  if (linhaParaExcluir) {
    linhaParaExcluir.remove();
    linhaParaExcluir = null;
  }
  ModalExcluir.close();
});
