<template>
  <div class="home" v-else>
    <PrelegentMenubar/>
    <div class="wrapper-normal">
      <div class="event-img-cnt"></div>
      <h1>Ocena przebiegu prezentacji</h1>
      <div class="rating-chart">
        <bar-chart :chart-data="datacollection"></bar-chart>
      </div>
      <!--<div class="questions">-->
      <!--<h2>Najczęściej powtarzane słowa: </h2>-->
      <!--</div>-->
    </div>
  </div>

  <!--<div class="wrapper-of-centered-cnt darkbg">-->
  <!--<PrelegentMenubar/>-->
  <!--<div class="event-img-cnt"></div>-->

  <!--<div class="centered-cnt">-->
  <!--<h1>Ocena przebiegu prezentacji</h1>-->
  <!--<bar-chart :chart-data="datacollection"></bar-chart>-->
  <!--</div>-->
  <!--</div>-->
</template>

<script>
import BarChart from "../components/LineChart.js";
import PrelegentMenubar from "@/components/PrelegentMenubar.vue";

export default {
  components: {
    BarChart,
    PrelegentMenubar
  },
  data() {
    return {
      datacollection: null
    };
  },
  mounted() {
    this.fillData();
  },
  methods: {
    fillData() {
      this.datacollection = {
        labels: ["0 - 15 min", "15 - 30 min", "30 - 45 min", "45 - 60 min"],
        datasets: [
          {
            label:
              "Średnia ocen przyznanych przez uczestników w kolejnych etapach prezentacji",
            backgroundColor: "#e66611",
            data: [
             2,5,3,0
            ]
          }
        ],
        scales: {
          yAxes: [
            {
              ticks: {
                stepSize: 1,
                maxTicksLimit: 1
              }
            }
          ]
        }
      };
    },
    getRandomInt() {
      return Math.floor(Math.random() * (5 - 1) + 1);
    }
  }
};
</script>

<style>
.small {
  max-width: 600px;
  margin: 150px auto;
}
</style>