package br.gov.sp.fatec.projetomaven.model;

public class UsuarioLogado {
    
    // Instanciamos a classe dentro dela mesma
    private static UsuarioLogado usuario;

    //Atributos que serão instanciados
    private Long      id;
    private String    nome;


    /**
     * O construtor é privado, portanto esta classe não pode ser instanciada
     */
    private UsuarioLogado () {  
        usuario.nome = "Usuário Teste";
        usuario.id = 1L;
      }


    /**
     * O método getInstance() é a essência do singleton
     * Quando este método é executado verifica se a instância é nula. Se for nula ele é instanciado
     * e coloca na variável instance.
     * @return instance
     */
    public static UsuarioLogado usuario() {
        /*
        if (usuario == null) {
            //TODO
            this.nome = "Usuário Teste";
        }*/
        return usuario;
    }

    public String getNome() {
        return this.nome;
    }

    public Long getId() {
        return this.id;
    }
    

}