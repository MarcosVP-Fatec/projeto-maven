<template>
    <div>
        <label for="numero1">Primeiro número </label>
        <input id="numero1"
               type="number"
               :value="numero1"
               @input="tratarNumero1"
        />

        <label for="numero2"> Segundo número </label>
        <input id="numero2"
               type="number"
               :value="numero2"
               @input="tratarNumero2"
        />
    </div>
</template>

<script>
export default {
    name: 'Input',
    props: {
        numero1: Number,
        numero2: Number
    },
    methods: {
        tratarNumero1 (evento) {
            this.$emit('inputNumero1',evento)
        },
        tratarNumero2 (evento) {
            this.$emit('inputNumero2',evento)
        }
    },
    
}
</script>
