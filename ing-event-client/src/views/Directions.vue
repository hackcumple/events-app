<template>
  <div class="home" v-if="isLoading">
    <Loader/>
  </div>
  <div class="home" v-else>
    <Menubar/>
    <div class="wrapper-normal">
      <h1>Wydarzonko name</h1>
      <h2 class="where">Katowice, Galeria Rondo Sztuki, Rondo im. Jerzego Ziętka 2</h2>
      <div class="img-cnt">
        <img src="../assets/map.png">
      </div>
      
    </div>
  </div>
</template>

<script>
import Loader from "@/components/Loader.vue";
import Menubar from "@/components/Menubar.vue";

export default {
  name: "directions",
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
