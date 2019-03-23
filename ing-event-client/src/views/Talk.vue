<template>
  <div class="home" v-if="isLoading">
    <Loader/>
  </div>
  <div class="home" v-else>
    <Menubar/>
    <div class="wrapper-normal">
      <div class="event-img-cnt"></div>
      <h1>Co nowego w Javie 12? </h1>
      <div class="lecturer-section">
        <img class="avatar" src="./../assets/avatar.png" alt="Avatar">
        Zbigniew Stonoga to topowy programista lorem inpsum lorem..,
        Zbigniew Stonoga to topowy programista lorem inpsum lorem..,
      </div>
      <div class="questions">
        <h2>Zadawaj i podbijaj pytania do prelegenta: </h2>
        <ul>
          <li v-for="question in topQuestions">
            {{ question.value }} votes: {{question.votes}}
          </li>
        </ul>
      </div>
      <div>
      Oceń wykład:
        <div class="rank">
          <font-awesome-icon icon="star" size="lg" class="checked"/><br />
          <font-awesome-icon icon="star" size="lg" class="checked"/><br />
          <font-awesome-icon icon="star" size="lg" class="checked"/><br />
          <font-awesome-icon icon="star" size="lg"/><br />
          <font-awesome-icon icon="star" size="lg"/><br />
        </div>
        <div class="comments">
          <textarea></textarea>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Loader from "@/components/Loader.vue";
  import Menubar from "@/components/Menubar.vue";

  export default {
    name: "talk",
    components: {
      Loader,
      Menubar
    },
    data() {
      return {
        isLoading: true,

        topQuestions: [
          {value: "pytanie numer 1?", votes: 5},
          {value: "pytanie numer 1?", votes: 5},
          {value: "pytanie numer 1?", votes: 5},
          {value: "pytanie numer 1?", votes: 5}
        ]
      };
    },
    methods: {
      justDoSomething() {
        console.log("Witam eX");
      }
    },
    created() {},
    mounted() {
      console.log(this.$router);
      this.isLoading = false;
    }
  };
</script>
