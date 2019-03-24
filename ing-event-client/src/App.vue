<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import { TicketService } from "./common/api-service.js";

export default {
  methods: {
    prefetchEventData(eventData) {
      this.$store.commit('chooseEvent', eventData.data);
      this.$cookies.set("eventId", eventData.data.id);
    }
  },
  created() {
    if (this.$cookies.isKey("eventId"))
    {
      TicketService.login(this.$cookies.get("eventId")).then(this.prefetchEventData);
    }
  }
}
</script>

<style lang="scss">
  @import 'src/scss/normalize';
  @import 'src/scss/main';
  @import 'src/scss/loader';

  @import '../node_modules/slick-carousel/slick/slick.css';
</style>