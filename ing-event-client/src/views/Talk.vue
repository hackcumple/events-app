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
        Rafał Jankowski <br>Po pierwsze: programista-pasjonat.<br> Człowiek od wszystkiego związanego z programowaniem.
      </div>
      <div class="questions">
        <h2>Zadawaj i podbijaj pytania do prelegenta: </h2>
        <ul>
          <li v-for="(question, index) in sortedQuestions">
              <p>{{index+1}}. {{ question.value }}</p>
              <div style="float: right">
                  <p>votes: {{question.votes}}</p>
                  <font-awesome-icon icon="thumbs-up" size="lg" v-on:click="voteUp(question)"/><br/>
              </div>
          </li>
        </ul>

        <div>
          <div style="display: grid;">
            <button>Zadaj pytanie</button>
          </div>
        </div>
      </div>
      <div class="rank-wrapper">
        <h2 style="color: black;">Oceń wykład:</h2>
        <div class="rank">
          <font-awesome-icon icon="star" size="lg" class="checked"/><br />
          <font-awesome-icon icon="star" size="lg" class="checked"/><br />
          <font-awesome-icon icon="star" size="lg" class="checked"/><br />
          <font-awesome-icon icon="star" size="lg"/><br />
          <font-awesome-icon icon="star" size="lg"/><br />
        </div>
        <div class="comments">
          <textarea placeholder="Napisz komentarz..."></textarea>
        </div>
        <div>
          <div style="display: grid;">
            <button>Dodaj komentarz</button>
          </div>
        </div>
      </div>
    </div>
      <div style="background-color: rgb(224, 142, 107);">
        <h2 style="margin: 0;">Podgląd na żywo:</h2>
        <video class="streaming"></video>
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
          {value: "java czy javascript?", votes: 5},
          {value: "kotlin czy scala?", votes: 4},
          {value: "co to java?", votes: 3},
          {value: "co to kod?", votes: 2},
          {value: "aaaaaaaaaa?", votes: 1}
        ]
      };
    },
    methods: {
      streamingVideo(){
        let video = document.querySelector('video');
        let constraints={
          video:true,
          audio:false
        };
        navigator.mediaDevices.getUserMedia(constraints).then(function(stream){
          video.srcObject=stream;
          video.play();
        }).catch(function(err){
        });
      },

      voteUp(question) {
        question.votes +=1;

      }
    },
    computed: {
      sortedQuestions: function() {
        return this.topQuestions.sort(function(x, y) {
          return y.votes- x.votes;
        });
      }
    },
    created() {
    },
    mounted() {
      this.isLoading = false;
    },
    updated() {
        this.streamingVideo();
    },
  };
</script>
