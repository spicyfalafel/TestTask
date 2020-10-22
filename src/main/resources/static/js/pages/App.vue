<template>
  <div>
    <main-container :viruses="viruses"/>
  </div>
</template>

<script>

import MainContainer from "../components/MainContainer.vue";

export default {
  data() {
    return {
      viruses: []
    }
  },
  components: {
    MainContainer
  }
}
</script>

<style>

</style>