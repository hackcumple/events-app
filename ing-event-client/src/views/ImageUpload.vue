<template>
  <div class="wrapper-normal">
    <label>File to stash:</label>
    <img id="ItemPreview" src>
    <input type="file" name="file" required>
    <button v-on:click="onSubmit()">Submit</button>
  </div>
</template>

<script>
import { ImageRecognitionService } from "../common/api-service.js";

export default {
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
      var byteArrResponse = ImageRecognitionService.uploadPhoto(fd);
      document.getElementById("ItemPreview").src =
        "data:image/png;base64," + byteArrResponse;
    }
  },

  created() {},
  mounted() {
    this.isLoading = false;
    //this.ctx = document.getElementById("canvas").getContext("2d");
  }
};
</script>