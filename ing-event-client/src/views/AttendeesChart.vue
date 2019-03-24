<template>
    <div class="home" v-if="isLoading">
        <Loader/>
    </div>
    <div class="home" v-else>
        <PrelegentMenubar/>
        <div class="wrapper-normal">
            <div class="event-img-cnt"></div>
            <h1>Co nowego w Javie 12? </h1>
            <div class="attendees-chart-title">Zależność liczby uczestników od czasu prezentacji.</div>
            <img class="attendees-chart" src= '../assets/chart1.png'  >

        </div>
    </div>

</template>

<script>
    import Loader from "@/components/Loader.vue";
    import PrelegentMenubar from "@/components/PrelegentMenubar.vue";
    import Vue from 'vue';
    import Trend from 'vuetrend';
    Vue.use(Trend);

    export default {
        name: "attendees",
        components: {
            Loader,
          PrelegentMenubar,
    },
        data() {
            return {
                isLoading: true
            };
        },
        methods: {
            justDoSomething() {
            },
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
