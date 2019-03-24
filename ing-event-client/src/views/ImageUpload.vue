<template>
  <div class="wrapper-of-centered-cnt">
    <div class="centered-cnt">
      <img class="img-upload" id="ItemPreview" src>
      <input type="file" name="file" required>
      <button v-on:click="onSubmit()">Submit</button>
      <h2>Ilość uczestników:{{numberOfPeople}}</h2>
    </div>
  </div>
</template>

<script>
import { ImageRecognitionService } from "../common/api-service.js";

export default {
  props: ["numberOfPeople"],
  name: "directions",
  components: {},
  data() {
    return {
      isLoading: true
    };
  },
  methods: {
    justDoSomething() {
      console.log("Witam eX");
    },

    onSubmit(callback) {
      //get the input and the file
      var input = document.querySelector("input[type=file]"),
        file = input.files[0];
      var fd = new FormData();
      fd.append("file", file);
      var response = ImageRecognitionService.uploadPhoto(fd);
      document.getElementById("ItemPreview").src =
        "data:image/png;base64," + response;
      this.numberOfPeople = response.number;
    }
  },

  created() {},
  mounted() {
    this.isLoading = false;
    //this.ctx = document.getElementById("canvas").getContext("2d");
  }
};
</script>