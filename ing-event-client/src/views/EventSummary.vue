<template>
  <div class="home" v-if="isLoading">
    <Loader/>
  </div>
  <div class="home" v-else>
    <Menubar/>
    <div class="wrapper-normal">
      <div class="event-img-cnt"></div>
      <h1>Jakiś meetup ING tech ssssdfdsf </h1>
      <h2 class="where">Katowice, Galeria Rondo Sztuki, Rondo im. Jerzego Ziętka 2</h2>
      <h2 class="when">sobota, 23 marca 2019</h2>
      <p>
        Zapraszamy na zajebiste wydarzenie, wśród prelegentów Harry Potter i profesor McGonagall.
      </p>
    </div>
  </div>
</template>

<script>
import Loader from "@/components/Loader.vue";
import Menubar from "@/components/Menubar.vue";

export default {
  name: "event_summary",
  components: {
    Loader,
    Menubar
  },
  data() {
    return {
      isLoading: true
    };
  },
  methods: {
    justDoSomething() {
      console.log("Witam eX");
    }
  },
  created() {},
  mounted() {
    this.isLoading = false;
  }
};
</script>
