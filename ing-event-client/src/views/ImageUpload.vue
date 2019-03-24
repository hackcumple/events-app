<template>
  <div class="home" v-if="isLoading">
    <Loader/>
  </div>
  <div class="home" v-else>
    <Menubar/>
    <div class="wrapper-normal">
      <div class="event-img-cnt"></div>
      <h1>Ile osób było obecnych na wykładzie?</h1>
      <div class="file-upload-section">
          <input id="file-upload" type="file" name="file" required style="display: none;">
          <label for="file-upload">Załaduj zdjęcie</label>
          <button v-on:click="onSubmit()">Submit</button>
      </div>
        <div class="face-recognition-container">
            <h2>Ilość rozpoznanych uczestników: {{numberOfPeople}}</h2>
            <img id="ItemPreview" src="">
      </div>
    </div>
  </div>
</template>

<script>
  import Loader from "@/components/Loader.vue";
  import Menubar from "@/components/Menubar.vue";
  import { ImageRecognitionService } from "../common/api-service.js";

export default {
  name: "imageUpload",
  components: {
    Loader,
    Menubar
  },
  data() {
    return {
      isLoading: true,
      numberOfPeople : 0
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
      ImageRecognitionService.uploadPhoto(fd)
              .then((response) => {
                document.getElementById("ItemPreview").src ="data:image/png;base64," +  response.data.image;
                this.numberOfPeople = response.data.numberOfPeople;
              }).catch((error) => {
                //handle error
              });
    }
  },

  created() {},
  mounted() {
    this.isLoading = false;
    //this.ctx = document.getElementById("canvas").getContext("2d");
  }
};
</script>