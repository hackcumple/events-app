<template>
  <div class="home" v-if="isLoading">
    <Loader/>
  </div>
  <div class="home" v-else>
    <Menubar/>
    <div class="wrapper-normal agenda">
      <h1>{{ eventName }}</h1>
      <slick ref="carousel" :options="slickOptions" @reInit="reInit" @init="slickInit">
        <div class="track" v-for="(track, key, index) in agenda" v-bind:key="index">
          <h2 class="where">{{ key }}</h2>
          <ul>
            <li v-for="presentation in track" v-bind:key="presentation.id">
              <span class="agenda-line-item agenda-hour">{{ presentation.startHour }}:00</span>
              <span class="agenda-line-item agenda-content">
                <span class="title">{{ presentation.name }}</span>
                <br>
                <span class="speaker">{{ presentation.speaker }}</span>
              </span>
            </li>
          </ul>
        </div>
      </slick>
    </div>
  </div>
</template>

<script>
import Loader from "@/components/Loader.vue";
import Menubar from "@/components/Menubar.vue";
import { AgendaService } from "../common/api-service.js";
import Slick from "vue-slick";

export default {
  name: "directions",
  components: {
    Loader,
    Menubar,
    Slick
  },
  data() {
    return {
      isLoading: true,
      agenda: {},
      slickOptions: {
        slidesToShow: 1,
        arrows: false
      },
    };
  },
  computed: {
    eventName() {
      return this.$store.state.eventData.name
    }
  },
  methods: {
    injectData(agendaData) {
      this.agenda = agendaData.data;
      this.$nextTick(() => {
        console.log("Next tick");
        //  this.$refs.slick.reSlick();
      })
    },
    slickInit() {
      console.log("SLICK INIT");
    },
    reInit() {
      console.log("SLICK REINITI")
      // Helpful if you have to deal with v-for to update dynamic lists
      this.$nextTick(() => {
          this.$refs.slick.reSlick();
      });
    }
  },
  created() {},
  mounted() {
    this.isLoading = false;
    console.log("getting agenda...");
    AgendaService.getAgenda(1).then(this.injectData);
  },
  watch: {
    agenda: function () {
        let currIndex = this.$refs.carousel.currentSlide()

        this.$refs.carousel.destroy()
        this.$nextTick(() => {
          this.$refs.carousel.create()
          this.$refs.carousel.goTo(currIndex, true)
        });
    }
  }
};
// description: "morbi ut odio cras mi pede malesuada in imp
// eventId: 3
// id: 190
// name: "Shock Treatment"
// rate: 1.88
// speaker: "Jan Kowalski"
// startHour: 9
// tag: "AI"
</script>

