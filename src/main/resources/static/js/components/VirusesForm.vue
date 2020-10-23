<script>


export default {
  props: ['viruses'],
  data() {
    return {
      virusName: '',
      type: '',
      infectProb: '',
      infectDaysAvg: '',
      deathRate: '',
      reinfectionChance: ''
    }
  },
  methods: {
    save: function () {
      let virus = {
        virusName: this.virusName,
        type: this.type,
        infectProb: this.infectProb,
        infectDaysAvg: this.infectDaysAvg,
        deathRate: this.deathRate,
        reinfectionChance: this.reinfectionChance
      }
      this.$resource('/api/v1/viruses/{id}').save({}, virus)
          .then(result => result.json().then(data => {
            this.viruses.push(data)
          }))
    },
    isNumber: function isNumber (evt){
      const keysAllowed= ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
      const keyPressed = evt.key;
      if (!keysAllowed.includes(keyPressed)) {
        evt.preventDefault()
      }
    },
    del: function (){
      this.$resource('/api/v1/viruses/{id}').delete({})
          .then(result => result.json().then(data => {
            this.viruses.push(data)
          }))
    },
  }
}
</script>
<template>
  <b-container class="border border-dark mt-3">
    <h2>Virus name</h2>
    <input type="text" v-model="virusName"/>
    <h2>Type</h2>
    <select v-model="type">
      <option disabled value="">Please select one</option>
      <option>DNA</option>
      <option>RNA</option>
      <option>RETROVIRUS</option>
    </select>

    <h2>Infection probability</h2>
    <b-form-input type="number" v-model.number="infectProb"/>
    <h2>Infection days average</h2>
    <b-form-input v-model.number="infectDaysAvg" @keypress="isNumber($event)" type="number"></b-form-input>
    <h2>Death rate</h2>
    <b-form-input type="number" v-model.number="deathRate"/>
    <h2>Reinfection chance</h2>
    <b-form-input type="number" v-model.numbre="reinfectionChance"/>

    <b-button @click="save">Save</b-button>

  </b-container>
</template>

