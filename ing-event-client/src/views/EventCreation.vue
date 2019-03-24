<template>
  <div class="wrapper-normal darkbg">
    <div class="event-creation-img-cnt"></div>
    <h2>Kreator wydarzeń</h2>
    <div class="wrapper-of-centered-cnt-event-create">
      <div class="centered-ctn">
        <form v-on:submit.prevent="onSubmit" class="questions">
          <h3>Nazwa wydarzenia:</h3>
          <input type="text" name="event-name" placeholder="np. Piknik ING">
          <h3>Opis wydarzenia:</h3>
          <input
            type="text"
            name="event-description"
            placeholder="np. Piknik rodzinny dla pracowników ING. Piwo i mięsiwo za DARMO!"
          >
          <h3>Obrazek:</h3>
          <input type="file" name="event-image">
          <button type="submit">Stwórz wydarzenie</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import Loader from "@/components/Loader.vue";

export default {
  name: "event_creation",
  components: {
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
    }
  },
  created() {
    console.log("SZYNOM3");
  },
  mounted() {
    this.isLoading = false;
  }
};
</script>
