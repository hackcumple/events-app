<template>
  <div class="menubar">
    <router-link to="/event-summary">
      <font-awesome-icon icon="list-alt" size="2x" /><br />
      <span>Event</span>
    </router-link>
    <router-link to="/directions">
      <font-awesome-icon icon="map" size="2x" /><br />
      <span>Miejsce</span>
    </router-link>
    <router-link to="/agenda">
      <font-awesome-icon icon="list-alt" size="2x" /><br />
      <span>Agenda</span>
    </router-link>
    <router-link to="/talk">
      <font-awesome-icon icon="ticket-alt" size="2x" /><br />
      <span>Wykład</span>
    </router-link>
    <router-link to="/info">
      <font-awesome-icon icon="info-circle" size="2x" /><br />
      <span>Info</span>
    </router-link>
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
    justify-content: space-between;
    height: 70px;
    position: fixed;
    bottom: 0;
    width: 100vw;
    z-index: 90;
  }
  a {
    color: #fff;
    text-decoration: none;
    text-align: center;
    font-size: 0.8rem;
    padding: 10px 0 10px 0;
    font-family: 'Signika', sans-serif;
    transition: all 1s;
    width: 25%;
    background-color: rgb(230, 102, 17);

    span {
      text-transform: uppercase;
    }

    svg {
      margin-bottom: 10px;
    }

    &.router-link-active {
      background-color: rgb(89, 3, 146);
    }
  }
</style>
