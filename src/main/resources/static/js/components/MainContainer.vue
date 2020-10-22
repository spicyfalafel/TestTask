<template>
  <div id="cont" class="text-center container-fluid">
    <b-row>
      <b-col>
        <virusesTable :viruses="viruses"/>
        <b-button class="m-3" @click="update">Confirm updating</b-button>
        <b-button @click="delRandom()">Delete smth</b-button>
      </b-col>
      <b-col>
        <h2>Save new </h2>
        <viruses-form :viruses="viruses"/>
      </b-col>
    </b-row>

  </div>
</template>

<script>
import VirusesTable from "../components/VirusesTable.vue";
import VirusesForm from "../components/VirusesForm.vue";

export default {
  components: {
    VirusesTable,
    VirusesForm
  },
  props: ['viruses'],
  created: function () {
    this.$resource('/api/v1/viruses/{id}').get().then(result => {
      if (result.status === 200) {
        return result.json()
      }
    })
        .then(data => {
          data.forEach(virus => this.viruses.push(virus))
        }).catch(error => {
      console.log(error)
    })
  },
  methods: {
    update: function () {
      this.$resource('/api/v1/viruses/{id}').update(this.viruses)
          .then(result => result.json())
          .then(data => {
            if(data.ok){
              console.log(data)
            }
          })
    },
    delRandom: function () {
      let ids = this.viruses.map(v => v.id);
      console.log("ids: " + ids);
      let rnd = ids[Math.floor(Math.random() * ids.length)];
      console.log("rnd: " + rnd);
      this.$resource('/api/v1/viruses/{id}').remove({id: rnd})
          .then(data => {
            let chosen = this.viruses.filter(v => v.id === rnd)[0]
            console.log("chosen:" + chosen)
            this.viruses.splice(this.viruses.indexOf(chosen), 1)
            console.log("delrandom: " + data)
          })
    }
  }
}
</script>

<style>

</style>