<template>
    <div class="ola">
        <h1>Olá {{ nome }}!</h1>
        <button @click="navegar">Início</button>
    </div>
</template>

<script>
export default {
      name: 'ola'
    , props: {
        nome: {
              type: String
            , default: 'Estranho'
        }
    }
    , methods: {
        navegar() {
            this.$router.push('/') //Esta url tem que seguir o que está configurado no index.js
        }
    }
}
</script>