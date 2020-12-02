<template>
  <div id="app">
    <app-input/>
    <app-output/>
  </div>
</template>

<script>
    // Importa o componente 
    // import CursoItem from './components/CursoItem';
    import Input from './components/Input';
    import Output from './components/Output';
    export default {
        name: 'app',
        // Exporta o componente para ser usado
        components: {
            // 'app-curso-item': CursoItem, // O nome app-curso-item é para ser usado em tags html
            'app-input': Input,
            'app-output': Output
        }
        
        // data() {
        //     return {
        //         componenteFixo: 'app-curso-item',
        //         numero1: 0,
        //         numero2: 0
        //     }
        // },
        // methods: {
        //     numero1Mudou(evento){
        //         this.numero1 = evento.target.value;
        //     },
        //     numero2Mudou(evento){
        //         this.numero2 = evento.target.value;
        //     }
        // }
    }
</script>