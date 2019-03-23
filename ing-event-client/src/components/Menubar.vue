<template>
  <div class="menubar">
    <router-link to="/">Home</router-link>|
    <router-link to="/about">About</router-link>
    <router-link to="/agenda">Agenda</router-link>
    <router-link to="/directions">Directions</router-link>
    <router-link to="/event-summary">EventSummary</router-link>
    <router-link to="/talk">Talk</router-link>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  props: {
    msg: String
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
  .menubar {
    display: flex;
    height: 50px;
    background: #fff;
  }
  a {
    color: red;
    text-decoration: none;
    
  }
</style>
