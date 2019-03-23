import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Agenda from './views/Agenda.vue'
import Directions from './views/Directions.vue'
import EventSummary from './views/EventSummary.vue'
import Login from './views/Login.vue'
import Talk from './views/Talk.vue'

Vue.use(Router)

export default new Router({
  routes: [{
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import( /* webpackChunkName: "about" */ './views/About.vue')
    },
    {
      path: '/agenda',
      name: 'agenda',
      component: Agenda
    },
    {
      path: '/directions',
      name: 'directions',
      component: Directions
    },
    {
      path: '/event-summary',
      name: 'event-summary',
      component: EventSummary
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/talk',
      name: 'talk',
      component: Talk
    },
  ]
});