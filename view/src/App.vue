<template>
  <div id="app">
    <p>Novo curso:
      <input type="text" v-model="novo">
      <button @click="incluir">Inserir</button>
    </p>
    <ul>
      <app-curso-item v-for="(curso, indice) in cursos" @click="excluir(indice)" :key="indice" :valueDoCursoItem="curso.nome">
        ( {{ indice + 1}} - {{curso.nome}} )
      </app-curso-item>
      <!-- Este componente abaixo serve para quando você precisa trocar o que mostrar de acordo com a opção -->
      <!-- Exemplo dois componentes que recebem o mesmo parâmetro -->
      <component :is="componenteFixo" valueDoCursoItem="Fixo">( 9999 )</component>
    </ul>
  </div>
</template>

<script>
    // Importa o componente 
    import CursoItem from './components/CursoItem';
    export default {
        name: 'app',
        // Exporta o componente para ser usado
        components: {
            'app-curso-item': CursoItem // O nome app-curso-item é para ser usado em tags html
        },
        data() {
            return {
                componenteFixo: 'app-curso-item',
                novo: '',
                cursos: [   { nome: 'ADS'           },
                            { nome: 'Banco de Dados'}
                        ]
            }
        },
        methods: {
        incluir() {
            if(this.novo.trim().length == 0) {
            alert('O nome do curso deve ser preenchido!');
            } else {
            this.cursos.push( { nome: this.novo } );
            this.novo = '';
            }
        },
        excluir(indice) {
            if(confirm("Excluir da lista a opção << " + this.cursos[indice].nome + " >> ?")){
            this.cursos.splice(indice , 1);
            }
        }
        }
    }
</script>