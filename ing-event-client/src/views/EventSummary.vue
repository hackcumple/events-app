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
      <h2 class="when">{{ date }}</h2>
      <p>
        {{description}}
      </p>
    </div>
  </div>
</template>

<script>
import Loader from "@/components/Loader.vue";
import Menubar from "@/components/Menubar.vue";

export default {
  name: "event_summary",
  props: ['city', 'date', 'description', 'id', 'name', 'streetName', 'streetNumber'],
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
  created() {
    console.log("SZYNOM3", this.city);
  },
  mounted() {
    this.isLoading = false;
  }
};
</script>
