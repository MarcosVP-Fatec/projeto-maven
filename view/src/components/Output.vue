<template>
    <div>
        <!-- A multiplicação abaixo serve apenas para não concatenar os dois elementos-->
        <p>{{numero1}} + {{numero2}} = {{ numero1 * 1 + numero2 * 1}}</p> 
        <p>{{numero1}} - {{numero2}} = {{ numero1 - numero2 }}</p>
        <p>{{numero1}} x {{numero2}} = {{ numero1 * numero2 }}</p>
    </div>
</template>

<script>
export default {
    name: 'Output',
    props: {
        numero1: Number,
        numero2: Number
    }
}
</script>
