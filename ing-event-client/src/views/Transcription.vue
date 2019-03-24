<template>
    <div class="home" v-if="isLoading">
        <Loader/>
    </div>
    <div class="home" v-else>
        <Menubar/>
        <div class="wrapper-normal">
            <div class="event-img-cnt"></div>
            <h1>Transkrypcja </h1>

            <div class="questions">
                <h2>Najczęściej powtarzane słowa: </h2>
                <ul>
                    <li style="color: white;" v-for="(question, index) in sortedQuestions" >

                        <p v-if="index==1 || index==4">{{index+1}}. {{ question.value }}</p>
                        <div style="float: right" v-if="index==1 || index==4" >
                            <p> {{question.amount}}</p>
                        </div>

                        <p v-if="index!=1 && index!=4" style="color: yellow;">{{index+1}}. {{ question.value }}</p>
                        <div style="color: yellow; float: right" v-if="index!=1 && index!=4">
                            <p> {{question.amount}}</p>
                        </div>
                    </li>

                </ul>
            </div>
        </div>
        <a href="./../assets/transcript.pdf" download="transcript.pdf">
            <img style="height: 100px; display: block; margin: auto;" src="./../assets/transcript.png" alt="Transcript">
        </a>
    </div>

</template>

<script>
  import Loader from "@/components/Loader.vue";
  import Menubar from "@/components/Menubar.vue";
  import {TranscriptionService} from "../common/api-service.js";


  export default {
    name: "transcription",
    components: {
      Loader,
      Menubar
    },
    data() {
      return {
        isLoading: true,
        topQuestions: [],
        // topQuestions: [
        //   {value: "noo", amount: 5},
        //   {value: "Java", amount: 4},
        //   {value: "poniewaz", amount: 3},
        //   {value: "Spring", amount: 2},
        //   {value: "Misiu", amount: 1}
        // ]
      };
    },
    methods: {
      justDoSomething() {
      },
      injectData(transcription) {
        // this.agenda = transcription.data;

        this.topQuestions = transcription.data.wordDetails.map(function (i) { return{
          value: i.word, amount: i.count
        } })

        console.log(transcription.data.wordDetails);
      },
    },
    computed: {
      sortedQuestions: function () {
        return this.topQuestions.sort(function (x, y) {
          return y.amount - x.amount;
        });
      }
    },
    created() {
    },
    mounted() {
      this.isLoading = false;
      TranscriptionService.getTranscription().then(this.injectData);
    },
    updated() {

    },
  };
</script>
