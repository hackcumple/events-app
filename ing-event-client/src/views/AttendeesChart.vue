<template>
    <div class="home" v-if="isLoading">
        <Loader/>
    </div>
    <div class="home" v-else>
        <PrelegentMenubar/>
        <div class="wrapper-normal">
            <div class="event-img-cnt"></div>
            <h1>Co nowego w Javie 12? </h1>
            <div class="lecturer-section" style="height: 85vh;">
                <div style="display: flex">
                    <span>
                        40 <br/>
                        30 <br/>
                        20 <br/>
                        10 <br/>
                    </span>
                    <trend
                            :data="[0, 2, 5, 9, 15, 22, 19, 18, 16, 20, 24]"
                            auto-draw
                            smooth>
                    </trend>
                </div>
                <div style="text-align: center;">
                    <span>Time: 5 10 15 20 25 30 35 40 45 50 55 60</span>
                </div>
            </div>
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
