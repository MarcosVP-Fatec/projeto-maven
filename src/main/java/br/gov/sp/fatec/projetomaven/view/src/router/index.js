import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import store from '../store'
//import Ola from "../views/Alo.vue"

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
          path: '/ola/:nome'
        , name: 'ola'
        , props: true
        , component: () => import('../views/Alo.vue')
        , beforeEnter: (to, from, next) => {
            //Isto faz com que a tela About não possa chamar o Ola.vue
            //O if pode usar qualquer propriedade do from como from.path, por exemplo.
            if (from.name !== 'About') {
                next()
            } else {
                next(false)
            }
        }

        //, component: Ola

    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: function () {
            return import(/* webpackChunkName: "about" */ '../views/About.vue')
        }
    },
    {
        path: '/trabalho',
        name: 'Trabalho',
        component: () => import('../views/Trabalho.vue')       
    }

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

// to = Para onde quero ir
// from = De onde eu venho
// next = Função que uso para permitir ou não a navegação
router.beforeEach( (to, from, next) => {
    //Aqui faremos a verificação do usuário logado se ele tem premissão ou não de entrar
    if (store.state.permiteNavegacao) {
        next(true)
    } else {
        next(false)
    }
} )

export default router
