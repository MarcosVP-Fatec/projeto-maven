import Vue          from 'vue'
import Vuex         from 'vuex'
import VuexPersist  from 'vuex-persist'

Vue.use(Vuex)

// Instansiar o vuexPersist
const vuexPersist = new VuexPersist({
     key: 'my-app' //Colocar um número único
   , storage: localStorage
})

// Similar a classes do java
// Todas as variáveis criadas aqui são compartilhadas por todos os componentes da aplicação
// Possível criar getters para não acessar a variável diretamente
// Mutations são métodos (setters) para acessar os valores do estado indiretamente. A vantagem
//   é que se vc tiver instalado em seu navegador a extensão "devtools" você conseguirá mapear
//   quando a variável foi alterada, porque quando o motation for chamado ele irá logar.
//   A limitação é que ele só set. Não consegue fazer nada assíncrono. Ele fica esperando.
//   Quando se chama uma mutation é fazer uma COMMIT. O valor vai ser aplicado a um STATE por uma mutation
// Actions servem para fazer operações assincronas com chamadas ao back-end e o resultado vai alterar o estado
//   Quando se chama uma Action se chama dispatch

export default new Vuex.Store({
  plugins: [
    vuexPersist.plugin
  ],  
  state: {
      numero1: 0
    , numero2: 0
    , permiteNavegacao: true    
    , usuario: ''
    , senha: ''
  },
  getters: {
      soma(state)             { return state.numero1 * 1 + state.numero2 * 1 }
    , subtracao(state)        { return state.numero1 - state.numero2         }
    , multiplicacao: state => { return state.numero1 * state.numero2         }
  },
  mutations: {
      setNumero1(state, valor)      { state.numero1 = valor;                            }
    , setNumero2(state, valor)      { state.numero2 = valor;                            }
    , alterarPermiteNavegacao(state){ state.permiteNavegacao = !state.permiteNavegacao; }
    , setUsuario(state, valor)      { state.usuario = valor;                            }
    , setSenha(state, valor)        { state.senha = valor;                              }
  },
  actions: {
      setNumero2Delay (context, valor) {
        setTimeout(() => {
            context.commit('setNumero2', valor)
        }, 1000)
      }
  },
  modules: {
  }
})
