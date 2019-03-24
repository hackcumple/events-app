<template>
  <div>
    <h2 class="when">Notatki z wykładu</h2>
    <input type="text" name="note" v-on:keypress="onKeypress" placeholder="Zapisz, bo zapomnisz :)" />
    <ul>
      <li v-for="note in list">
        {{ note }} <a target="_blank" :href="'https://www.google.com/search?q=' + note">[szukaj z G]</a>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "LectureNotes",
  data() {
    return {
      isLoading: true,
      ...this.$store.state.lectureNotes
    };
  },
  methods: {
    onKeypress(e) {
      if (e.keyCode == 13) {
        var noteInput = document.querySelector('input[name=note]');
        this.addNote(noteInput.value);
        noteInput.value = "";
      }
    },
    addNote(txt) {
      this.$store.commit('addNote', txt);
    }
  }
};
</script>

<style scoped lang="scss">
input {
  margin-top: 10px;
  border: 1px solid #222;
  color: #222;
}
</style>
