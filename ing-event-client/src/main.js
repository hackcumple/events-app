import Vue from 'vue'
import App from './App.vue'
import router from './router'
import { library } from '@fortawesome/fontawesome-svg-core'
import {faCoffee, faListAlt, faStar, faThumbsUp, faMap, faTicketAlt, faInfoCircle} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import Vuex from 'vuex'
import VueCookies from 'vue-cookies'

library.add(faCoffee)
library.add(faListAlt)
library.add(faStar)
library.add(faThumbsUp)
library.add(faMap)
library.add(faTicketAlt)
library.add(faInfoCircle)

Vue.use(Vuex);
Vue.use(VueCookies);

VueCookies.config('7d')
 
// Vue.use(VueReactiveCookie);
Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false

const store = new Vuex.Store({
  state: {
    eventData: {
      name: '',
      city: '',
      streetName: '',
      streetNumber: '',
      date: '',
      description: ''
    },
    lectureNotes: {
      list: []
    }
  },
  mutations: {
    chooseEvent(state, payload) {
      state.eventData = payload
    },
    addNote(state, payload) {
      state.lectureNotes.list.push(payload);
    }
  }
})

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
