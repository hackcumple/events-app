import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Agenda from './views/Agenda.vue'
import Directions from './views/Directions.vue'
import EventSummary from './views/EventSummary.vue'
import Login from './views/Login.vue'
import Talk from './views/Talk.vue'
import ImageUpload from './views/ImageUpload.vue'
import AttendeesChart from "./views/AttendeesChart";

import EventCreation from './views/EventCreation.vue'

import SpeakerEvaluation from "./views/SpeakerEvaluation";
import Transcription from './views/Transcription.vue'
import LostAndFound from "./views/LostAndFound";
import Rating from "./views/Rating";

Vue.use(Router);

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
            component: EventSummary,
            props: true
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/image-upload',
            name: 'imageUpload',
            component: ImageUpload
        },
        {
            path: '/attendees',
            alias: '/prelegent',
            name: 'attendees',
            component: AttendeesChart
        },
        {
            path: '/event-creation',
            alias: '/admin',
            name: 'eventCreation',
            component: EventCreation
        },
        {
            path: '/talk',
            name: 'talk',
            component: Talk,
            props: (route) => ({
                talkId: 'test',
                ...route.params
            })
        },
        {
            path: '/speakerevaluation',
            name: 'speakerevaluation',
            component: SpeakerEvaluation
        },
        {
            path: '/transcription',
            alias: '/prelegent',
            name: 'transcription',
            component: Transcription
        },
        {
            path: '/lostandfound',
            name: 'lostandfound',
            component: LostAndFound
        },
        {
          path: '/rating',
          name: 'rating',
          component: Rating
      }
    ]
});