<template> 
  <!--  Quando se usa um form no vue colocamos um @submit.prevent
        Um formulário quando é submetido envia os dados para o back end e recarrega a tela, mas neste caso 
        não queremos enviar os dados para o back-end nem que recarregue a tela. Este comando vai chamar
        um método de login. -->
  <form @submit.prevent="login">
    <h2>Login</h2>
    <p>
        <label for="username">Usuário: </label>
        <input type="text" id="username" required autofocus v-model="nome"/>
    </p>
    <p>
        <label for="inputPassword">Senha: </label>
        <input type="password" id="inputPassword" required v-model="senha"/>
    </p>
    <button type="submit">Ok</button>
  </form>
</template>

<script>
import axios from 'axios';
import { mapMutations } from 'vuex'; //Na store colocar usuário e senha para controlar o login.
export default {
        name: 'About'
    ,   data() {
            return {
                nome: ''
            ,   senha: ''
            }
        }
    ,   methods: {
            ...mapMutations([
                'setUsuario', 'setSenha'
            ])
        ,   login() {
                    axios.get('trabalho',
                             { params:     { id: 1},
                               headers:    { accept: 'application/json'}, //Quero receber um json
                               auth:       { username: this.nome, password: this.senha } //Minha autenticação
                            }
                    ).then( res => { //Se deu tudo certo funncionou usuário e senha
                        console.log(res);
                        this.sucesso();
                    }).catch(error => {
                        console.log(error);
                        if (error.response.status === 401){ //Significa que usuári oe senha estão errados
                            console.log('Usuário ou senha inváidos!');
                        } else { //Se for qualquer outro erro signfica que usuário e senha passou
                            this.sucesso();
                        }
                    })
                }
        ,   sucesso() {
                this.setUsuario(this.nome);
                this.setSenha(this.senha);
                this.$router.push('/trabalho'); //Necessário criar uma rota trabalho
            }
        }
}
</script>
