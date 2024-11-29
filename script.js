// Acessando os elementos do HTML
const openModalButton = document.getElementById("openModal");
const modal = document.getElementById("modal");
const closeModalButton = document.getElementById("closeModal");
const formCadastro = document.getElementById("formCadastro");
const listaJogo = document.getElementById("listaJogo");

// Abrir o modal
openModalButton.addEventListener("click", function() {
    modal.classList.add("show");  // Exibe o modal
});

// Fechar o modal
closeModalButton.addEventListener("click", function() {
    modal.classList.remove("show");  // Esconde o modal
});

// Adicionar um jogo à tabela
formCadastro.addEventListener("submit", function(event) {
    event.preventDefault();  // Previne o envio padrão do formulário

    // Coletando dados do formulário
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
        <td><button onclick="removerJogo(this)">🗑️</button> <button onclick="alterarJogo(this)">✏️</button> </td>
    `;

    listaJogo.appendChild(novaLinha);

    modal.classList.remove("show");

    formCadastro.reset();
});








function removerJogo(button) {
    button.closest("tr").remove();
}
