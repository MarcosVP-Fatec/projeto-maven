<template>
    <li @click="itemClicado">
        <!-- Nome do curso -->
        <!-- Exibir a props no lugar do fixo acima -->
        <!-- A tag <slot/> coloca este conteúdo junto do que foi declarado no app.vue -->
        {{valueDoCursoItem}} - <slot/>
    </li>
</template>

<script>
    export default {
        name: 'CursoItem',
        props: {
            valueDoCursoItem: String //Entrada
        },
        methods: {
            itemClicado(evento){
                // Este nome liClick substitui o @click no app.vue, mas usamos o nome padrão click => this.$emit('liClick',evento) 
                this.$emit('click',evento) //Saída
            }
        }
    }
</script>