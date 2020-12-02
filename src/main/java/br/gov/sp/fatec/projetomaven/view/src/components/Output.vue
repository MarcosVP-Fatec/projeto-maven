<template>
    <div>
        <!-- A multiplicação abaixo serve apenas para não concatenar os dois elementos-->
        <!-- <p>{{numero1}} + {{numero2}} = {{ numero1 * 1 + numero2 * 1}}</p> 
        <p>{{numero1}} - {{numero2}} = {{ numero1 - numero2 }}</p>
        <p>{{numero1}} x {{numero2}} = {{ numero1 * numero2 }}</p> -->
        <p>{{ soma }}</p>
        <p>{{ subtracao }}</p>
        <p>{{ multiplicacao }}</p>
    </div>
</template>

<script>
import { mapGetters } from 'vuex' 
export default {
    name: 'Output',
    computed: {
        ...mapGetters([
            'soma',
            'subtracao',
            'multiplicacao'
        ])
    }
    //    ...mapState([
    //         'numero1', 
    //         'numero2'
    //   ]) 
    /* props: {
        numero1: Number,
        numero2: Number
    }  */
}
</script>
