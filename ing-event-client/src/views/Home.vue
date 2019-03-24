<template>
  <div class="home" v-if="isLoading">
    <Logo/>
    <Loader/>
  </div>
  <div class="home darkbg" v-else>
    <Logo/>
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
import Logo from "@/components/Logo.vue";
import { setTimeout } from "timers";
import { TestApi } from "../common/api-service.js";
import { TicketService } from "../common/api-service.js";

export default {
  name: "home",
  components: {
    HelloWorld,
    Loader,
    Logo
  },
  data() {
    return {
      isLoading: true
    };
  },
  methods: {
    proceedToEventPage(eventData) {
      this.$store.commit('chooseEvent', eventData.data);
      this.$cookies.set("eventId", eventData.data.id);  
      this.$router.push({
          name: 'event-summary',
        });
    },
    simulateLoading() {
      this.isLoading = false; 
    },

    onSubmit(e) {
      console.log("ev", e);
      const input = document.querySelector('input[name=ticket-number]')
      // console.log(input.value);
      TicketService.login(input.value).then(this.proceedToEventPage);

        this.$router.push({
            name: 'talk',
            params: {
                talkId: '10'
            }
        });
    }
  },
  created() {
  },
  mounted() {
    setTimeout(this.simulateLoading, 1100);
  }
};
</script>
