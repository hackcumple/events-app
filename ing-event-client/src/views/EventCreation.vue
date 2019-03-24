<template>
  <div class="wrapper-normal darkbg">
    <AdminMenubar/>
    <div class="event-creation-img-cnt"></div>
    <h2>Kreator wydarzeń</h2>
    <div class="wrapper-of-centered-cnt-event-create">
      <div class="centered-ctn">
        <form v-on:submit.prevent="onSubmit">
          <h3>Nazwa wydarzenia:</h3>
          <input type="text" name="event-name">
          <h3>Opis wydarzenia:</h3>
          <input
            type="text"
            name="event-description"
          >
           <h3>Domena:</h3>
          <input type="text" name="event-name">
           <h3>Miejsce:</h3>
          <input type="text" name="event-name">
          <button type="submit" style="display: grid; width: 100%;">Stwórz wydarzenie</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import Loader from "@/components/Loader.vue";
import AdminMenubar from "../components/AdminMenubar";

export default {
  name: "event_creation",
  components: {
    Loader,
    AdminMenubar
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
