<template>
  <div class="wrapper-normal">
    <div>
      <input
        type="file"
        id="imageInput"
        name="avatar"
        accept="image/png, image/jpeg"
        v-on:change="setCanvasImage()"
      >
      <img id="image" width="220" height="277" src="../common/image.jpg" alt="The Scream">
    </div>
  </div>
</template>

<script>
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
    setCanvasImage() {
     
      if (canvas.getContext) {
        const ctx = canvas.getContext("2d");

        //Loading of the home test image - img1
        var img1 = new Image();
        img1.src = "../common/image.jpg";
        //drawing of the test image - img1
        img1.onload = function() {
            console.log("szymonidas");
          //draw background image
          ctx.drawImage(img1, 0, 0);
          //draw a box over the top
          ctx.fillStyle = "rgba(200, 0, 0, 0.5)";
          ctx.fillRect(0, 0, 500, 500);
        };

        
      }
    }
  },

  created() {},
  mounted() {
    this.isLoading = false;
    //this.ctx = document.getElementById("canvas").getContext("2d");
  }
};
</script>