<template>
    <div>
        <form @submit.prevent="cadastrar"> 
            <h2>Trabalho</h2>
            <p>
                <label for="titulo">Titulo</label>
                <input type="text" id = "titulo" required autofocus v-model="titulo">
            </p>
            <p>
                <label for="localArquivo">Local do Arquivo</label>
                <input type="text" id = "localArquivo" required v-model="localArquivo">
            </p>
        </form>
        <br>
        <table>
            <thead>
                <th>Id</th>
                <th>Titulo</th>
                <th>Local do Arquivo</th>
                <th>Data/Hora</th>
            </thead>
            <tbody>
                <tr v-for="trab in trabalhos" :key="trab.id">
                    <td>{{ trab.id              }}</td>
                    <td>{{ trab.titulo          }}</td>
                    <td>{{ trab.localArquivo    }}</td>
                    <td>{{ trab.DataHoraEntrega }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from 'axios';
import { mapState } from 'vuex';

export default {
    name: 'anotacoes',
    data() {
        return {
            titulo: '',
            localArquivo: '',
            trabalhos: []
        }
    },
    computed: {
        ...mapState([
            'usuario',
            'senha'
        ])
    },
    methods: {
        cadastrar() {
            // 1º parâmetro = rota
            // 2º parâmetro = json
            // 3º parãmetro = propriedades= autenticação.
            axios.post('trabalho',
                {
                    titulo: this.titulo,
                    dataHoraEntrega: new Date(),
                    localArquivo: this.localArquivo
                },
                {
                    auth: {
                        username: this.usuario,
                        password: this.senha
                    }
                }
            ).then( res => {
                console.log(res);
                this.titulo='';
                this.texto='';
                this.trabalhos.push(res.data);
            }).catch( error => console.log(error))
        }
    }
}
</script>