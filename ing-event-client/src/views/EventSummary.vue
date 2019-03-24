<template>
  <div class="home" v-if="isLoading">
    <Loader/>
  </div>
  <div class="home" v-else>
    <Menubar/>
    <div class="wrapper-normal">
      <div class="event-img-cnt"></div>
      <h1>{{ name }}</h1>
      <h2 class="where">{{ city }}, {{ streetName }} {{ streetNumber }} </h2>
      <h2 class="when">sobota, 8 kwietnia 2019</h2>
      <p>
        <br>
        Pełen praktycznych prelekcji. Stawiamy na jakość i odpowiadamy na aktualne potrzeby szkoleniowe społeczności IT w całej Polsce.
        <br>
        <br>
        .NET, Architektury aplikacji, Bottega IT Minds, Bottega Frontend, C++, Cloud Computing, Data science, Java, JavaScript, Mobile, PHP, Python, Soft Skills & business relations – zapewniamy najlepszych praktyków z wybranych dziedzin.
        <br>
        <br>
        Zapraszamy najbardziej znanych wyjadaczy IT ! Znacie ich z ogólnopolskiej edycji 4Developers.


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
      isLoading: true,
      ...this.$store.state.eventData
    };
  },
  methods: {
    justDoSomething() {
      console.log("Witam eX");
    }
  },
  created() {
    console.log("SZYNOM3", this.city);
  },
  mounted() {
    this.isLoading = false;
  }
};
</script>
