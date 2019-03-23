<template>
  <div class="home" v-if="isLoading">
    <Loader/>
  </div>
  <div class="home" v-else>
    <Menubar/>
    <div class="wrapper">
      <div class="centered-cnt">
        <h1>nAZWA EVENTU:</h1>
        <p>
          Cośtam cośtam
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import Loader from "@/components/Loader.vue";
import Menubar from "@/components/Menubar.vue"

export default {
  name: "event_summary",
  components: {
    Loader,
    Menubar
  },
  data() {
    return {
      isLoading: true
    }
  },
  methods: {
    justDoSomething() {
      console.log("Witam eX");
    }
  },
  created() {

  },
  mounted() {
    this.isLoading = false
  }
};



</script>
