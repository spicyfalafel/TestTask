<script>

export default {
  props: ['viruses'],
}

</script>

<template>
  <b-container class="border m-3">
    <b-table striped hover :items="viruses">
      <template v-slot:cell(type)="row">
        <b-form-input v-model="row.item.type"/>
      </template>
      <template v-slot:cell(virusName)="row">
        <b-form-input v-model="row.item.virusName"/>
      </template>
      <template v-slot:cell(infectProb)="row">
        <b-form-input v-model="row.item.infectProb"/>
      </template>

      <template v-slot:cell(infectDaysAvg)="row">
        <b-form-input v-model="row.item.infectDaysAvg"/>
      </template>
      <template v-slot:cell(deathRate)="row">
        <b-form-input v-model="row.item.deathRate"/>
      </template>
      <template v-slot:cell(reinfectionChance)="row">
        <b-form-input v-model="row.item.reinfectionChance"/>
      </template>
    </b-table>
  </b-container>
</template>

<style scoped>

</style>