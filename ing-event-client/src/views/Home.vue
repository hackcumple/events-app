<template>
  <div class="home" v-if="isLoading">
    <Loader/>
  </div>
  <div class="home darkbg" v-else>
    <div class="logo">
      <h1>
        ING
        <span>event</span>
      </h1>
    </div>

    <div class="wrapper-of-centered-cnt">
      <div class="centered-cnt">
        <h2>Wpisz nr biletu:</h2>
        <h3>(lub zeskanuj kod)</h3>
        <form v-on:submit.prevent="onSubmit">
          <input type="text" name="ticket-number" placeholder="np. ING-hack323KJHS">
          <button type="submit">zaloguj</button>
        </form>
      </div>
    </div>
  </div>
  <!-- <img alt="Vue logo" src="../assets/logo.png">
  <HelloWorld msg="Welcome to Your Vue.js App"/>-->
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
import Loader from "@/components/Loader.vue";
import { setTimeout } from "timers";
import { TestApi } from "../common/api-service.js";
import { TicketService } from "../common/api-service.js";

export default {
  name: "home",
  components: {
    HelloWorld,
    Loader
  },
  data() {
    return {
      isLoading: true
    };
  },
  methods: {
    justDoSomething() {
      
      console.log("Witam eX");
    },

    proceedToEventPage(eventData) {
      this.$router.push({
          name: 'event-summary',
          params: eventData.data
        })
    },

    onSubmit(e) {
      console.log("ev", e);
      const input = document.querySelector('input[name=ticket-number]')
      // console.log(input.value);
      TicketService.login(input.value).then(this.proceedToEventPage);
    }
  },
  created() {
    console.log("SZYNOM");
    // TestApi.testAPI2();
  },
  mounted() {
    this.isLoading = false;
  }
};
</script>
